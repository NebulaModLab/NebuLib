package nebulib.kaysaar;

import com.fs.starfarer.api.campaign.CustomUIPanelPlugin;
import com.fs.starfarer.api.ui.CustomPanelAPI;

/**
 * @author Kaysaar
 */
public interface ExtendedUIPanelPlugin extends CustomUIPanelPlugin {
    CustomPanelAPI getMainPanel();

    void createUI();

    void clearUI();
}
