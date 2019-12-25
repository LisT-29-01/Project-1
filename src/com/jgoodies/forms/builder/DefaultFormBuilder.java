// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import javax.swing.JComponent;
import javax.swing.JLabel;
import java.awt.Component;
import com.jgoodies.forms.layout.ConstantSize;
import com.jgoodies.forms.factories.FormFactory;
import java.util.ResourceBundle;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

public final class DefaultFormBuilder extends I15dPanelBuilder
{
    private RowSpec defaultRowSpec;
    private RowSpec lineGapSpec;
    private RowSpec paragraphGapSpec;
    private int leadingColumnOffset;
    private boolean rowGroupingEnabled;
    
    public DefaultFormBuilder(final FormLayout layout) {
        this(layout, new JPanel(null));
    }
    
    public DefaultFormBuilder(final FormLayout layout, final JPanel panel) {
        this(layout, null, panel);
    }
    
    public DefaultFormBuilder(final FormLayout layout, final ResourceBundle bundle) {
        this(layout, bundle, new JPanel(null));
    }
    
    public DefaultFormBuilder(final FormLayout layout, final ResourceBundle bundle, final JPanel panel) {
        super(layout, bundle, panel);
        this.defaultRowSpec = FormFactory.PREF_ROWSPEC;
        this.lineGapSpec = FormFactory.LINE_GAP_ROWSPEC;
        this.paragraphGapSpec = FormFactory.PARAGRAPH_GAP_ROWSPEC;
        this.leadingColumnOffset = 0;
        this.rowGroupingEnabled = false;
    }
    
    public RowSpec getDefaultRowSpec() {
        return this.defaultRowSpec;
    }
    
    public void setDefaultRowSpec(final RowSpec defaultRowSpec) {
        this.defaultRowSpec = defaultRowSpec;
    }
    
    public RowSpec getLineGapSpec() {
        return this.lineGapSpec;
    }
    
    public void setLineGapSize(final ConstantSize lineGapSize) {
        final RowSpec rowSpec = RowSpec.createGap(lineGapSize);
        this.lineGapSpec = rowSpec;
    }
    
    public void setParagraphGapSize(final ConstantSize paragraphGapSize) {
        final RowSpec rowSpec = RowSpec.createGap(paragraphGapSize);
        this.paragraphGapSpec = rowSpec;
    }
    
    public int getLeadingColumnOffset() {
        return this.leadingColumnOffset;
    }
    
    public void setLeadingColumnOffset(final int columnOffset) {
        this.leadingColumnOffset = columnOffset;
    }
    
    public boolean isRowGroupingEnabled() {
        return this.rowGroupingEnabled;
    }
    
    public void setRowGroupingEnabled(final boolean enabled) {
        this.rowGroupingEnabled = enabled;
    }
    
    public void append(final Component component) {
        this.append(component, 1);
    }
    
    public void append(final Component component, final int columnSpan) {
        this.ensureCursorColumnInGrid();
        this.ensureHasGapRow(this.lineGapSpec);
        this.ensureHasComponentLine();
        this.add(component, this.createLeftAdjustedConstraints(columnSpan));
        this.nextColumn(columnSpan + 1);
    }
    
    public void append(final Component c1, final Component c2) {
        this.append(c1);
        this.append(c2);
    }
    
    public void append(final Component c1, final Component c2, final Component c3) {
        this.append(c1);
        this.append(c2);
        this.append(c3);
    }
    
    public JLabel append(final String textWithMnemonic) {
        final JLabel label = this.getComponentFactory().createLabel(textWithMnemonic);
        this.append(label);
        return label;
    }
    
    public JLabel append(final String textWithMnemonic, final Component component) {
        return this.append(textWithMnemonic, component, 1);
    }
    
    public JLabel append(final String textWithMnemonic, final Component c, final boolean nextLine) {
        final JLabel label = this.append(textWithMnemonic, c);
        if (nextLine) {
            this.nextLine();
        }
        return label;
    }
    
    public JLabel append(final String textWithMnemonic, final Component c, final int columnSpan) {
        final JLabel label = this.append(textWithMnemonic);
        label.setLabelFor(c);
        this.append(c, columnSpan);
        return label;
    }
    
    public JLabel append(final String textWithMnemonic, final Component c1, final Component c2) {
        final JLabel label = this.append(textWithMnemonic, c1);
        this.append(c2);
        return label;
    }
    
