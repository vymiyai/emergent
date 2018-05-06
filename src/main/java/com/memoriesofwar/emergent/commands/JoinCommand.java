package com.memoriesofwar.emergent.commands;

import com.memoriesofwar.emergent.entities.*;
import com.memoriesofwar.emergent.repositories.*;
import com.memoriesofwar.emergent.units.Volunteers;
import com.memoriesofwar.emergent.utils.Factions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.*;

import javax.transaction.Transactional;
import java.util.*;

@Component
public class JoinCommand implements IBotCommand{

    private FactionRepository factionRepository;

    private PlayerRepository playerRepository;

    private UnitRepository unitRepository;

    private BattalionRepository battalionRepository;

    private TerritoryRepository territoryRepository;

    private BattleRepository battleRepository;

    public JoinCommand() {}

    @Autowired
    public JoinCommand(FactionRepository factionRepository, PlayerRepository playerRepository, UnitRepository unitRepository, BattalionRepository battalionRepository, TerritoryRepository territoryRepository, BattleRepository battleRepository) {
        this.factionRepository = factionRepository;
        this.playerRepository = playerRepository;
        this.unitRepository = unitRepository;
        this.battalionRepository = battalionRepository;
        this.territoryRepository = territoryRepository;
        this.battleRepository = battleRepository;
    }

    @Override
    @Transactional
    public void execute(String[] tokenizedMessage, MessageReceivedEvent event) {

        IGuild guild = event.getGuild();
        IUser user = event.getAuthor();
        if(guild == null) {
            user.getOrCreatePMChannel().sendMessage("```The ?join command must be used in the March of War server.```");
            return;
        }

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

                ArrayList<Unit> volunteers = new ArrayList<>();
                volunteers.add(Volunteers.instantiateFor(newPlayer));
                volunteers.add(Volunteers.instantiateFor(newPlayer));
                volunteers.add(Volunteers.instantiateFor(newPlayer));
                volunteers.add(Volunteers.instantiateFor(newPlayer));
                volunteers.add(Volunteers.instantiateFor(newPlayer));

                unitRepository.save(volunteers);

                Battalion volunteerBattalion = new Battalion(newPlayer, volunteers);

                Territory nexus = territoryRepository.findByName("Nexus");
                volunteerBattalion.setCurrentLocation(nexus);

                Battle tutorialBattle = new Battle(nexus, newPlayer.getFaction(), factionRepository.findByName("Gohou Ichiu"));
                battleRepository.save(tutorialBattle);
                nexus.setInBattle(true);

                battalionRepository.save(volunteerBattalion);

                StringBuilder message = new StringBuilder();
                message.append("```");
                message.append(user.getName());
                message.append(" has joined ARENAgma.\n\n");
                message.append("A battalion of Volunteers is now at your disposal. Type ?battalions to view your existing battalions.```");

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
