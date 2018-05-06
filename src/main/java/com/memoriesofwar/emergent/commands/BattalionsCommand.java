package com.memoriesofwar.emergent.commands;

import com.memoriesofwar.emergent.entities.Battalion;
import com.memoriesofwar.emergent.entities.Faction;
import com.memoriesofwar.emergent.entities.Player;
import com.memoriesofwar.emergent.entities.Unit;
import com.memoriesofwar.emergent.repositories.BattalionRepository;
import com.memoriesofwar.emergent.repositories.FactionRepository;
import com.memoriesofwar.emergent.repositories.PlayerRepository;
import com.memoriesofwar.emergent.repositories.UnitRepository;
import com.memoriesofwar.emergent.units.Volunteers;
import com.memoriesofwar.emergent.utils.Factions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageReceivedEvent;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IRole;
import sx.blah.discord.handle.obj.IUser;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BattalionsCommand implements IBotCommand{

    private PlayerRepository pr;

    private BattalionRepository br;

    public BattalionsCommand() {}

    @Autowired
    public BattalionsCommand(PlayerRepository pr, BattalionRepository br) {
        this.pr = pr;
        this.br = br;
    }

    @Override
    @Transactional
    public void execute(String[] tokenizedMessage, MessageReceivedEvent event) {

        IUser user = event.getAuthor();
        Player player = pr.findOne(user.getLongID());

        if(player == null) {
            user.getOrCreatePMChannel().sendMessage("```You are not registered in ARENAgma yet. Use the ?join command in the March of War server before using the ?battalions command.```");
            return;
        }

        List<Battalion> battalions = br.findByPlayer(player);

        StringBuilder message = new StringBuilder();
        message.append("```Battallions (" + battalions.size() + "):\n\n");

        for(Battalion battalion : battalions) {
            message.append(battalion.toString());
            message.append("\n");
        }
        message.append("```");

        user.getOrCreatePMChannel().sendMessage(message.toString());
    }

    @Override
    public String getCommandName() {
        return "?battalions";
    }

    @Override
    public String getCommandDescription() {
        return "Type ?battalions for battalion-related commands.";
    }
}
