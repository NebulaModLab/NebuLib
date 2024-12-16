public class SystemGeneratorLibExamples {
    /*

    // ╔═════════════════════════════════╗
    // ║ Category & Ring  Types Examples ║
    // ╚═════════════════════════════════╝

     system.addRingBand(
         star, // What To Surround
         GraphicCats.MISC, // Category Type
         RingTypes.ASTEROIDS, // Key / Ring Type* (Info Below)
         256f, // Band Width In Texture
         3, // Band Index
         Color.red, // Color
         256f, // Band With In Engine
         asteroidBelt1Dist - 150, // Middle Radius
         350f // Orbit Days
     );

    // ╔═════════════════════════════════╗
    // ║ Instead of manually typing the  ║
    // ║ desired category and ring type  ║
    // ║ ID, you call the "GraphicCats"  ║
    // ║ class and "RingTypes" class an  ║
    // ║ search for the types you wish   ║
    // ║ to use.                         ║
    // ╚═════════════════════════════════╝

    // ───────────────────────────────────────────────────────────────────────────────────────────────────────────────


    // ╔═════════════════════════════════╗
    // ║      Planet Types Examples      ║
    // ╚═════════════════════════════════╝
    PlanetAPI planet1 = system.addPlanet(
            "planet1", // Planet ID
            star, // What does the object orbit?
            "Planet 1", // Planet Name
            PlanetTypes.GAS_GIANT, // Planet type* (Info below)
            0, // Angle
            229, // Radius
            18000, // Orbit Radius
            310 // Orbit Days
    );

    PlanetAPI planet2 = system.addPlanet(
            "planet2", // Planet ID
            star, // What does the object orbit?
            "Planet 2", // Planet Name
            PlanetTypes.LAVA_MINOR, // Planet type* (Info below)
            240, // Angle
            120, // Radius
            starRadius + starCoronaSize + 1500, // Orbit Radius (Calculation makes sure it's not in the star)
            120 // Orbit Days
    );

    // ╔═════════════════════════════════╗
    // ║ Instead of manually typing the  ║
    // ║ desired planet type's ID, you   ║
    // ║ call the "PlanetTypes" class    ║
    // ║ and search for the planet type  ║
    // ║ you wish to use.                ║
    // ╚═════════════════════════════════╝

    // ───────────────────────────────────────────────────────────────────────────────────────────────────────────────

    // ╔═════════════════════════════════╗
    // ║ Spec. Sys. Entity Type Examples ║
    // ╚═════════════════════════════════╝

    //Array
    SectorEntityToken systemSensorArray = system.addCustomEntity(
            "system_sensor_array",  // Entity ID
            "System Sensor Array", // Entity Name
            SpecialCampaignEntityTypes.SENSOR_ARRAY, // Entity Type* (Info Below)
            "neutral" // Entity Owner (Faction)
    );
    array.setCircularOrbitPointingDown(
            star, // What To Orbit?
            randomArrayAngle, // Angle Of Orbit
            3000, // Orbit Radius
            375 // Orbit Days
    );

    //Buoy
    SectorEntityToken systemNavBuoy = system.addCustomEntity(
            "system_nav_buoy",
            "System Nav Buoy",
            SpecialCampaignEntityTypes.NAV_BUOY,
            "neutral"
    );
    buoy.setCircularOrbitPointingDown(
            star,
            randomBuoyAngle,
            5000,
            350
    );

    //Relay
    SectorEntityToken systemCommRelay = system.addCustomEntity(
            "system_comm_relay",
            "System Comm Relay",
            SpecialCampaignEntityTypes.COMM_RELAY,
            "neutral"
    );
    relay.setCircularOrbitPointingDown(
            star,
            randomRelayAngle,
            7500,
            400
    );

    //Gate
    SectorEntityToken system_Gate = system.addCustomEntity(
            "system_gate",
            "System Gate",
            SpecialCampaignEntityTypes.INACTIVE_GATE,
            null
    );
    system_gate.setCircularOrbit(
            star,
            randomGateAngle,
            asteroidField1Dist,
            220
    );

    // ╔═════════════════════════════════╗
    // ║ Instead of manually typing the  ║
    // ║ desired special entity type ID, ║
    // ║ you call the                    ║
    // ║ "SpecialCampaignEntityTypes"      ║
    // ║ class and search for the entity ║
    // ║ type you wish to use.           ║
    // ╚═════════════════════════════════╝

    // ───────────────────────────────────────────────────────────────────────────────────────────────────────────────

    // ╔═════════════════════════════════╗
    // ║       Star Types Examples       ║
    // ╚═════════════════════════════════╝

    PlanetAPI star1 = system.initStar(
            "starOne", // Star ID
            StarTypes.STAR_RED_SUPERGIANT, // Star Type* (Info below)
            1300, // Star Radius
            -13000, // Hyperspace Location X
            -17000, // Hyperspace Location Y
            350 // Star Corona Size
    );

    PlanetAPI star2 = system.initStar(
            "starTwo", // Star ID
            StarTypes.BLACK_HOLE, // Star Type* (Info below)
            1300, // Star Radius
            -13000, // Hyperspace Location X
            -17000, // Hyperspace Location Y
            350 // Star Corona Size
    );

    // ╔═════════════════════════════════╗
    // ║ Instead of manually typing the  ║
    // ║ desired star type's ID, you     ║
    // ║ call the "StarTypes" class and  ║
    // ║ search for the star type you    ║
    // ║ wish to use.                    ║
    // ╚═════════════════════════════════╝

    // ───────────────────────────────────────────────────────────────────────────────────────────────────────────────

    // ╔═════════════════════════════════╗
    // ║     Station Types  Examples     ║
    // ╚═════════════════════════════════╝

    CustomCampaignEntityAPI pirateStation = system.addCustomEntity(
            "pirate_station", // Station ID
            "Pirate Station", // Station Name
            StationTypes.PIRATE_STATION, // Station Type* (Info below)
            Factions.PIRATES // Entity Owner (Faction)
    );

    CustomCampaignEntityAPI researchStation = system.addCustomEntity(
            "research_station", // Station ID
            "Research Station", // Station Name
            StationTypes.RESEARCH_STATION, // Station Type* (Info below)
            Factions.NEUTRAL // Entity Owner (Faction)
    );

    // ╔═════════════════════════════════╗
    // ║ Instead of manually typing the  ║
    // ║ desired station type's ID, you  ║
    // ║ call the "StationTypes" class   ║
    // ║ and search for the station type ║
    // ║ you wish to use.                ║
    // ╚═════════════════════════════════╝

    // ───────────────────────────────────────────────────────────────────────────────────────────────────────────────

    // ╔═════════════════════════════════╗
    // ║      Nebula Types Examples      ║
    // ╚═════════════════════════════════╝

    // ╔═════════════════════════════════╗
    // ║ Instead of manually typing the  ║
    // ║ desired nebula type's ID, you   ║
    // ║ call the "NebulaeTypes" class   ║
    // ║ and search for the nebula type  ║
    // ║ you wish to use.                ║
    // ║                                 ║
    // ║ NOTE: I haven't used this yet   ║
    // ║ myself so don't have a working  ║
    // ║ example of this, sorry for this ║
    // ╚═════════════════════════════════╝

    // ───────────────────────────────────────────────────────────────────────────────────────────────────────────────


    */
}
