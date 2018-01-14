package com.memoriesofwar.emergent.commands;

import com.memoriesofwar.emergent.entities.Faction;
import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.repositories.FactionRepository;
import com.memoriesofwar.emergent.repositories.PlayerRepository;
import com.memoriesofwar.emergent.utils.Factions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class JoinCommand implements IBotCommand{

    private FactionRepository factionRepository;

    private PlayerRepository playerRepository;

    public JoinCommand() {}

    @Autowired
    public JoinCommand(FactionRepository factionRepository, PlayerRepository playerRepository) {
        this.factionRepository = factionRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public void execute(String[] tokenizedMessage, MessageReceivedEvent event) {

        IGuild guild = event.getGuild();
        IUser user = event.getAuthor();
        if(guild == null)
            user.getOrCreatePMChannel().sendMessage("```The ?join command must be used in the March of War server.```");

        Long playerId = user.getLongID();
        Player player = playerRepository.findOne(playerId);

        if(player != null) {
            user.getOrCreatePMChannel().sendMessage("```You are already registered in ARENAgma.```");
        } else {
            List<IRole> roles = event.getAuthor().getRolesForGuild(guild);
            Optional<IRole> factionRole = roles.stream().filter(role -> Factions.FACTIONS.contains(role.getName())).findFirst();

            if (factionRole.isPresent()) {
                Faction faction = factionRepository.findByName(factionRole.get().getName());
                Player newPlayer = new Player(playerId, faction);
                playerRepository.save(newPlayer);

                StringBuilder message = new StringBuilder();
                message.append("```");
                message.append(user.getName());
                message.append(" has joined ARENAgma.\n\n");
                message.append("A battalion of Volunteers is now at your disposal.\n\n");
                message.append("Type ?battalions to view your existing battalions.```");
                user.getOrCreatePMChannel().sendMessage(message.toString());
            } else {
                user.getOrCreatePMChannel().sendMessage("```No faction role assigned to player.```");
            }
        }

        event.getMessage().delete();
    }

    @Override
    public String getCommandName() {
        return "?join";
    }

    @Override
    public String getCommandDescription() {
        return "Type ?join to join the ARENAgma. Must be issued in the March of War Discord server.";
    }
}
