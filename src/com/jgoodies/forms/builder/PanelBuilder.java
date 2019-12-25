// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import javax.swing.JScrollPane;
import javax.swing.JComponent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.factories.ComponentFactory2;
import java.awt.Component;
import com.jgoodies.forms.layout.CellConstraints;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.Borders;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import java.lang.ref.WeakReference;
import com.jgoodies.forms.factories.ComponentFactory;

public class PanelBuilder extends AbstractFormBuilder
{
    private static final String LABELED_BY_PROPERTY = "labeledBy";
    private static boolean labelForFeatureEnabledDefault;
    private ComponentFactory componentFactory;
    private boolean labelForFeatureEnabled;
    private WeakReference mostRecentlyAddedLabelReference;
    
    public PanelBuilder(final FormLayout layout) {
        this(layout, new JPanel(null));
    }
    
    public PanelBuilder(final FormLayout layout, final JPanel panel) {
        super(layout, panel);
        this.mostRecentlyAddedLabelReference = null;
        this.labelForFeatureEnabled = PanelBuilder.labelForFeatureEnabledDefault;
    }
    
    public static boolean getLabelForFeatureEnabledDefault() {
        return PanelBuilder.labelForFeatureEnabledDefault;
    }
    
    public static void setLabelForFeatureEnabledDefault(final boolean b) {
        PanelBuilder.labelForFeatureEnabledDefault = b;
    }
    
    public boolean isLabelForFeatureEnabled() {
        return this.labelForFeatureEnabled;
    }
    
    public void setLabelForFeatureEnabled(final boolean b) {
        this.labelForFeatureEnabled = b;
    }
    
    public final JPanel getPanel() {
        return (JPanel)this.getContainer();
    }
    
    public final void setBackground(final Color background) {
        this.getPanel().setBackground(background);
    }
    
    public final void setBorder(final Border border) {
        this.getPanel().setBorder(border);
    }
    
    public final void setDefaultDialogBorder() {
        this.setBorder(Borders.DIALOG_BORDER);
    }
    
    public final void setOpaque(final boolean b) {
        this.getPanel().setOpaque(b);
    }
    
    public final JLabel addLabel(final String textWithMnemonic) {
        return this.addLabel(textWithMnemonic, this.cellConstraints());
    }
    
    public final JLabel addLabel(final String textWithMnemonic, final CellConstraints constraints) {
        final JLabel label = this.getComponentFactory().createLabel(textWithMnemonic);
        this.add(label, constraints);
        return label;
    }
    
    public final JLabel addLabel(final String textWithMnemonic, final String encodedConstraints) {
        return this.addLabel(textWithMnemonic, new CellConstraints(encodedConstraints));
    }
    
    public final JLabel addLabel(final String textWithMnemonic, final CellConstraints labelConstraints, final Component component, final CellConstraints componentConstraints) {
        if (labelConstraints == componentConstraints) {
            throw new IllegalArgumentException("You must provide two CellConstraints instances, one for the label and one for the component.\nConsider using #clone(). See the JavaDocs for details.");
        }
        final JLabel label = this.addLabel(textWithMnemonic, labelConstraints);
        this.add(component, componentConstraints);
        label.setLabelFor(component);
        return label;
    }
    
    public final JLabel addROLabel(final String textWithMnemonic) {
        return this.addROLabel(textWithMnemonic, this.cellConstraints());
    }
    
    public final JLabel addROLabel(final String textWithMnemonic, final CellConstraints constraints) {
        final ComponentFactory factory = this.getComponentFactory();
        ComponentFactory2 factory2;
        if (factory instanceof ComponentFactory2) {
            factory2 = (ComponentFactory2)factory;
        }
        else {
            factory2 = DefaultComponentFactory.getInstance();
        }
        final JLabel label = factory2.createReadOnlyLabel(textWithMnemonic);
        this.add(label, constraints);
        return label;
    }
    
    public final JLabel addROLabel(final String textWithMnemonic, final String encodedConstraints) {
        return this.addROLabel(textWithMnemonic, new CellConstraints(encodedConstraints));
    }
    
    public final JLabel addROLabel(final String textWithMnemonic, final CellConstraints labelConstraints, final Component component, final CellConstraints componentConstraints) {
        if (labelConstraints == componentConstraints) {
            throw new IllegalArgumentException("You must provide two CellConstraints instances, one for the label and one for the component.\nConsider using #clone(). See the JavaDocs for details.");
        }
        final JLabel label = this.addROLabel(textWithMnemonic, labelConstraints);
        this.add(component, componentConstraints);
        label.setLabelFor(component);
        return label;
    }
    
