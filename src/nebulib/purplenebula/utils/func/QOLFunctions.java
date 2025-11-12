package nebulib.purplenebula.utils.func;

import com.fs.starfarer.api.Global;

import java.awt.*;
import java.util.List;

public class QOLFunctions {

    public static Color getRelationColor(int relAmount) {

        String relationColorString;
        if (relAmount <= -90) relationColorString = "relationVengefulNinety";
        else if (relAmount <= -80) relationColorString = "relationVengefulEighty";
        else if (relAmount <= -70) relationColorString = "relationHostileSeventy";
        else if (relAmount <= -60) relationColorString = "relationHostileSixty";
        else if (relAmount <= -50) relationColorString = "relationHostileFifty";
        else if (relAmount <= -40) relationColorString = "relationInhospitableForty";
        else if (relAmount <= -30) relationColorString = "relationInhospitableThirty";
        else if (relAmount <= -20) relationColorString = "relationSuspiciousTwenty";
        else if (relAmount <= -10) relationColorString = "relationSuspiciousTen";
        else if (relAmount >= 90) relationColorString = "relationCooperativeNinety";
        else if (relAmount >= 80) relationColorString = "relationCooperativeEighty";
        else if (relAmount >= 70) relationColorString = "relationFriendlySeventy";
        else if (relAmount >= 60) relationColorString = "relationFriendlySixty";
        else if (relAmount >= 50) relationColorString = "relationFriendlyFifty";
        else if (relAmount >= 40) relationColorString = "relationWelcomingForty";
        else if (relAmount >= 30) relationColorString = "relationWelcomingThirty";
        else if (relAmount >= 20) relationColorString = "relationFavorableTwenty";
        else if (relAmount >= 10) relationColorString = "relationFavorableTen";
        else relationColorString = "relationNeutral";

        return Global.getSettings().getColor(relationColorString);
    }

}
