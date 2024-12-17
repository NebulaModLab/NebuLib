# NebuLib
### Repository for Starsector's NebuLib utility mod.

[![Forum Post](https://img.shields.io/badge/Forum%20Post-%20?style=for-the-badge&logo=Formspree&labelColor=131313&color=5728bc)](https://fractalsoftworks.com/forum/index.php?topic=29589) 
[![Changelogs](https://img.shields.io/badge/Changelogs-%20?style=for-the-badge&logo=github&labelColor=131313&color=5728bc)](https://github.com/NebulaModLab/NebuLib/releases)

More info is in the forum post, but current features:

1. No longer do you have to remember all string ID's of multiple vanilla campaign-level things:
   - Ring Types
   - Planet Types
   - Special Entity Types (Sensor Array etc.)
   - Star Types
   - Station Types
   - Nebula Types

2. Same goes for "Graphic Categories":
   - Ex. `system.addRingBand(pheron, GraphicCats.MISC, RingTypes.DUST, 256f, 3, Color.WHITE, 256f, 250f, 200f);`
   - Above, `GraphicCats.MISC` is usually where in this case "misc", "illustrations" and "planets" can be which 
   are in regards to where the wanted graphical sprites are. These are like bulletin 1, usually 
   strings you write down, but again these can't just be remembered easily (to me at least).

3. A full example of a use-case in regards to using this mod, taking bulletin 1. as example:

            // Adding a planet to a starsystem
            PlanetAPI planet1 = system.addPlanet(
               "planet1",              // Planet ID
               star,                   // What does the object orbit?
               "Planet 1",             // Planet Name
               PlanetTypes.GAS_GIANT,  // <<<<<<<< The PlanetTypes Example [ THIS MOD ]
               0,                      // Angle
               229,                    // Radius
               18000,                  // Orbit Radius
               310                     // Orbit Days
            );

## More features to come, recommendations for features are welcome!