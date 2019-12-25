// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import javax.swing.JComponent;
import java.awt.Component;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.CellConstraints;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;

public abstract class AbstractI15dPanelBuilder extends PanelBuilder
{
    private static final String DEBUG_TOOL_TIPS_ENABLED_KEY = "I15dPanelBuilder.debugToolTipsEnabled";
    private static boolean debugToolTipsEnabled;
    
    protected AbstractI15dPanelBuilder(final FormLayout layout) {
        super(layout);
    }
    
    protected AbstractI15dPanelBuilder(final FormLayout layout, final JPanel panel) {
        super(layout, panel);
    }
    
    private static boolean getDebugToolTipSystemProperty() {
        try {
            final String value = System.getProperty("I15dPanelBuilder.debugToolTipsEnabled");
            return "true".equalsIgnoreCase(value);
        }
        catch (SecurityException e) {
            return false;
        }
    }
    
    public static boolean isDebugToolTipsEnabled() {
        return AbstractI15dPanelBuilder.debugToolTipsEnabled;
    }
    
    public static void setDebugToolTipsEnabled(final boolean b) {
        AbstractI15dPanelBuilder.debugToolTipsEnabled = b;
    }
    
    public final JLabel addI15dLabel(final String resourceKey, final CellConstraints constraints) {
        final JLabel label = this.addLabel(this.getI15dString(resourceKey), constraints);
        if (isDebugToolTipsEnabled()) {
            label.setToolTipText(resourceKey);
        }
        return label;
    }
    
    public final JLabel addI15dLabel(final String resourceKey, final String encodedConstraints) {
        return this.addI15dLabel(resourceKey, new CellConstraints(encodedConstraints));
    }
    
    public final JLabel addI15dLabel(final String resourceKey, final CellConstraints labelConstraints, final Component component, final CellConstraints componentConstraints) {
        final JLabel label = this.addLabel(this.getI15dString(resourceKey), labelConstraints, component, componentConstraints);
        if (isDebugToolTipsEnabled()) {
            label.setToolTipText(resourceKey);
        }
        return label;
    }
    
    public final JLabel addI15dROLabel(final String resourceKey, final CellConstraints constraints) {
        final JLabel label = this.addROLabel(this.getI15dString(resourceKey), constraints);
        if (isDebugToolTipsEnabled()) {
            label.setToolTipText(resourceKey);
        }
        return label;
    }
    
    public final JLabel addI15dROLabel(final String resourceKey, final String encodedConstraints) {
        return this.addI15dROLabel(resourceKey, new CellConstraints(encodedConstraints));
    }
    
    public final JLabel addI15dROLabel(final String resourceKey, final CellConstraints labelConstraints, final Component component, final CellConstraints componentConstraints) {
        final JLabel label = this.addROLabel(this.getI15dString(resourceKey), labelConstraints, component, componentConstraints);
        if (isDebugToolTipsEnabled()) {
            label.setToolTipText(resourceKey);
        }
        return label;
    }
    
    public final JComponent addI15dSeparator(final String resourceKey, final CellConstraints constraints) {
        final JComponent component = this.addSeparator(this.getI15dString(resourceKey), constraints);
        if (isDebugToolTipsEnabled()) {
            component.setToolTipText(resourceKey);
        }
        return component;
    }
    
    public final JComponent addI15dSeparator(final String resourceKey, final String encodedConstraints) {
        return this.addI15dSeparator(resourceKey, new CellConstraints(encodedConstraints));
    }
    
    public final JLabel addI15dTitle(final String resourceKey, final CellConstraints constraints) {
        final JLabel label = this.addTitle(this.getI15dString(resourceKey), constraints);
        if (isDebugToolTipsEnabled()) {
            label.setToolTipText(resourceKey);
        }
        return label;
    }
    
    public final JLabel addI15dTitle(final String resourceKey, final String encodedConstraints) {
        return this.addI15dTitle(resourceKey, new CellConstraints(encodedConstraints));
    }
    
    protected abstract String getI15dString(final String p0);
    
    static {
        AbstractI15dPanelBuilder.debugToolTipsEnabled = getDebugToolTipSystemProperty();
    }
}
