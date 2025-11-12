package nebulib.purplenebula.ui.components;
import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.impl.campaign.intel.events.BaseEventIntel;
import com.fs.starfarer.api.input.InputEventAPI;
import com.fs.starfarer.api.ui.*;
import com.fs.starfarer.api.util.Misc;
import nebulib.kaysaar.ExtendedUIPanelPlugin;
import nebulib.purplenebula.ui.enums.ProgressBarLabelType;
import nebulib.purplenebula.ui.enums.ProgressBarType;
import nebulib.purplenebula.utils.func.QOLFunctions;

import java.awt.*;
import java.util.List;

public class ProgressBarComponent implements ExtendedUIPanelPlugin {
    ProgressBarType barType;
    ProgressBarLabelType barLabelType;
    CustomPanelAPI mainPanel,componentPanel;
    LabelAPI progressLabel;
    Color barBracketsColor,barColor,firstLabelColor,secondLabelColor;
    float progress,maxProgress;
    protected BaseEventIntel influencer;
    String barLabelFont;

    public float getProgress() {
        return progress;
    }
    String barText;

    public void setProgress(float progress) {
        this.progress = progress;
        createUI();
    }
    public void setMaxProgress(float maxProgress) {
        this.maxProgress = maxProgress;
        createUI();
    }

    public void setBarBrackets(Color barBrackets) {
        this.barBracketsColor = barBrackets;
    }

    public void setBarColor(Color barColor) {
        this.barColor = barColor;
    }

    public void setFirstLabelColorColor(Color firstLabelColor) {
        this.firstLabelColor = firstLabelColor;
    }
    public void setSecondLabelColorColor(Color secondLabelColor) {
        this.secondLabelColor = secondLabelColor;
    }

    public LabelAPI getProgressLabel() {
        return progressLabel;
    }

    /**
     * Basic custom progress bar based on the vanilla intel event progress bar, without progress label
     * @param width Component width float value
     * @param height Component height float value
     * @param barType ProgressBarType enum object
     * @param currProgress Float value between 0 and 1 (-1 and 1 for ProgressBarType.GOOD_BAD & .REL)
     */
    public ProgressBarComponent(float width, float height, ProgressBarType barType, float currProgress) {

        mainPanel = Global.getSettings().createCustom(width,height,this);
        this.barType = barType;
        this.barBracketsColor = Misc.getBasePlayerColor();

        createDataForBar(width, height, barType, currProgress);

        influencer.setMaxProgress(100);

        createUI();

    }

    /**
     * Advanced custom progress bar based on the vanilla intel event progress bar, with progress label
     * @param width Component width float value
     * @param height Component height float value
     * @param barLabelType ProgressBarLabelType enum object
     * @param barLabelFont A valid font string
     * @param barType ProgressBarType enum object
     * @param currProgress Float value between 0 and 1 (-1 and 1 for ProgressBarType.GOOD_BAD & .REL)
     */
    public ProgressBarComponent(float width, float height, ProgressBarLabelType barLabelType, String barLabelFont,
                                ProgressBarType barType, float currProgress) {
        mainPanel = Global.getSettings().createCustom(width,height,this);
        this.barType = barType;
        this.barLabelType = barLabelType;

        if(barLabelFont != null && !barLabelFont.isEmpty()){
            this.barLabelFont = Fonts.DEFAULT_SMALL;
        }
        else{
            this.barLabelFont = barLabelFont;
        }

        this.barBracketsColor = Misc.getBasePlayerColor();

        createDataForBar(width, height, barType, currProgress);

        influencer.setMaxProgress(100);

        // Set progress bar label
        switch (this.barLabelType) {
            case CURRENT_TOTAL -> this.barText = (int)(currProgress*100) + "/" + influencer.getMaxProgress();
            case CURRENT -> this.barText = (int)(currProgress*100) +"";
            default -> this.barText = (int)(currProgress*100)+"%";
        }

        createUI();

    }

