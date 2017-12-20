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
        Territory canadianArctic = new Territory(CANADIAN_ARCTIC, ur, false);
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
        Territory morocco = new Territory(MOROCCO, aw, false);
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
        Territory chile = new Territory(CHILE, lj, false);
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
            canadianArctic,
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
            morocco,
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
            chile,
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

        newZealand.setLinks(eastAustralia);
        eastAustralia.setLinks(westAustralia, newZealand, papuaNewGuinea, chile, midAtlantic, westMagadan, bangladesh, benelux, saoPaulo, westCongo);
        westAustralia.setLinks(eastAustralia,timor);
        iceland.setLinks(greenland, scotland, ireland);
        scotland.setLinks(iceland, ireland, england, norway);
        ireland.setLinks(iceland, england, scotland);
        england.setLinks(ireland, scotland, northernFrance);
        northernFrance.setLinks(england, benelux, westernGermany, italy, southernFrance);
        southernFrance.setLinks(northernFrance, spain, italy);
        spain.setLinks(morocco, portugal, southernFrance);
        portugal.setLinks(spain);
        italy.setLinks(southernFrance, northernFrance, westernGermany, austriaHungary, balkan, libya);
        denmark.setLinks(westernGermany, easternGermany, norway, sweden);
        norway.setLinks(scotland, denmark, sweden, finland);
        sweden.setLinks(denmark, norway, finland);
        finland.setLinks(norway, sweden, balticStates, stPetersburg);
        balticStates.setLinks(finland, stPetersburg, belarus, poland);
        poland.setLinks(balticStates, belarus, ukraine, austriaHungary, easternGermany);
        westernGermany.setLinks(denmark, easternGermany, benelux, northernFrance, italy, austriaHungary);
        easternGermany.setLinks(denmark, westernGermany, austriaHungary, poland);
        austriaHungary.setLinks(poland, easternGermany, westernGermany, italy, balkan, southEastEurope, ukraine);
        benelux.setLinks(northernFrance, westernGermany, eastAustralia, bangladesh, westMagadan, westCongo, midAtlantic, saoPaulo);
        balkan.setLinks(italy, austriaHungary, southEastEurope, greece);
        greece.setLinks(turkey, balkan, southEastEurope);
        southEastEurope.setLinks(ukraine, austriaHungary, balkan, greece, turkey);

        papuaNewGuinea.setLinks(eastAustralia, sulawesi);
        timor.setLinks(westAustralia, sulawesi, indonesia);
        indonesia.setLinks(singapore, southAfrica, borneo, timor);
        borneo.setLinks(malaysia, indonesia);
        sulawesi.setLinks(philippines, papuaNewGuinea, timor);
        malaysia.setLinks(singapore, borneo, philippines);
        philippines.setLinks(malaysia, sulawesi, southEastChina);
        singapore.setLinks(thailand, indonesia, malaysia);
        thailand.setLinks(singapore, vietnam, burma);
        southEastChina.setLinks(himalayas, centralChina, shanghai, taiwan, philippines, vietnam, burma, bangladesh);
        taiwan.setLinks(southEastChina, shanghai);
        shanghai.setLinks(southEastChina, taiwan, centralChina, beijing);
        beijing.setLinks(korea, shanghai, mongolia, khabarovsk, transBaikal);
        korea.setLinks(japan, beijing);
        japan.setLinks(korea, kamchatka, hawaii);
        centralChina.setLinks(himalayas, mongolia, shanghai, southEastChina);
        mongolia.setLinks(himalayas, centralChina, beijing, transBaikal, eastKazakhstan);
        himalayas.setLinks(eastKazakhstan, tianShan, afghanistan, india, nepal, bangladesh, shanghai, centralChina, mongolia);
        bangladesh.setLinks(burma, southEastChina, himalayas, nepal, india, eastAustralia, midAtlantic, westMagadan, benelux, saoPaulo, westCongo);
        nepal.setLinks(bangladesh, india, himalayas);
        india.setLinks(sriLanka, persia, afghanistan, himalayas, nepal, bangladesh);
        sriLanka.setLinks(india);
        burma.setLinks(bangladesh, southEastChina, thailand, vietnam);
        vietnam.setLinks(thailand, burma, southEastChina);

        malvinas.setLinks(patagonia);
        patagonia.setLinks(buenosAires, chile);
        chile.setLinks(eastAustralia, bolivia, buenosAires, patagonia, fireland);
        fireland.setLinks(chile);
        uruguay.setLinks(buenosAires, saoPaulo);
        saoPaulo.setLinks(uruguay, buenosAires, paraguay, brasilia, rioDeJaneiro, benelux, eastAustralia, westCongo, westMagadan, bangladesh, midAtlantic);
        buenosAires.setLinks(patagonia, chile, bolivia, paraguay, saoPaulo, uruguay);
        paraguay.setLinks(buenosAires, bolivia, brasilia, saoPaulo);
        brasilia.setLinks(paraguay, bolivia, amazonia, recife, rioDeJaneiro, saoPaulo);
        rioDeJaneiro.setLinks(saoPaulo, brasilia, recife);
        recife.setLinks(ivoryCoast, amazonia, brasilia, rioDeJaneiro);
        bolivia.setLinks(chile, peru, amazonia, brasilia, paraguay, buenosAires);
        peru.setLinks(ecuador, colombia, amazonia, bolivia);
        ecuador.setLinks(peru, colombia);
        colombia.setLinks(ecuador, peru, centralAmerica, venezuela, amazonia);
        venezuela.setLinks(caribbean, colombia, guyana, amazonia);
        guyana.setLinks(venezuela, amazonia);
        amazonia.setLinks(guyana, venezuela, colombia, peru, bolivia, brasilia, recife);
        centralAmerica.setLinks(southMexico, colombia, cuba);
        caribbean.setLinks(cuba, venezuela);
        cuba.setLinks(coastalSoutheast, caribbean, centralAmerica);
        southMexico.setLinks(northMexico, centralAmerica);
        northMexico.setLinks(southMexico, pacificSouthwest, southernPlains);

        hawaii.setLinks(japan, pacificSouthwest);
        greenland.setLinks(iceland, newFoundland, canadianArctic);
        pacificSouthwest.setLinks(hawaii, pacificNorthwest, coloradoPlateau, southernPlains, northMexico);
        southernPlains.setLinks(northMexico, pacificSouthwest, coloradoPlateau, westernInterior, gulfCoast);
        gulfCoast.setLinks(southernPlains, westernInterior, coastalSoutheast);
        coastalSoutheast.setLinks(cuba, gulfCoast, westernInterior, appalachianBasin);
        appalachianBasin.setLinks(coastalSoutheast, westernInterior, greatLakes, midAtlantic);
        midAtlantic.setLinks(appalachianBasin, greatLakes, ontario, quebec, newEngland, benelux, eastAustralia, westCongo, westMagadan, saoPaulo, bangladesh);
        newEngland.setLinks(midAtlantic, quebec);
        quebec.setLinks(newFoundland, newEngland, midAtlantic, ontario, canadianArctic);
        greatLakes.setLinks(midAtlantic, appalachianBasin, westernInterior, northernPlains, ontario);
        ontario.setLinks(manitoba, greatLakes, midAtlantic, quebec);
        westernInterior.setLinks(southernPlains, gulfCoast, coastalSoutheast, appalachianBasin, greatLakes, northernPlains, coloradoPlateau);
        coloradoPlateau.setLinks(pacificNorthwest, pacificSouthwest, southernPlains, westernInterior, northernPlains, northernRockies, britishColumbia);
        pacificNorthwest.setLinks(pacificSouthwest, britishColumbia, northernRockies);
        northernPlains.setLinks(westernInterior, greatLakes, manitoba, alberta, northernRockies, coloradoPlateau);
        northernRockies.setLinks(britishColumbia, alberta, northernPlains, coloradoPlateau);
        manitoba.setLinks(ontario, northernPlains, alberta, canadianArctic);
        alberta.setLinks(manitoba, northernPlains, northernRockies, britishColumbia, yukon, canadianArctic);
        britishColumbia.setLinks(pacificNorthwest, coloradoPlateau, northernRockies, alberta, yukon);
        canadianArctic.setLinks(yukon, alberta, manitoba, greenland, quebec);
        yukon.setLinks(alaska, britishColumbia, alberta, canadianArctic);
        alaska.setLinks(kamchatka, yukon);
        newFoundland.setLinks(greenland, quebec);

        ivoryCoast.setLinks(recife, westAfrica, nigeria);
        westAfrica.setLinks(morocco, algeria, centralAfrica, nigeria, ivoryCoast);
        morocco.setLinks(spain, westAfrica, algeria);
        algeria.setLinks(morocco, westAfrica, centralAfrica, libya);
        libya.setLinks(italy, algeria, centralAfrica, egypt, sudan);
        egypt.setLinks(libya, sudan, arabia, middleEast);
        centralAfrica.setLinks(libya, egypt, sudan, centralCongo, westCongo, nigeria, westAfrica);
        nigeria.setLinks(ivoryCoast, westAfrica, centralAfrica, westCongo);
        westCongo.setLinks(nigeria, centralAfrica, centralCongo, benelux, eastAustralia, westMagadan, bangladesh, saoPaulo, midAtlantic);
        sudan.setLinks(egypt, libya, centralAfrica, centralCongo, kenya, somalia);
        somalia.setLinks(arabia, sudan, kenya);
        centralCongo.setLinks(centralAfrica, westCongo, namibia, rhodesia, kenya, sudan);
        kenya.setLinks(somalia, sudan, centralCongo, rhodesia, mozambique);
        namibia.setLinks(southAfrica, rhodesia, centralCongo);
        rhodesia.setLinks(centralCongo, namibia, southAfrica, mozambique, kenya);
        mozambique.setLinks(madagascar, kenya, rhodesia, southAfrica);
        madagascar.setLinks(mozambique);
        southAfrica.setLinks(indonesia, namibia, rhodesia, mozambique);
        arabia.setLinks(somalia, egypt, middleEast);
        middleEast.setLinks(egypt, arabia, persia, turkey);
        turkey.setLinks(greece, southEastEurope, southCaucasus, persia, middleEast);
        southCaucasus.setLinks(northCaucasus, turkey, persia);
        persia.setLinks(turkey, southCaucasus, karakum, afghanistan, india, middleEast);
        afghanistan.setLinks(tianShan, karakum, persia, india, himalayas);

        kamchatka.setLinks(japan, alaska, eastMagadan);
        eastMagadan.setLinks(kamchatka, westMagadan, sakha);
        westMagadan.setLinks(eastMagadan, sakha, khabarovsk, benelux, eastAustralia, bangladesh, westCongo, midAtlantic, saoPaulo);
        khabarovsk.setLinks(beijing, transBaikal, yakutsk, sakha, westMagadan);
        transBaikal.setLinks(khabarovsk, beijing, mongolia, eastKazakhstan, southernSiberia, eastSiberia, yakutsk);
        sakha.setLinks(eastMagadan, westMagadan, khabarovsk, yakutsk);
        yakutsk.setLinks(northernSiberia, westSiberia, eastSiberia, transBaikal, khabarovsk, sakha);
        eastSiberia.setLinks(westSiberia, southernSiberia, transBaikal, yakutsk);
        northernSiberia.setLinks(westSiberia, yakutsk);
        westSiberia.setLinks(northernSiberia, yakutsk, westSiberia, southernSiberia, northUrals);
        southernSiberia.setLinks(westSiberia, eastSiberia, transBaikal, eastKazakhstan, westKazakhstan, northUrals, centralUrals);
        eastKazakhstan.setLinks(southernSiberia, transBaikal, mongolia, himalayas, tianShan, karakum, westKazakhstan);
        westKazakhstan.setLinks(northCaucasus, centralUrals, southernSiberia, eastKazakhstan, karakum);
        tianShan.setLinks(eastKazakhstan, himalayas, afghanistan, karakum);
        karakum.setLinks(persia, afghanistan, tianShan, eastKazakhstan, westKazakhstan);
        northUrals.setLinks(arkhangelsk, centralUrals, southernSiberia, westSiberia);
        centralUrals.setLinks(northUrals, arkhangelsk, moscow, northCaucasus, westKazakhstan, southernSiberia);
        northCaucasus.setLinks(southCaucasus, westKazakhstan, centralUrals, moscow, ukraine);
        moscow.setLinks(arkhangelsk, stPetersburg, belarus, ukraine, northCaucasus, centralUrals);
        arkhangelsk.setLinks(stPetersburg, moscow, centralUrals, northUrals);
        stPetersburg.setLinks(finland, balticStates, belarus, moscow, arkhangelsk);
        belarus.setLinks(stPetersburg, balticStates, poland, ukraine, moscow);
        ukraine.setLinks(belarus, poland, austriaHungary, southEastEurope, northCaucasus, moscow);

        for(Territory territory : territories) {
            territoryRepository.save(territory);
        }
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
