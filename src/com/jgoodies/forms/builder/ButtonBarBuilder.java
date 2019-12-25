// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import com.jgoodies.forms.layout.ConstantSize;
import java.awt.Component;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JComponent;
import javax.swing.JButton;
import com.jgoodies.forms.factories.Borders;
import com.jgoodies.forms.util.LayoutStyle;
import com.jgoodies.forms.layout.FormLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.ColumnSpec;

public final class ButtonBarBuilder extends PanelBuilder
{
    private static final ColumnSpec[] COL_SPECS;
    private static final RowSpec[] ROW_SPECS;
    private static final String NARROW_KEY = "jgoodies.isNarrow";
    private boolean leftToRight;
    
    public ButtonBarBuilder() {
        this(new JPanel(null));
    }
    
    public ButtonBarBuilder(final JPanel panel) {
        super(new FormLayout(ButtonBarBuilder.COL_SPECS, ButtonBarBuilder.ROW_SPECS), panel);
        this.leftToRight = LayoutStyle.getCurrent().isLeftToRightButtonOrder();
    }
    
    public static ButtonBarBuilder createLeftToRightBuilder() {
        final ButtonBarBuilder builder = new ButtonBarBuilder();
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
    
    public void addGriddedButtons(final JButton[] buttons) {
        for (int length = buttons.length, i = 0; i < length; ++i) {
            final int index = this.leftToRight ? i : (length - 1 - i);
            this.addGridded(buttons[index]);
            if (i < buttons.length - 1) {
                this.addRelatedGap();
            }
        }
    }
    
    public void addGriddedGrowingButtons(final JButton[] buttons) {
        for (int length = buttons.length, i = 0; i < length; ++i) {
            final int index = this.leftToRight ? i : (length - 1 - i);
            this.addGriddedGrowing(buttons[index]);
            if (i < buttons.length - 1) {
                this.addRelatedGap();
            }
        }
    }
    
    public void addFixed(final JComponent component) {
        this.getLayout().appendColumn(FormFactory.PREF_COLSPEC);
        this.add(component);
        this.nextColumn();
    }
    
    public void addFixedNarrow(final JComponent component) {
        component.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        this.addFixed(component);
    }
    
    public void addGridded(final JComponent component) {
        this.getLayout().appendColumn(FormFactory.BUTTON_COLSPEC);
        this.getLayout().addGroupedColumn(this.getColumn());
        component.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        this.add(component);
        this.nextColumn();
    }
    
    public void addGriddedGrowing(final JComponent component) {
        this.getLayout().appendColumn(FormFactory.GROWING_BUTTON_COLSPEC);
        this.getLayout().addGroupedColumn(this.getColumn());
        component.putClientProperty("jgoodies.isNarrow", Boolean.TRUE);
        this.add(component);
        this.nextColumn();
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
    
    static {
        COL_SPECS = new ColumnSpec[0];
        ROW_SPECS = new RowSpec[] { RowSpec.decode("center:pref") };
    }
}
