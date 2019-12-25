// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import javax.swing.JButton;
import javax.swing.Action;
import java.awt.Component;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JComponent;
import com.jgoodies.forms.layout.ConstantSize;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.util.LayoutStyle;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.ColumnSpec;

public class ButtonBarBuilder2 extends AbstractButtonPanelBuilder
{
    private static final ColumnSpec[] COL_SPECS;
    private static final RowSpec[] ROW_SPECS;
    private boolean leftToRight;
    
    public ButtonBarBuilder2() {
        this(new JPanel(null));
    }
    
    public ButtonBarBuilder2(final JPanel panel) {
        super(new FormLayout(ButtonBarBuilder2.COL_SPECS, ButtonBarBuilder2.ROW_SPECS), panel);
        this.leftToRight = LayoutStyle.getCurrent().isLeftToRightButtonOrder();
    }
    
    public static ButtonBarBuilder2 createLeftToRightBuilder() {
        final ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.setLeftToRightButtonOrder(true);
        return builder;
    }
    
    public boolean isLeftToRightButtonOrder() {
        return this.leftToRight;
    }
    
    public void setLeftToRightButtonOrder(final boolean newButtonOrder) {
        this.leftToRight = newButtonOrder;
    }
    
    public void setDefaultButtonBarGapBorder() {
        this.setBorder(Borders.BUTTON_BAR_GAP_BORDER);
    }
    
    public void addGlue() {
        this.appendGlueColumn();
        this.nextColumn();
    }
    
    public void addRelatedGap() {
        this.appendRelatedComponentsGapColumn();
        this.nextColumn();
    }
    
    public void addUnrelatedGap() {
        this.appendUnrelatedComponentsGapColumn();
        this.nextColumn();
    }
    
    public void addStrut(final ConstantSize width) {
        this.getLayout().appendColumn(ColumnSpec.createGap(width));
        this.nextColumn();
    }
    
    public void addButton(final JComponent button) {
        button.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        this.getLayout().appendColumn(FormFactory.BUTTON_COLSPEC);
        this.add(button);
        this.nextColumn();
    }
    
    public void addButton(final JComponent button1, final JComponent button2) {
        this.addButton(new JComponent[] { button1, button2 });
    }
    
    public void addButton(final JComponent button1, final JComponent button2, final JComponent button3) {
        this.addButton(new JComponent[] { button1, button2, button3 });
    }
    
    public void addButton(final JComponent button1, final JComponent button2, final JComponent button3, final JComponent button4) {
        this.addButton(new JComponent[] { button1, button2, button3, button4 });
    }
    
    public void addButton(final JComponent button1, final JComponent button2, final JComponent button3, final JComponent button4, final JComponent button5) {
        this.addButton(new JComponent[] { button1, button2, button3, button4, button5 });
    }
    
    public void addButton(final JComponent[] buttons) {
        if (buttons == null) {
            throw new NullPointerException("The button array must not be null.");
        }
        final int length = buttons.length;
        if (length == 0) {
            throw new IllegalArgumentException("The button array must not be empty.");
        }
        for (int i = 0; i < length; ++i) {
            final int index = this.leftToRight ? i : (length - 1 - i);
            this.addButton(buttons[index]);
            if (i < buttons.length - 1) {
                this.addRelatedGap();
            }
        }
    }
    
    public void addButton(final Action action) {
        if (action == null) {
            throw new NullPointerException("The button Action must not be null.");
        }
        this.addButton(new JButton(action));
    }
    
    public void addButton(final Action action1, final Action action2) {
        this.addButton(new Action[] { action1, action2 });
    }
    
    public void addButton(final Action action1, final Action action2, final Action action3) {
        this.addButton(new Action[] { action1, action2, action3 });
    }
    
    public void addButton(final Action action1, final Action action2, final Action action3, final Action action4) {
        this.addButton(new Action[] { action1, action2, action3, action4 });
    }
    
    public void addButton(final Action action1, final Action action2, final Action action3, final Action action4, final Action action5) {
        this.addButton(new Action[] { action1, action2, action3, action4, action5 });
    }
    
    public void addButton(final Action[] actions) {
        if (actions == null) {
            throw new NullPointerException("The Action array must not be null.");
        }
        final int length = actions.length;
        if (length == 0) {
            throw new IllegalArgumentException("The Action array must not be empty.");
        }
        final JButton[] buttons = new JButton[length];
        for (int i = 0; i < length; ++i) {
            buttons[i] = new JButton(actions[i]);
        }
        this.addButton(buttons);
    }
    
    public void addGrowing(final JComponent component) {
        this.getLayout().appendColumn(FormFactory.GROWING_BUTTON_COLSPEC);
        component.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        this.add(component);
        this.nextColumn();
    }
    
    public void addGrowing(final JComponent[] buttons) {
        for (int length = buttons.length, i = 0; i < length; ++i) {
            final int index = this.leftToRight ? i : (length - 1 - i);
            this.addGrowing(buttons[index]);
            if (i < buttons.length - 1) {
                this.addRelatedGap();
            }
        }
    }
    
    public void addFixed(final JComponent component) {
        component.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        this.getLayout().appendColumn(FormFactory.PREF_COLSPEC);
        this.add(component);
        this.nextColumn();
    }
    
    static {
        COL_SPECS = new ColumnSpec[0];
        ROW_SPECS = new RowSpec[] { RowSpec.decode("center:pref") };
    }
}
