package com.memoriesofwar.emergent;

import com.memoriesofwar.emergent.factions.Faction;
import com.memoriesofwar.emergent.territories.Territory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.memoriesofwar.emergent.Territories.*;

@Component
public class Overworld {

    private List<Faction> factions;
    private List<Territory> territories;

    public Overworld() {
        Faction se = new Faction("Shogun Empire");
        Faction ur = new Faction("United Republic");
        Faction su = new Faction("Soviet Union");
        Faction lj = new Faction("Latin Junta");
        Faction aw = new Faction("African Warlords");
        Faction ea = new Faction("European Alliance");
        factions = Arrays.asList(se, ur, su, lj, aw, ea);

        Territory newZealand = new Territory(NEW_ZEALAND, ea, Arrays.asList(EAST_AUSTRALIA), false);
        Territory eastAustralia = new Territory(EAST_AUSTRALIA, ea, Arrays.asList(WEST_AUSTRALIA, NEW_ZEALAND, PAPUA_NEW_GUINEA, CHILE, MID_ATLANTIC, WEST_MAGADAN, BANGLADESH, BENELUX, SAO_PAULO, WEST_CONGO), true);
        Territory westAustralia = new Territory(WEST_AUSTRALIA, ea, Arrays.asList(EAST_AUSTRALIA, TIMOR), false);

        Territory japan = new Territory(JAPAN, se, Arrays.asList(HAWAII, KOREA, KAMCHATKA), false);
        Territory korea = new Territory(KOREA, se, Arrays.asList(JAPAN, BEIJING), false);


        List<Territory> originalSETerritories = Arrays.asList(japan, korea);
        territories = new ArrayList<>();
        territories.addAll(originalSETerritories);
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    @Override
    public String toString() {
        String response = territories.stream().map(Territory::toString).collect(Collectors.joining(", "));

        return "[" + response + "]";
    }
}
