// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.factories;

import javax.swing.JComponent;
import javax.swing.JLabel;

public interface ComponentFactory
{
    JLabel createLabel(final String p0);
    
    JLabel createTitle(final String p0);
    
    JComponent createSeparator(final String p0, final int p1);
}