    /**
     * Advanced custom progress bar based on the vanilla intel event progress bar, with full customization
     * @param width Component width float value
     * @param height Component height float value
     * @param barLabelType ProgressBarLabelType enum object
     * @param barLabelFont A valid font string
     * @param barType ProgressBarType enum object
     * @param barBracketsColor Brackets color object
     * @param currProgress Float value between 0 and 1 (-1 and 1 for ProgressBarType.GOOD_BAD & .REL)
     */
    public ProgressBarComponent(float width, float height, ProgressBarLabelType barLabelType, String barLabelFont,
                                ProgressBarType barType, Color barBracketsColor, float currProgress) {
        mainPanel = Global.getSettings().createCustom(width,height,this);
        this.barType = barType;
        this.barLabelType = barLabelType;

        if(barLabelFont != null && !barLabelFont.isEmpty()){
            this.barLabelFont = Fonts.DEFAULT_SMALL;
        }
        else{
            this.barLabelFont = barLabelFont;
        }

        this.barBracketsColor = barBracketsColor;

        createDataForBar(width, height, barType, currProgress);

        influencer.setMaxProgress(100);

        // Set progress bar label
        switch (this.barLabelType) {
            case CURRENT_TOTAL -> this.barText = (int)(currProgress*100) + "/" + influencer.getMaxProgress();
            case CURRENT -> this.barText = (int)(currProgress*100) +"";
            default -> this.barText = (int)(currProgress*100)+"%";
        }

        createUI();

    }

    private void createDataForBar(float width, float height, ProgressBarType barType, float currProgress) {
        this.progress = currProgress;
        if (currProgress > 1) this.progress = 1;
        if (barType != ProgressBarType.REL && barType != ProgressBarType.GOOD_BAD) {
            if (currProgress < 0) this.progress = 0;
        }
        else if (currProgress < -1) {
            this.progress = -1;
        }

        // Set progress bar coloring
        if (barType == ProgressBarType.GOOD_BAD) {
            // Positive & Negative Colors
            if (currProgress > 0) this.barColor = Misc.getPositiveHighlightColor();
            else this.barColor = Misc.getNegativeHighlightColor();
        }
        else if (barType == ProgressBarType.REL) {
            // Relationship Colors
            this.barColor = QOLFunctions.getRelationColor((int) (currProgress *100));
        }
        else {
            this.barColor = Misc.getBasePlayerColor();
        }

        this.influencer = new BaseEventIntel() {
            @Override
            public float getBarWidth() {
                return width -15;
            }

            @Override
            public float getBarHeight() {
                return height -4;
            }
            @Override
            public Color getBarBracketColor() {
                if (true) return Misc.getBasePlayerColor();
                return getBarColor();
            }
            @Override
            public Color getBarColor() {
                Color color = barColor;
                color = Misc.interpolateColor(color, Color.black, 0.25f);
                return color;
            }

            public TooltipMakerAPI.TooltipCreator getBarTooltip() {
                return new TooltipMakerAPI.TooltipCreator() {
                    public boolean isTooltipExpandable(Object tooltipParam) {
                        return false;
                    }
                    public float getTooltipWidth(Object tooltipParam) {
                        return 300;
                    }

                    public void createTooltip(TooltipMakerAPI tooltip, boolean expanded, Object tooltipParam) {
                        float opad = 10f;
                        Color h = Misc.getHighlightColor();

                        tooltip.addPara("Current Renown: %s / %s", 0f, h, "" + ProgressBarComponent.this.progress, "" + ProgressBarComponent.this.maxProgress);
                        int p = getMonthlyProgress();
                        String pStr = "" + p;
                        if (p > 0) pStr = "+" + p;
                        tooltip.addPara("Projected monthly change: %s renown.", opad, getProgressColor(p), pStr);

                        tooltip.addPara("Renown gain is influenced by various factors. Some of these apply over time, "
                                        + "and some only apply once. As you gain renown, different stages and outcomes may unfold.",
                                opad);
                    }
                };
            }

            public float getBarProgressIndicatorHeight() { return 10f; }
            public float getBarProgressIndicatorWidth() { return 10f; }
            public Color getBarProgressIndicatorLabelColor() { return Misc.getHighlightColor(); }
            public Color getBarProgressIndicatorColor() { return getBarColor(); }

        };
    }

    /**
     *
     * @return Instance of the mainPanel object
     */
    @Override
    public CustomPanelAPI getMainPanel() {
        return mainPanel;
    }