    public final JLabel addTitle(final String textWithMnemonic) {
        return this.addTitle(textWithMnemonic, this.cellConstraints());
    }
    
    public final JLabel addTitle(final String textWithMnemonic, final CellConstraints constraints) {
        final JLabel titleLabel = this.getComponentFactory().createTitle(textWithMnemonic);
        this.add(titleLabel, constraints);
        return titleLabel;
    }
    
    public final JLabel addTitle(final String textWithMnemonic, final String encodedConstraints) {
        return this.addTitle(textWithMnemonic, new CellConstraints(encodedConstraints));
    }
    
    public final JComponent addSeparator(final String textWithMnemonic) {
        return this.addSeparator(textWithMnemonic, this.getLayout().getColumnCount());
    }
    
    public final JComponent addSeparator(final String textWithMnemonic, final CellConstraints constraints) {
        final int titleAlignment = this.isLeftToRight() ? 2 : 4;
        final JComponent titledSeparator = this.getComponentFactory().createSeparator(textWithMnemonic, titleAlignment);
        this.add(titledSeparator, constraints);
        return titledSeparator;
    }
    
    public final JComponent addSeparator(final String textWithMnemonic, final String encodedConstraints) {
        return this.addSeparator(textWithMnemonic, new CellConstraints(encodedConstraints));
    }
    
    public final JComponent addSeparator(final String textWithMnemonic, final int columnSpan) {
        return this.addSeparator(textWithMnemonic, this.createLeftAdjustedConstraints(columnSpan));
    }
    
    public final JLabel add(final JLabel label, final CellConstraints labelConstraints, final Component component, final CellConstraints componentConstraints) {
        if (labelConstraints == componentConstraints) {
            throw new IllegalArgumentException("You must provide two CellConstraints instances, one for the label and one for the component.\nConsider using #clone(). See the JavaDocs for details.");
        }
        this.add(label, labelConstraints);
        this.add(component, componentConstraints);
        label.setLabelFor(component);
        return label;
    }
    
    public final ComponentFactory getComponentFactory() {
        if (this.componentFactory == null) {
            this.componentFactory = DefaultComponentFactory.getInstance();
        }
        return this.componentFactory;
    }
    
    public final void setComponentFactory(final ComponentFactory newFactory) {
        this.componentFactory = newFactory;
    }
    
    public Component add(final Component component, final CellConstraints cellConstraints) {
        final Component result = super.add(component, cellConstraints);
        if (!this.isLabelForFeatureEnabled()) {
            return result;
        }
        final JLabel mostRecentlyAddedLabel = this.getMostRecentlyAddedLabel();
        if (mostRecentlyAddedLabel != null && this.isLabelForApplicable(mostRecentlyAddedLabel, component)) {
            this.setLabelFor(mostRecentlyAddedLabel, component);
            this.clearMostRecentlyAddedLabel();
        }
        if (component instanceof JLabel) {
            this.setMostRecentlyAddedLabel((JLabel)component);
        }
        return result;
    }
    
    protected boolean isLabelForApplicable(final JLabel label, final Component component) {
        if (label.getLabelFor() != null) {
            return false;
        }
        if (!component.isFocusable()) {
            return false;
        }
        if (!(component instanceof JComponent)) {
            return true;
        }
        final JComponent c = (JComponent)component;
        return c.getClientProperty("labeledBy") == null;
    }
    
    protected void setLabelFor(final JLabel label, final Component component) {
        Component labeledComponent;
        if (component instanceof JScrollPane) {
            final JScrollPane scrollPane = (JScrollPane)component;
            labeledComponent = scrollPane.getViewport().getView();
        }
        else {
            labeledComponent = component;
        }
        label.setLabelFor(labeledComponent);
    }
    
    private JLabel getMostRecentlyAddedLabel() {
        if (this.mostRecentlyAddedLabelReference == null) {
            return null;
        }
        final JLabel label = (JLabel)this.mostRecentlyAddedLabelReference.get();
        if (label == null) {
            return null;
        }
        return label;
    }
    
    private void setMostRecentlyAddedLabel(final JLabel label) {
        this.mostRecentlyAddedLabelReference = new WeakReference(label);
    }
    
    private void clearMostRecentlyAddedLabel() {
        this.mostRecentlyAddedLabelReference = null;
    }
    
    static {
        PanelBuilder.labelForFeatureEnabledDefault = false;
    }
}
