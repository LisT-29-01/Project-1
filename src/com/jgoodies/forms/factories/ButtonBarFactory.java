// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.factories;

import java.awt.Component;
import javax.swing.JComponent;
import com.jgoodies.forms.builder.ButtonBarBuilder2;
import javax.swing.JPanel;
import javax.swing.JButton;

public final class ButtonBarFactory
{
    private ButtonBarFactory() {
    }
    
    public static JPanel buildLeftAlignedBar(final JButton button1) {
        return buildLeftAlignedBar(new JButton[] { button1 });
    }
    
    public static JPanel buildLeftAlignedBar(final JButton button1, final JButton button2) {
        return buildLeftAlignedBar(new JButton[] { button1, button2 }, true);
    }
    
    public static JPanel buildLeftAlignedBar(final JButton button1, final JButton button2, final JButton button3) {
        return buildLeftAlignedBar(new JButton[] { button1, button2, button3 }, true);
    }
    
    public static JPanel buildLeftAlignedBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4) {
        return buildLeftAlignedBar(new JButton[] { button1, button2, button3, button4 }, true);
    }
    
    public static JPanel buildLeftAlignedBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4, final JButton button5) {
        return buildLeftAlignedBar(new JButton[] { button1, button2, button3, button4, button5 }, true);
    }
    
    public static JPanel buildLeftAlignedBar(final JButton[] buttons) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addButton(buttons);
        builder.addGlue();
        return builder.getPanel();
    }
    
    public static JPanel buildLeftAlignedBar(final JButton[] buttons, final boolean leftToRightButtonOrder) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.setLeftToRightButtonOrder(leftToRightButtonOrder);
        builder.addButton(buttons);
        builder.addGlue();
        return builder.getPanel();
    }
    
    public static JPanel buildCenteredBar(final JButton button1) {
        return buildCenteredBar(new JButton[] { button1 });
    }
    
    public static JPanel buildCenteredBar(final JButton button1, final JButton button2) {
        return buildCenteredBar(new JButton[] { button1, button2 });
    }
    
    public static JPanel buildCenteredBar(final JButton button1, final JButton button2, final JButton button3) {
        return buildCenteredBar(new JButton[] { button1, button2, button3 });
    }
    
    public static JPanel buildCenteredBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4) {
        return buildCenteredBar(new JButton[] { button1, button2, button3, button4 });
    }
    
    public static JPanel buildCenteredBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4, final JButton button5) {
        return buildCenteredBar(new JButton[] { button1, button2, button3, button4, button5 });
    }
    
    public static JPanel buildCenteredBar(final JButton[] buttons) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addGlue();
        builder.addButton(buttons);
        builder.addGlue();
        return builder.getPanel();
    }
    
    public static JPanel buildGrowingBar(final JButton button1) {
        return buildGrowingBar(new JButton[] { button1 });
    }
    
    public static JPanel buildGrowingBar(final JButton button1, final JButton button2) {
        return buildGrowingBar(new JButton[] { button1, button2 });
    }
    
    public static JPanel buildGrowingBar(final JButton button1, final JButton button2, final JButton button3) {
        return buildGrowingBar(new JButton[] { button1, button2, button3 });
    }
    
    public static JPanel buildGrowingBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4) {
        return buildGrowingBar(new JButton[] { button1, button2, button3, button4 });
    }
    
    public static JPanel buildGrowingBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4, final JButton button5) {
        return buildGrowingBar(new JButton[] { button1, button2, button3, button4, button5 });
    }
    
    public static JPanel buildGrowingBar(final JButton[] buttons) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addGrowing(buttons);
        return builder.getPanel();
    }
    
    public static JPanel buildRightAlignedBar(final JButton button1) {
        return buildRightAlignedBar(new JButton[] { button1 });
    }
    
    public static JPanel buildRightAlignedBar(final JButton button1, final JButton button2) {
        return buildRightAlignedBar(new JButton[] { button1, button2 }, true);
    }
    
    public static JPanel buildRightAlignedBar(final JButton button1, final JButton button2, final JButton button3) {
        return buildRightAlignedBar(new JButton[] { button1, button2, button3 }, true);
    }
    
    public static JPanel buildRightAlignedBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4) {
        return buildRightAlignedBar(new JButton[] { button1, button2, button3, button4 }, true);
    }
    
    public static JPanel buildRightAlignedBar(final JButton button1, final JButton button2, final JButton button3, final JButton button4, final JButton button5) {
        return buildRightAlignedBar(new JButton[] { button1, button2, button3, button4, button5 }, true);
    }
    
    public static JPanel buildRightAlignedBar(final JButton[] buttons) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addGlue();
        builder.addButton(buttons);
        return builder.getPanel();
    }
    
    public static JPanel buildRightAlignedBar(final JButton[] buttons, final boolean leftToRightButtonOrder) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.setLeftToRightButtonOrder(leftToRightButtonOrder);
        builder.addGlue();
        builder.addButton(buttons);
        return builder.getPanel();
    }
    
    public static JPanel buildHelpBar(final JButton help, final JButton button1) {
        return buildHelpBar(help, new JButton[] { button1 });
    }
    
    public static JPanel buildHelpBar(final JButton help, final JButton button1, final JButton button2) {
        return buildHelpBar(help, new JButton[] { button1, button2 });
    }
    
    public static JPanel buildHelpBar(final JButton help, final JButton button1, final JButton button2, final JButton button3) {
        return buildHelpBar(help, new JButton[] { button1, button2, button3 });
    }
    
    public static JPanel buildHelpBar(final JButton help, final JButton button1, final JButton button2, final JButton button3, final JButton button4) {
        return buildHelpBar(help, new JButton[] { button1, button2, button3, button4 });
    }
    
    public static JPanel buildHelpBar(final JButton help, final JButton[] buttons) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addButton(help);
        builder.addUnrelatedGap();
        builder.addGlue();
        builder.addButton(buttons);
        return builder.getPanel();
    }
    
    public static JPanel buildCloseBar(final JButton close) {
        return buildRightAlignedBar(close);
    }
    
    public static JPanel buildOKBar(final JButton ok) {
        return buildRightAlignedBar(ok);
    }
    
    public static JPanel buildOKCancelBar(final JButton ok, final JButton cancel) {
        return buildRightAlignedBar(new JButton[] { ok, cancel });
    }
    
    public static JPanel buildOKCancelApplyBar(final JButton ok, final JButton cancel, final JButton apply) {
        return buildRightAlignedBar(new JButton[] { ok, cancel, apply });
    }
    
    public static JPanel buildHelpCloseBar(final JButton help, final JButton close) {
        return buildHelpBar(help, close);
    }
    
    public static JPanel buildHelpOKBar(final JButton help, final JButton ok) {
        return buildHelpBar(help, ok);
    }
    
    public static JPanel buildHelpOKCancelBar(final JButton help, final JButton ok, final JButton cancel) {
        return buildHelpBar(help, ok, cancel);
    }
    
    public static JPanel buildHelpOKCancelApplyBar(final JButton help, final JButton ok, final JButton cancel, final JButton apply) {
        return buildHelpBar(help, ok, cancel, apply);
    }
    
    public static JPanel buildCloseHelpBar(final JButton close, final JButton help) {
        return buildRightAlignedBar(new JButton[] { close, help });
    }
    
    public static JPanel buildOKHelpBar(final JButton ok, final JButton help) {
        return buildRightAlignedBar(new JButton[] { ok, help });
    }
    
    public static JPanel buildOKCancelHelpBar(final JButton ok, final JButton cancel, final JButton help) {
        return buildRightAlignedBar(new JButton[] { ok, cancel, help });
    }
    
    public static JPanel buildOKCancelApplyHelpBar(final JButton ok, final JButton cancel, final JButton apply, final JButton help) {
        return buildRightAlignedBar(new JButton[] { ok, cancel, apply, help });
    }
    
    public static JPanel buildAddRemoveLeftBar(final JButton add, final JButton remove) {
        return buildLeftAlignedBar(add, remove);
    }
    
    public static JPanel buildAddRemoveBar(final JButton add, final JButton remove) {
        return buildGrowingBar(add, remove);
    }
    
    public static JPanel buildAddRemoveRightBar(final JButton add, final JButton remove) {
        return buildRightAlignedBar(add, remove);
    }
    
    public static JPanel buildAddRemovePropertiesLeftBar(final JButton add, final JButton remove, final JButton properties) {
        return buildLeftAlignedBar(add, remove, properties);
    }
    
    public static JPanel buildAddRemovePropertiesBar(final JButton add, final JButton remove, final JButton properties) {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addButton(add);
        builder.addRelatedGap();
        builder.addButton(remove);
        builder.addRelatedGap();
        builder.addButton(properties);
        return builder.getPanel();
    }
    
    public static JPanel buildAddRemovePropertiesRightBar(final JButton add, final JButton remove, final JButton properties) {
        return buildRightAlignedBar(add, remove, properties);
    }
    
    public static JPanel buildWizardBar(final JButton back, final JButton next, final JButton finish, final JButton cancel) {
        return buildWizardBar(back, next, new JButton[] { finish, cancel });
    }
    
    public static JPanel buildWizardBar(final JButton help, final JButton back, final JButton next, final JButton finish, final JButton cancel) {
        return buildWizardBar(new JButton[] { help }, back, next, new JButton[] { finish, cancel });
    }
    
    public static JPanel buildWizardBar(final JButton back, final JButton next, final JButton[] rightAlignedButtons) {
        return buildWizardBar(null, back, next, rightAlignedButtons);
    }
    
    public static JPanel buildWizardBar(final JButton[] leftAlignedButtons, final JButton back, final JButton next, final JButton[] rightAlignedButtons) {
        return buildWizardBar(leftAlignedButtons, back, next, null, rightAlignedButtons);
    }
    
    public static JPanel buildWizardBar(final JButton[] leftAlignedButtons, final JButton back, final JButton next, final JButton overlaidFinish, final JButton[] rightAlignedButtons) {
        final MyButtonBarBuilder2 builder = new MyButtonBarBuilder2();
        if (leftAlignedButtons != null) {
            builder.addButton(leftAlignedButtons);
            builder.addRelatedGap();
        }
        builder.addGlue();
        builder.addButton(back);
        builder.addButton(next);
        if (overlaidFinish != null) {
            builder.getPanel().add(overlaidFinish, CC.xy(builder.getColumn(), 1));
        }
        if (rightAlignedButtons != null) {
            builder.addRelatedGap();
            builder.addButton(rightAlignedButtons);
        }
        return builder.getPanel();
    }
    
    private static final class MyButtonBarBuilder2 extends ButtonBarBuilder2
    {
        public int getColumn() {
            return super.getColumn();
        }
    }
}