    /**
     * Create the actual UI
     */
    @Override
    public void createUI() {

        int percentage = Math.round(progress*influencer.getMaxProgress());
//        percentage = Math.round((float) percentage /100* influencer.getMaxProgress());
        influencer.setProgress(Math.abs(percentage));
        CustomPanelAPI componentPanel = Global.getSettings().createCustom(mainPanel.getPosition().getWidth(),mainPanel.getPosition().getHeight(),null);
        TooltipMakerAPI tooltip = componentPanel.createUIElement(componentPanel.getPosition().getWidth(),componentPanel.getPosition().getHeight(),false);
        EventProgressBarAPI barApi = tooltip.addEventProgressBar(influencer,0f);

        // Custom Progression Marker
        float yPad = 1.75f;
        float xToSetProgressionMarker = Math.abs((float) percentage /100* influencer.getBarWidth());
        if (percentage>-40 && percentage<40) xToSetProgressionMarker+=2;
        if (percentage<-75 || percentage>75) xToSetProgressionMarker-=3;
        if (percentage > -99 && percentage < 99) {
            for (int i = 0; i < influencer.getBarHeight()/2+1; i++) {
                UIComponentAPI rect1 = tooltip.createRect(Color.black, 0.75f);
                UIComponentAPI rect2 = tooltip.createRect(Misc.getBasePlayerColor().darker().darker(), 0.75f);
                barApi.addComponent(rect1).inTL(xToSetProgressionMarker-1, yPad);
                barApi.addComponent(rect2).inTL(xToSetProgressionMarker, yPad);
                yPad++;
                yPad++;
            }
        }

        if (barLabelFont != null && !barLabelFont.isEmpty()) tooltip.setParaFont(barLabelFont);

        if(barText!=null){
//            progressLabel = tooltip.addPara(barText,0f);
//            LabelAPI progressText = tooltip.createLabel(barText+" test",Misc.getTextColor());
//            progressText.setHighlight("test");
//            progressText.setHighlightColors(Misc.getHighlightColor());
//            barApi.addComponent((UIComponentAPI) progressText).inMid();
            LabelAPI progressText;
            switch (this.barLabelType) {
                case CURRENT_TOTAL : {
                    progressText = tooltip.createLabel(percentage + "/" + influencer.getMaxProgress(),Misc.getTextColor());
                    progressText.setHighlight(String.valueOf(percentage),String.valueOf(influencer.getMaxProgress()));
                    if (this.firstLabelColor == null) setFirstLabelColorColor(Misc.getTextColor());
                    if (this.secondLabelColor == null) setSecondLabelColorColor(Misc.getTextColor());
                    progressText.setHighlightColors(this.firstLabelColor,this.secondLabelColor);
                    break;
                }
                case CURRENT : {
                    progressText = tooltip.createLabel(percentage + "",Misc.getTextColor());
                    break;
                }
                default: {
                    progressText = tooltip.createLabel(percentage + "%",Misc.getTextColor());
                    break;
                }
            }
            barApi.addComponent((UIComponentAPI) progressText).inMid();
        }

//        float y = barApi.getPosition().getHeight();
//        float middle = y/2;
//        progressLabel.getPosition().inTL(componentPanel.getPosition().getWidth()/2-15,middle-(progressLabel.computeTextHeight(progressLabel.getText())/2));
        componentPanel.addUIElement(tooltip).inTL(0,0);
        mainPanel.addComponent(componentPanel).inTL(-5,0);
        if(this.componentPanel!=null){
            mainPanel.removeComponent(this.componentPanel);
        }
        this.componentPanel = componentPanel;

    }

    public void influenceLabel(){

    }

    @Override
    public void clearUI() {

    }

    @Override
    public void positionChanged(PositionAPI position) {

    }

    @Override
    public void renderBelow(float alphaMult) {

    }

    @Override
    public void render(float alphaMult) {

    }

    @Override
    public void advance(float amount) {
//        influencer.setMaxProgress(influencer.getMaxProgress()+1);
//        createUI();
    }

    @Override
    public void processInput(List<InputEventAPI> events) {

    }

    @Override
    public void buttonPressed(Object buttonId) {

    }
}
