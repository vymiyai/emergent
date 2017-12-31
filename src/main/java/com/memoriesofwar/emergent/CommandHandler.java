package com.memoriesofwar.emergent;

import com.memoriesofwar.emergent.database.*;
import com.memoriesofwar.emergent.resources.OverworldResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.obj.Channel;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CommandHandler {

    private static final Logger log = LoggerFactory.getLogger(CommandHandler.class);

    private String botUserName = "Arenagma";
    private String playingText = "playing MoW";

    private String placeholder = "*resolving...*";

    private IMessage stats;

    @Value("${discord.TARGET_CHANNEL}")
    private String targetChannel;

    @Autowired
    private FactionRepository factionRepository;

    @Autowired
    private TerritoryRepository territoryRepository;

    @Autowired
    private BattleRepository battleRepository;

    @Autowired
    private OverworldResource overworldResource;

    /*
    @EventSubscriber
    public void onMessageReceived(MessageReceivedEvent event) {

        String messageString = event.getMessage().getContent();
        String[] tokenizedMessage = this.tokenize(messageString);
        String commandToken = tokenizedMessage[0].toLowerCase();

        if (isDefinedCommand(commandToken)) {
            IBotCommand command = this.basicCommands.get(commandToken);
            command.execute(tokenizedMessage, event);
        }

        // do nothing if there is no command match.
    }

    @EventSubscriber
    public void onUserJoined(UserJoinEvent event) {
        IUser user = event.getUser();
        IRole selectFaction = event.getGuild().getRolesByName("Select Faction").get(0);
        user.addRole(selectFaction);

        String response = String.format(this.getWelcomeMessage(), user.mention());

        try {
            event.getGuild().getGeneralChannel().sendMessage(response);
        } catch (DiscordException e) {
            log.error(this.errorMessage, e);
        }
    }
    */

    @Scheduled(fixedRate = 1500)
    public void resolve() {

        if(stats == null)
            return;

        overworldResource.resolve();

        StringBuilder result = new StringBuilder();

        List<Faction> factions = (List<Faction>) factionRepository.findAll();

        result.append("```Overworld statistics:\n");
        result.append("\nNumber of territories per faction:\n");
        for(Faction faction : factions)
            result.append(faction.getName() + ": " + territoryRepository.countByFaction(faction) + "\n");

        result.append("\nOngoing battles:\n");
        List<Battle> battles = (List<Battle>) battleRepository.findAll();

        for(Battle battle : battles)
            result.append(battle.toString() + " - Battle for " + battle.getTerritory().getName() + "\n");

        result.append("\nTerritories on cooldown:\n");
        List<Territory> territoriesOnCooldown = territoryRepository.findByCooldownGreaterThan(0);

        for(Territory territory : territoriesOnCooldown)
            result.append(territory.getName() + " : " + territory.getCooldown() + "\n");

        result.append("```");

        stats.edit(result.toString());
    }

    @EventSubscriber
    public void onSelfJoined(ReadyEvent event) {

        event.getClient().getGuilds().forEach((guild) -> {
            try {

                IDiscordClient client = event.getClient();
                client.changeUsername(botUserName);
                client.changePlayingText(playingText);

                log.info("Trying to access channel " + targetChannel);
                List<IChannel> channels = guild.getChannelsByName(targetChannel);

                for(IChannel channel : channels) {
                    stats = channel.sendMessage(placeholder);
                }

            } catch (DiscordException e) {
                log.error(e.getErrorMessage());
            }
        });
    }
}
