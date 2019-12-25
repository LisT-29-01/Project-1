// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.util;

import com.jgoodies.forms.layout.Sizes;
import com.jgoodies.forms.layout.ConstantSize;
import com.jgoodies.forms.layout.Size;

final class WindowsLayoutStyle extends LayoutStyle
{
    static final WindowsLayoutStyle INSTANCE;
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
    
    private WindowsLayoutStyle() {
    }
    
    public Size getDefaultButtonWidth() {
        return WindowsLayoutStyle.BUTTON_WIDTH;
    }
    
    public Size getDefaultButtonHeight() {
        return WindowsLayoutStyle.BUTTON_HEIGHT;
    }
    
    public ConstantSize getDialogMarginX() {
        return WindowsLayoutStyle.DIALOG_MARGIN_X;
    }
    
    public ConstantSize getDialogMarginY() {
        return WindowsLayoutStyle.DIALOG_MARGIN_Y;
    }
    
    public ConstantSize getTabbedDialogMarginX() {
        return WindowsLayoutStyle.TABBED_DIALOG_MARGIN_X;
    }
    
    public ConstantSize getTabbedDialogMarginY() {
        return WindowsLayoutStyle.TABBED_DIALOG_MARGIN_Y;
    }
    
    public ConstantSize getLabelComponentPadX() {
        return WindowsLayoutStyle.LABEL_COMPONENT_PADX;
    }
    
    public ConstantSize getRelatedComponentsPadX() {
        return WindowsLayoutStyle.RELATED_COMPONENTS_PADX;
    }
    
    public ConstantSize getRelatedComponentsPadY() {
        return WindowsLayoutStyle.RELATED_COMPONENTS_PADY;
    }
    
    public ConstantSize getUnrelatedComponentsPadX() {
        return WindowsLayoutStyle.UNRELATED_COMPONENTS_PADX;
    }
    
    public ConstantSize getUnrelatedComponentsPadY() {
        return WindowsLayoutStyle.UNRELATED_COMPONENTS_PADY;
    }
    
    public ConstantSize getNarrowLinePad() {
        return WindowsLayoutStyle.NARROW_LINE_PAD;
    }
    
    public ConstantSize getLinePad() {
        return WindowsLayoutStyle.LINE_PAD;
    }
    
    public ConstantSize getParagraphPad() {
        return WindowsLayoutStyle.PARAGRAPH_PAD;
    }
    
    public ConstantSize getButtonBarPad() {
        return WindowsLayoutStyle.BUTTON_BAR_PAD;
    }
    
    public boolean isLeftToRightButtonOrder() {
        return true;
    }
    
    static {
        INSTANCE = new WindowsLayoutStyle();
        BUTTON_WIDTH = Sizes.dluX(50);
        BUTTON_HEIGHT = Sizes.dluY(14);
        DIALOG_MARGIN_X = Sizes.DLUX7;
        DIALOG_MARGIN_Y = Sizes.DLUY7;
        TABBED_DIALOG_MARGIN_X = Sizes.DLUX4;
        TABBED_DIALOG_MARGIN_Y = Sizes.DLUY4;
        LABEL_COMPONENT_PADX = Sizes.DLUX3;
        RELATED_COMPONENTS_PADX = Sizes.DLUX4;
        UNRELATED_COMPONENTS_PADX = Sizes.DLUX7;
        RELATED_COMPONENTS_PADY = Sizes.DLUY4;
        UNRELATED_COMPONENTS_PADY = Sizes.DLUY7;
        NARROW_LINE_PAD = Sizes.DLUY2;
        LINE_PAD = Sizes.DLUY3;
        PARAGRAPH_PAD = Sizes.DLUY9;
        BUTTON_BAR_PAD = Sizes.DLUY5;
    }
}
