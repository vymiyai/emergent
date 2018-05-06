package com.memoriesofwar.emergent;

import com.memoriesofwar.emergent.commands.IBotCommand;
import com.memoriesofwar.emergent.entities.Battle;
import com.memoriesofwar.emergent.entities.Faction;
import com.memoriesofwar.emergent.entities.Unit;
import com.memoriesofwar.emergent.repositories.*;
import com.memoriesofwar.emergent.resources.OverworldResource;
import com.memoriesofwar.emergent.units.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.util.DiscordException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CommandHandler {

    private static final Logger log = LoggerFactory.getLogger(CommandHandler.class);

    private String botUserName = "Arenagma";
    private String playingText = "March of Words";

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

    @Autowired
    private BattalionRepository battalionRepository;

    @Autowired
    private BasicBattleEngine basicBattleEngine;

    private List<Unit> attackers;
    private List<Unit> defenders;

    private int round = 0;

    private HashMap<String, IBotCommand> basicCommands;

    @Autowired
    public void setBasicCommands(List<IBotCommand> injectedBasicCommands) {
        this.basicCommands = new HashMap<String, IBotCommand>();

        for (IBotCommand command : injectedBasicCommands)
            this.basicCommands.put(command.getCommandName(), command);
    }

    private String[] tokenize(String messageString) {

        return messageString.split(" ");
    }

    private boolean isDefinedCommand(String commandToken) {
        return this.basicCommands.containsKey(commandToken);
    }

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

    private String resolveOverworld() {
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
            result.append(battle.toString() + " - " + battle.getTerritory().getName() + "\n");

        result.append("```");
        return result.toString();
    }

    @Scheduled(fixedRate = 2000)
    public void resolve() {

        if(stats == null)
            return;

        String overworldStatus = this.resolveOverworld();
        stats.edit(overworldStatus);



/*
        StringBuilder result = new StringBuilder();
        //result.append("*resolving...*");

        result.append("Round " + round + "\n\n");
        result.append("Attackers: \n\n");
        for(Unit unit : attackers)
            result.append(unit + "\n");

        result.append("\n\n");
        result.append("Defenders: \n\n");
        for(Unit unit : defenders)
            result.append(unit + "\n");

        basicBattleEngine.resolve(attackers, defenders);

        if(attackers.size() != 0 && defenders.size() != 0)
            round++;

        stats.edit(result.toString());
        */
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
                    channel.bulkDelete();
                    stats = channel.sendMessage(placeholder);
                }

            } catch (DiscordException e) {
                log.error(e.getErrorMessage());
            }
        });
    }
}
