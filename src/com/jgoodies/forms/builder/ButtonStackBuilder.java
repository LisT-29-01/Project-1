// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import javax.swing.Action;
import com.jgoodies.forms.layout.Size;
import com.jgoodies.forms.layout.ConstantSize;
import java.awt.Component;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JComponent;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.ColumnSpec;

public final class ButtonStackBuilder extends PanelBuilder
{
    private static final ColumnSpec[] COL_SPECS;
    private static final RowSpec[] ROW_SPECS;
    private static final String NARROW_KEY = "jgoodies.isNarrow";
    
    public ButtonStackBuilder() {
        this(new JPanel(null));
    }
    
    public ButtonStackBuilder(final JPanel panel) {
        this(new FormLayout(ButtonStackBuilder.COL_SPECS, ButtonStackBuilder.ROW_SPECS), panel);
    }
    
    public ButtonStackBuilder(final FormLayout layout, final JPanel panel) {
        super(layout, panel);
        this.setOpaque(false);
    }
    
    public void addButtons(final JButton[] buttons) {
        for (int i = 0; i < buttons.length; ++i) {
            this.addGridded(buttons[i]);
            if (i < buttons.length - 1) {
                this.addRelatedGap();
            }
        }
    }
    
    public void addFixed(final JComponent component) {
        this.getLayout().appendRow(FormFactory.PREF_ROWSPEC);
        this.add(component);
        this.nextRow();
    }
    
    public void addGridded(final JComponent component) {
        this.getLayout().appendRow(FormFactory.PREF_ROWSPEC);
        this.getLayout().addGroupedRow(this.getRow());
        component.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        this.add(component);
        this.nextRow();
    }
    
    public void addGlue() {
        this.appendGlueRow();
        this.nextRow();
    }
    
    public void addRelatedGap() {
        this.appendRelatedComponentsGapRow();
        this.nextRow();
    }
    
    public void addUnrelatedGap() {
        this.appendUnrelatedComponentsGapRow();
        this.nextRow();
    }
    
    public void addStrut(final ConstantSize size) {
        this.getLayout().appendRow(new RowSpec(RowSpec.TOP, size, 0.0));
        this.nextRow();
    }
    
    public void addButton(final JButton button) {
        this.addButton(new JButton[] { button });
    }
    
    public void addButton(final JButton button1, final JButton button2) {
        this.addButton(new JButton[] { button1, button2 });
    }
    
    public void addButton(final JButton button1, final JButton button2, final JButton button3) {
        this.addButton(new JButton[] { button1, button2, button3 });
    }
    
    public void addButton(final JButton button1, final JButton button2, final JButton button3, final JButton button4) {
        this.addButton(new JButton[] { button1, button2, button3, button4 });
    }
    
    public void addButton(final JButton[] buttons) {
        this.addButtons(buttons);
    }
    
    public void addButton(final Action action) {
        this.addButton(new Action[] { action });
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
    
    public void addButton(final Action[] actions) {
        final JButton[] buttons = new JButton[actions.length];
        for (int i = 0; i < actions.length; ++i) {
            buttons[i] = new JButton(actions[i]);
        }
        this.addButtons(buttons);
    }
    
    static {
        COL_SPECS = new ColumnSpec[] { FormFactory.BUTTON_COLSPEC };
        ROW_SPECS = new RowSpec[0];
    }
}
