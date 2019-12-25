// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import java.awt.Component;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.LayoutManager;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import javax.swing.JPanel;

public abstract class AbstractButtonPanelBuilder
{
    protected static final String NARROW_KEY = "jgoodies.isNarrow";
    private final JPanel container;
    private final FormLayout layout;
    private final CellConstraints currentCellConstraints;
    private boolean leftToRight;
    
    protected AbstractButtonPanelBuilder(final FormLayout layout, final JPanel container) {
        if (layout == null) {
            throw new NullPointerException("The layout must not be null.");
        }
        if (container == null) {
            throw new NullPointerException("The layout container must not be null.");
        }
        (this.container = container).setLayout(this.layout = layout);
        this.setOpaque(false);
        this.currentCellConstraints = new CellConstraints();
        final ComponentOrientation orientation = container.getComponentOrientation();
        this.leftToRight = (orientation.isLeftToRight() || !orientation.isHorizontal());
    }
    
    public final JPanel getContainer() {
        return this.container;
    }
    
    public final JPanel getPanel() {
        return this.getContainer();
    }
    
    public final FormLayout getLayout() {
        return this.layout;
    }
    
    public final void setBackground(final Color background) {
        this.getPanel().setBackground(background);
    }
    
    public final void setBorder(final Border border) {
        this.getPanel().setBorder(border);
    }
    
    public final void setOpaque(final boolean b) {
        this.getPanel().setOpaque(b);
    }
    
    public final boolean isLeftToRight() {
        return this.leftToRight;
    }
    
    public final void setLeftToRight(final boolean b) {
        this.leftToRight = b;
    }
    
    protected final void nextColumn() {
        this.nextColumn(1);
    }
    
    private void nextColumn(final int columns) {
        final CellConstraints currentCellConstraints = this.currentCellConstraints;
        currentCellConstraints.gridX += columns * this.getColumnIncrementSign();
    }
    
    protected int getColumn() {
        return this.currentCellConstraints.gridX;
    }
    
    protected final void nextRow() {
        this.nextRow(1);
    }
    
    private void nextRow(final int rows) {
        final CellConstraints currentCellConstraints = this.currentCellConstraints;
        currentCellConstraints.gridY += rows;
    }
    
    protected final void appendColumn(final ColumnSpec columnSpec) {
        this.getLayout().appendColumn(columnSpec);
    }
    
    protected final void appendGlueColumn() {
        this.appendColumn(FormFactory.GLUE_COLSPEC);
    }
    
    protected final void appendRelatedComponentsGapColumn() {
        this.appendColumn(FormFactory.RELATED_GAP_COLSPEC);
    }
    
    protected final void appendUnrelatedComponentsGapColumn() {
        this.appendColumn(FormFactory.UNRELATED_GAP_COLSPEC);
    }
    
    protected final void appendRow(final RowSpec rowSpec) {
        this.getLayout().appendRow(rowSpec);
    }
    
    protected final void appendGlueRow() {
        this.appendRow(FormFactory.GLUE_ROWSPEC);
    }
    
    protected final void appendRelatedComponentsGapRow() {
        this.appendRow(FormFactory.RELATED_GAP_ROWSPEC);
    }
    
    protected final void appendUnrelatedComponentsGapRow() {
        this.appendRow(FormFactory.UNRELATED_GAP_ROWSPEC);
    }
    
    protected final Component add(final Component component) {
        this.container.add(component, this.currentCellConstraints);
        return component;
    }
    
    private int getColumnIncrementSign() {
        return this.isLeftToRight() ? 1 : -1;
    }
}
