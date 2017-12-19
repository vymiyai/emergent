package com.memoriesofwar.emergent;

import com.memoriesofwar.emergent.database.Faction;
import com.memoriesofwar.emergent.database.FactionRepository;
import com.memoriesofwar.emergent.database.Territory;
import com.memoriesofwar.emergent.database.TerritoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.memoriesofwar.emergent.utils.Territories.*;
import static com.memoriesofwar.emergent.utils.Factions.*;

@Component
public class Overworld {

    private List<Faction> factions;

    private List<Territory> territories;

    private FactionRepository factionRepository;

    private TerritoryRepository territoryRepository;

    public Overworld() {
    }

    @Autowired
    public Overworld(FactionRepository factionRepository, TerritoryRepository territoryRepository) {

        this.factionRepository = factionRepository;
        this.territoryRepository = territoryRepository;


        Faction se = new Faction(SE);
        Faction ur = new Faction(UR);
        Faction su = new Faction(SU);
        Faction lj = new Faction(LJ);
        Faction aw = new Faction(AW);
        Faction ea = new Faction(EA);
        factions = Arrays.asList(se, ur, su, lj, aw, ea);

        Territory newZealand = new Territory(NEW_ZEALAND, ea, false);
        Territory eastAustralia = new Territory(EAST_AUSTRALIA, ea, true);
        Territory westAustralia = new Territory(WEST_AUSTRALIA, ea, false);
        Territory benelux = new Territory(BENELUX, ea, true);
        Territory iceland = new Territory(ICELAND, ea, false);
        Territory ireland = new Territory(IRELAND, ea, false);
        Territory scotland = new Territory(SCOTLAND, ea, false);
        Territory england = new Territory(ENGLAND, ea, false);
        Territory northernFrance = new Territory(NORTHERN_FRANCE, ea, false);
        Territory southernFrance = new Territory(SOUTHERN_FRANCE, ea, false);
        Territory spain = new Territory(SPAIN, ea, false);
        Territory portugal = new Territory(PORTUGAL, ea, false);
        Territory italy = new Territory(ITALY, ea, false);
        Territory westernGermany = new Territory(WESTERN_GERMANY, ea, false);
        Territory easternGermany = new Territory(EASTERN_GERMANY, ea, false);
        Territory denmark = new Territory(DENMARK, ea, false);
        Territory norway = new Territory(NORWAY, ea, false);
        Territory sweden = new Territory(SWEDEN, ea, false);
        Territory finland = new Territory(FINLAND, ea, false);
        Territory balticStates = new Territory(BALTIC_STATES, ea, false);
        Territory poland = new Territory(POLAND, ea, false);
        Territory austriaHungary = new Territory(AUSTRIA_HUNGARY, ea, false);
        Territory balkan = new Territory(BALKAN, ea, false);
        Territory greece = new Territory(GREECE, ea, false);
        Territory southEastEurope = new Territory(SOUTH_EAST_EUROPE, ea, false);

        Territory japan = new Territory(JAPAN, se, false);
        Territory korea = new Territory(KOREA, se, false);
        Territory beijing = new Territory(BEIJING, se, false);
        Territory bangladesh = new Territory(BANGLADESH, se, true);
        Territory papuaNewGuinea = new Territory(PAPUA_NEW_GUINEA, se, false);
        Territory timor = new Territory(TIMOR, se, false);
        Territory indonesia = new Territory(INDONESIA, se, false);
        Territory thailand = new Territory(THAILAND, se, false);
        Territory borneo = new Territory(BORNEO, se, false);
        Territory sulawesi = new Territory(SULAWESI, se, false);
        Territory malaysia = new Territory(MALAYSIA, se, false);
        Territory singapore = new Territory(SINGAPORE, se, false);
        Territory philippines = new Territory(PHILIPPINES, se, false);
        Territory burma = new Territory(BURMA, se, false);
        Territory vietnam = new Territory(VIETNAM, se, false);
        Territory nepal = new Territory(NEPAL, se, false);
        Territory india = new Territory(INDIA, se, false);
        Territory sriLanka = new Territory(SRI_LANKA, se, false);
        Territory himalayas = new Territory(HIMALAYAS, se, false);
        Territory southEastChina = new Territory(SOUTH_EAST_CHINA, se, false);
        Territory taiwan = new Territory(TAIWAN, se, false);
        Territory centralChina = new Territory(CENTRAL_CHINA, se, false);
        Territory shanghai = new Territory(SHANGHAI, se, false);
        Territory mongolia = new Territory(MONGOLIA, se, false);

        Territory kamchatka = new Territory(KAMCHATKA, su, false);
        Territory westMagadan = new Territory(WEST_MAGADAN, su, true);
        Territory eastMagadan = new Territory(EAST_MAGADAN, su, false);
        Territory stPetersburg = new Territory(ST_PETERSBURG, su, false);
        Territory ukraine = new Territory(UKRAINE, su, false);
        Territory belarus = new Territory(BELARUS, su, false);
        Territory moscow = new Territory(MOSCOW, su, false);
        Territory arkhangelsk = new Territory(ARKHANGELSK, su, false);
        Territory northCaucasus = new Territory(NORTH_CAUCASUS, su, false);
        Territory northUrals = new Territory(NORTH_URALS, su, false);
        Territory centralUrals = new Territory(CENTRAL_URALS, su, false);
        Territory westKazakhstan = new Territory(WEST_KAZAKHSTAN, su, false);
        Territory eastKazakhstan = new Territory(EAST_KAZAKHSTAN, su, false);
        Territory karakum = new Territory(KARAKUM, su, false);
        Territory tianShan = new Territory(TIAN_SHAN, su, false);
        Territory southernSiberia = new Territory(SOUTHERN_SIBERIA, su, false);
        Territory eastSiberia = new Territory(EAST_SIBERIA, su, false);
        Territory westSiberia = new Territory(WEST_SIBERIA, su, false);
        Territory northernSiberia = new Territory(NORTHERN_SIBERIA, su, false);
        Territory yakutsk = new Territory(YAKUTSK, su, false);
        Territory transBaikal = new Territory(TRANS_BAIKAL, su, false);
        Territory sakha = new Territory(SAKHA, su, false);
        Territory khabarovsk = new Territory(KHABAROVSK, su, false);

        Territory hawaii = new Territory(HAWAII, ur, false);
        Territory midAtlantic = new Territory(MID_ATLANTIC, ur, true);
        Territory pacificSouthwest = new Territory(PACIFIC_SOUTHWEST, ur, false);
        Territory pacificNorthwest = new Territory(PACIFIC_NORTHWEST, ur, false);
        Territory southernPlains = new Territory(SOUTHERN_PLAINS, ur, false);
        Territory gulfCoast = new Territory(GULF_COAST, ur, false);
        Territory coastalSoutheast = new Territory(COASTAL_SOUTHEAST, ur, false);
        Territory appalachianBasin = new Territory(APPALACHIAN_BASIN, ur, false);
        Territory westernInterior = new Territory(WESTERN_INTERIOR, ur, false);
        Territory coloradoPlateau = new Territory(COLORADO_PLATEAU, ur, false);
        Territory northernRockies = new Territory(NORTHERN_ROCKIES, ur, false);
        Territory northernPlains = new Territory(NORTHERN_PLAINS, ur, false);
        Territory greatLakes = new Territory(GREAT_LAKES, ur, false);
        Territory newEngland = new Territory(NEW_ENGLAND, ur, false);
        Territory quebec = new Territory(QUEBEC, ur, false);
        Territory newFoundland = new Territory(NEW_FOUNDLAND, ur, false);
        Territory greenland = new Territory(GREENLAND, ur, false);
        Territory ontario = new Territory(ONTARIO, ur, false);
        Territory manitoba = new Territory(MANITOBA, ur, false);
        Territory alberta = new Territory(ALBERTA, ur, false);
        Territory britishColumbia = new Territory(BRITISH_COLUMBIA, ur, false);
        Territory canadianArtic = new Territory(CANADIAN_ARCTIC, ur, false);
        Territory yukon = new Territory(YUKON, ur, false);
        Territory alaska = new Territory(ALASKA, ur, false);

        Territory westCongo = new Territory(WEST_CONGO, aw, true);
        Territory centralCongo = new Territory(CENTRAL_CONGO, aw, false);
        Territory madagascar = new Territory(MADAGASCAR, aw, false);
        Territory southAfrica = new Territory(SOUTH_AFRICA, aw, false);
        Territory namibia = new Territory(NAMIBIA, aw, false);
        Territory rhodesia = new Territory(RHODESIA, aw, false);
        Territory mozambique = new Territory(MOZAMBIQUE, aw, false);
        Territory ivoryCoast = new Territory(IVORY_COAST, aw, false);
        Territory somalia = new Territory(SOMALIA, aw, false);
        Territory sudan = new Territory(SUDAN, aw, false);
        Territory kenya = new Territory(KENYA, aw, false);
        Territory centralAfrica = new Territory(CENTRAL_AFRICA, aw, false);
        Territory nigeria = new Territory(NIGERIA, aw, false);
        Territory westAfrica = new Territory(WEST_AFRICA, aw, false);
        Territory morocoo = new Territory(MOROCCO, aw, false);
        Territory algeria = new Territory(ALGERIA, aw, false);
        Territory libya = new Territory(LIBYA, aw, false);
        Territory egypt = new Territory(EGYPT, aw, false);
        Territory middleEast = new Territory(MIDDLE_EAST, aw, false);
        Territory arabia = new Territory(ARABIA, aw, false);
        Territory turkey = new Territory(TURKEY, aw, false);
        Territory southCaucasus = new Territory(SOUTH_CAUCASUS, aw, false);
        Territory persia = new Territory(PERSIA, aw, false);
        Territory afghanistan = new Territory(AFGHANISTAN, aw, false);

        Territory saoPaulo = new Territory(SAO_PAULO, lj, true);
        Territory chila = new Territory(CHILE, lj, false);
        Territory malvinas = new Territory(MALVINAS, lj, false);
        Territory fireland = new Territory(FIRELAND, lj, false);
        Territory patagonia = new Territory(PATAGONIA, lj, false);
        Territory buenosAires = new Territory(BUENOS_AIRES, lj, false);
        Territory uruguay = new Territory(URUGUAY, lj, false);
        Territory paraguay = new Territory(PARAGUAY, lj, false);
        Territory brasilia = new Territory(BRASILIA, lj, false);
        Territory rioDeJaneiro = new Territory(RIO_DE_JANEIRO, lj, false);
        Territory recife = new Territory(RECIFE, lj, false);
        Territory amazonia = new Territory(AMAZONIA, lj, false);
        Territory peru = new Territory(PERU, lj, false);
        Territory colombia = new Territory(COLOMBIA, lj, false);
        Territory ecuador = new Territory(ECUADOR, lj, false);
        Territory venezuela = new Territory(VENEZUELA, lj, false);
        Territory bolivia = new Territory(BOLIVIA, lj, false);
        Territory guyana = new Territory(GUYANA, lj, false);
        Territory centralAmerica = new Territory(CENTRAL_AMERICA, lj, false);
        Territory southMexico = new Territory(SOUTH_MEXICO, lj, false);
        Territory northMexico = new Territory(NORTH_MEXICO, lj, false);
        Territory cuba = new Territory(CUBA, lj, false);
        Territory caribbean = new Territory(CARIBBEAN, lj, false);

        territories = Arrays.asList(
            newZealand,
            eastAustralia,
            westAustralia,
            benelux,
            iceland,
            ireland,
            scotland,
            england,
            northernFrance,
            southernFrance,
            spain,
            portugal,
            italy,
            westernGermany,
            easternGermany,
            denmark,
            norway,
            sweden,
            finland,
            balticStates,
            poland,
            austriaHungary,
            balkan,
            greece,
            southEastEurope,

            japan,
            korea,
            beijing,
            bangladesh,
            papuaNewGuinea,
            timor,
            indonesia,
            thailand,
            borneo,
            sulawesi,
            malaysia,
            singapore,
            philippines,
            burma,
            vietnam,
            nepal,
            india,
            sriLanka,
            himalayas,
            southEastChina,
            taiwan,
            centralChina,
            shanghai,
            mongolia,

            kamchatka,
            westMagadan,
            eastMagadan,
            stPetersburg,
            ukraine,
            belarus,
            moscow,
            arkhangelsk,
            northCaucasus,
            northUrals,
            centralUrals,
            westKazakhstan,
            eastKazakhstan,
            karakum,
            tianShan,
            southernSiberia,
            eastSiberia,
            westSiberia,
            northernSiberia,
            yakutsk,
            transBaikal,
            sakha,
            khabarovsk,

            hawaii,
            midAtlantic,
            pacificSouthwest,
            pacificNorthwest,
            southernPlains,
            gulfCoast,
            coastalSoutheast,
            appalachianBasin,
            westernInterior,
            coloradoPlateau,
            northernRockies,
            northernPlains,
            greatLakes,
            newEngland,
            quebec,
            newFoundland,
            greenland,
            ontario,
            manitoba,
            alberta,
            britishColumbia,
            canadianArtic,
            yukon,
            alaska,

            westCongo,
            centralCongo,
            madagascar,
            southAfrica,
            namibia,
            rhodesia,
            mozambique,
            ivoryCoast,
            somalia,
            sudan,
            kenya,
            centralAfrica,
            nigeria,
            westAfrica,
            morocoo,
            algeria,
            libya,
            egypt,
            middleEast,
            arabia,
            turkey,
            southCaucasus,
            persia,
            afghanistan,

            saoPaulo,
            chila,
            malvinas,
            fireland,
            patagonia,
            buenosAires,
            uruguay,
            paraguay,
            brasilia,
            rioDeJaneiro,
            recife,
            amazonia,
            peru,
            colombia,
            ecuador,
            venezuela,
            bolivia,
            guyana,
            centralAmerica,
            southMexico,
            northMexico,
            cuba,
            caribbean);

        for(Faction faction : factions) {
            factionRepository.save(faction);
        }

        for(Territory territory : territories) {
            territoryRepository.save(territory);
        }

        /*

        //Territory newZealand = new Territory(NEW_ZEALAND, ea, Arrays.asList(EAST_AUSTRALIA), false);
        //Territory eastAustralia = new Territory(EAST_AUSTRALIA, ea, Arrays.asList(WEST_AUSTRALIA, NEW_ZEALAND, PAPUA_NEW_GUINEA, CHILE, MID_ATLANTIC, WEST_MAGADAN, BANGLADESH, BENELUX, SAO_PAULO, WEST_CONGO), true);
        //Territory westAustralia = new Territory(WEST_AUSTRALIA, ea, Arrays.asList(EAST_AUSTRALIA, TIMOR), false);

        //Territory japan = new Territory(JAPAN, se, Arrays.asList(HAWAII, KOREA, KAMCHATKA), false);
        //Territory korea = new Territory(KOREA, se, Arrays.asList(JAPAN, BEIJING), false);

        Territory japan = new Territory(JAPAN, se, false);
        Territory korea = new Territory(KOREA, se, false);

        List<Territory> originalSETerritories = Arrays.asList(japan, korea);
        territories = new ArrayList<>();
        territories.addAll(originalSETerritories);
        */
    }

    public List<Faction> getFactions() {
        return factions;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public FactionRepository getFactionRepository() {
        return factionRepository;
    }

    public TerritoryRepository getTerritoryRepository() {
        return territoryRepository;
    }

    @Override
    public String toString() {
        String response = territories.stream().map(Territory::toString).collect(Collectors.joining(", "));

        return "[" + response + "]";
    }
}
