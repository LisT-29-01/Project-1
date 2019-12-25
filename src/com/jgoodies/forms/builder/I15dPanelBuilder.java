// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.builder;

import java.util.MissingResourceException;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import java.util.ResourceBundle;

public class I15dPanelBuilder extends AbstractI15dPanelBuilder
{
    private final ResourceBundle bundle;
    
    public I15dPanelBuilder(final FormLayout layout, final ResourceBundle bundle) {
        this(layout, bundle, new JPanel(null));
    }
    
    public I15dPanelBuilder(final FormLayout layout, final ResourceBundle bundle, final JPanel panel) {
        super(layout, panel);
        this.bundle = bundle;
    }
    
    protected String getI15dString(final String resourceKey) {
        if (this.bundle == null) {
            throw new IllegalStateException("You must specify a ResourceBundle before using the internationalization support.");
        }
        try {
            return this.bundle.getString(resourceKey);
        }
        catch (MissingResourceException mre) {
            return resourceKey;
        }
    }
}