    public JLabel append(final String textWithMnemonic, final Component c1, final Component c2, final int colSpan) {
        final JLabel label = this.append(textWithMnemonic, c1);
        this.append(c2, colSpan);
        return label;
    }
    
    public JLabel append(final String textWithMnemonic, final Component c1, final Component c2, final Component c3) {
        final JLabel label = this.append(textWithMnemonic, c1, c2);
        this.append(c3);
        return label;
    }
    
    public JLabel append(final String textWithMnemonic, final Component c1, final Component c2, final Component c3, final Component c4) {
        final JLabel label = this.append(textWithMnemonic, c1, c2, c3);
        this.append(c4);
        return label;
    }
    
    public JLabel appendI15d(final String resourceKey) {
        return this.append(this.getI15dString(resourceKey));
    }
    
    public JLabel appendI15d(final String resourceKey, final Component component) {
        return this.append(this.getI15dString(resourceKey), component, 1);
    }
    
    public JLabel appendI15d(final String resourceKey, final Component component, final boolean nextLine) {
        return this.append(this.getI15dString(resourceKey), component, nextLine);
    }
    
    public JLabel appendI15d(final String resourceKey, final Component c, final int columnSpan) {
        return this.append(this.getI15dString(resourceKey), c, columnSpan);
    }
    
    public JLabel appendI15d(final String resourceKey, final Component c1, final Component c2) {
        return this.append(this.getI15dString(resourceKey), c1, c2);
    }
    
    public JLabel appendI15d(final String resourceKey, final Component c1, final Component c2, final int colSpan) {
        return this.append(this.getI15dString(resourceKey), c1, c2, colSpan);
    }
    
    public JLabel appendI15d(final String resourceKey, final Component c1, final Component c2, final Component c3) {
        return this.append(this.getI15dString(resourceKey), c1, c2, c3);
    }
    
    public JLabel appendI15d(final String resourceKey, final Component c1, final Component c2, final Component c3, final Component c4) {
        return this.append(this.getI15dString(resourceKey), c1, c2, c3, c4);
    }
    
    public JLabel appendTitle(final String textWithMnemonic) {
        final JLabel titleLabel = this.getComponentFactory().createTitle(textWithMnemonic);
        this.append(titleLabel);
        return titleLabel;
    }
    
    public JLabel appendI15dTitle(final String resourceKey) {
        return this.appendTitle(this.getI15dString(resourceKey));
    }
    
    public JComponent appendSeparator() {
        return this.appendSeparator("");
    }
    
    public JComponent appendSeparator(final String text) {
        this.ensureCursorColumnInGrid();
        this.ensureHasGapRow(this.paragraphGapSpec);
        this.ensureHasComponentLine();
        this.setColumn(super.getLeadingColumn());
        final int columnSpan = this.getColumnCount();
        this.setColumnSpan(this.getColumnCount());
        final JComponent titledSeparator = this.addSeparator(text);
        this.setColumnSpan(1);
        this.nextColumn(columnSpan);
        return titledSeparator;
    }
    
    public JComponent appendI15dSeparator(final String resourceKey) {
        return this.appendSeparator(this.getI15dString(resourceKey));
    }
    
    protected int getLeadingColumn() {
        final int column = super.getLeadingColumn();
        return column + this.getLeadingColumnOffset() * this.getColumnIncrementSign();
    }
    
    private void ensureCursorColumnInGrid() {
        if ((this.isLeftToRight() && this.getColumn() > this.getColumnCount()) || (!this.isLeftToRight() && this.getColumn() < 1)) {
            this.nextLine();
        }
    }
    
    private void ensureHasGapRow(final RowSpec gapRowSpec) {
        if (this.getRow() == 1 || this.getRow() <= this.getRowCount()) {
            return;
        }
        if (this.getRow() <= this.getRowCount()) {
            final RowSpec rowSpec = this.getCursorRowSpec();
            if (rowSpec == gapRowSpec) {
                return;
            }
        }
        this.appendRow(gapRowSpec);
        this.nextLine();
    }
    
    private void ensureHasComponentLine() {
        if (this.getRow() <= this.getRowCount()) {
            return;
        }
        this.appendRow(this.getDefaultRowSpec());
        if (this.isRowGroupingEnabled()) {
            this.getLayout().addGroupedRow(this.getRow());
        }
    }
    
    private RowSpec getCursorRowSpec() {
        return (RowSpec) this.getLayout().getRowSpec(this.getRow());
    }
}
