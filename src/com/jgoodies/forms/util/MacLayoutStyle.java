// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.util;

import com.jgoodies.forms.layout.Sizes;
import com.jgoodies.forms.layout.ConstantSize;
import com.jgoodies.forms.layout.Size;

final class MacLayoutStyle extends LayoutStyle
{
    static final MacLayoutStyle INSTANCE;
    private static final Size BUTTON_WIDTH;
    private static final Size BUTTON_HEIGHT;
    private static final ConstantSize DIALOG_MARGIN_X;
    private static final ConstantSize DIALOG_MARGIN_Y;
    private static final ConstantSize TABBED_DIALOG_MARGIN_X;
    private static final ConstantSize TABBED_DIALOG_MARGIN_Y;
    private static final ConstantSize LABEL_COMPONENT_PADX;
    private static final ConstantSize RELATED_COMPONENTS_PADX;
    private static final ConstantSize UNRELATED_COMPONENTS_PADX;
    private static final ConstantSize RELATED_COMPONENTS_PADY;
    private static final ConstantSize UNRELATED_COMPONENTS_PADY;
    private static final ConstantSize NARROW_LINE_PAD;
    private static final ConstantSize LINE_PAD;
    private static final ConstantSize PARAGRAPH_PAD;
    private static final ConstantSize BUTTON_BAR_PAD;
    
    private MacLayoutStyle() {
    }
    
    public Size getDefaultButtonWidth() {
        return MacLayoutStyle.BUTTON_WIDTH;
    }
    
    public Size getDefaultButtonHeight() {
        return MacLayoutStyle.BUTTON_HEIGHT;
    }
    
    public ConstantSize getDialogMarginX() {
        return MacLayoutStyle.DIALOG_MARGIN_X;
    }
    
    public ConstantSize getDialogMarginY() {
        return MacLayoutStyle.DIALOG_MARGIN_Y;
    }
    
    public ConstantSize getTabbedDialogMarginX() {
        return MacLayoutStyle.TABBED_DIALOG_MARGIN_X;
    }
    
    public ConstantSize getTabbedDialogMarginY() {
        return MacLayoutStyle.TABBED_DIALOG_MARGIN_Y;
    }
    
    public ConstantSize getLabelComponentPadX() {
        return MacLayoutStyle.LABEL_COMPONENT_PADX;
    }
    
    public ConstantSize getRelatedComponentsPadX() {
        return MacLayoutStyle.RELATED_COMPONENTS_PADX;
    }
    
    public ConstantSize getRelatedComponentsPadY() {
        return MacLayoutStyle.RELATED_COMPONENTS_PADY;
    }
    
    public ConstantSize getUnrelatedComponentsPadX() {
        return MacLayoutStyle.UNRELATED_COMPONENTS_PADX;
    }
    
    public ConstantSize getUnrelatedComponentsPadY() {
        return MacLayoutStyle.UNRELATED_COMPONENTS_PADY;
    }
    
    public ConstantSize getNarrowLinePad() {
        return MacLayoutStyle.NARROW_LINE_PAD;
    }
    
    public ConstantSize getLinePad() {
        return MacLayoutStyle.LINE_PAD;
    }
    
    public ConstantSize getParagraphPad() {
        return MacLayoutStyle.PARAGRAPH_PAD;
    }
    
    public ConstantSize getButtonBarPad() {
        return MacLayoutStyle.BUTTON_BAR_PAD;
    }
    
    public boolean isLeftToRightButtonOrder() {
        return false;
    }
    
    static {
        INSTANCE = new MacLayoutStyle();
        BUTTON_WIDTH = Sizes.dluX(54);
        BUTTON_HEIGHT = Sizes.dluY(14);
        DIALOG_MARGIN_X = Sizes.DLUX9;
        DIALOG_MARGIN_Y = Sizes.DLUY9;
        TABBED_DIALOG_MARGIN_X = Sizes.DLUX4;
        TABBED_DIALOG_MARGIN_Y = Sizes.DLUY4;
        LABEL_COMPONENT_PADX = Sizes.DLUX3;
        RELATED_COMPONENTS_PADX = Sizes.DLUX4;
        UNRELATED_COMPONENTS_PADX = Sizes.DLUX8;
        RELATED_COMPONENTS_PADY = Sizes.DLUY3;
        UNRELATED_COMPONENTS_PADY = Sizes.DLUY6;
        NARROW_LINE_PAD = Sizes.DLUY2;
        LINE_PAD = Sizes.DLUY3;
        PARAGRAPH_PAD = Sizes.DLUY9;
        BUTTON_BAR_PAD = Sizes.DLUY4;
    }
}
