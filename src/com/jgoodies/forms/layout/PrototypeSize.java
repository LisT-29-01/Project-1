// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.layout;

import java.awt.FontMetrics;
import java.awt.Font;
import com.jgoodies.forms.util.DefaultUnitConverter;
import java.util.List;
import java.awt.Container;
import java.io.Serializable;

public final class PrototypeSize implements Size, Serializable
{
    private final String prototype;
    
    public PrototypeSize(final String prototype) {
        this.prototype = prototype;
    }
    
    public String getPrototype() {
        return this.prototype;
    }
    
    public int maximumSize(final Container container, final List components, final FormLayout.Measure minMeasure, final FormLayout.Measure prefMeasure, final FormLayout.Measure defaultMeasure) {
        final Font font = DefaultUnitConverter.getInstance().getDefaultDialogFont();
        final FontMetrics fm = container.getFontMetrics(font);
        return fm.stringWidth(this.getPrototype());
    }
    
    public boolean compressible() {
        return false;
    }
    
    public String encode() {
        return "'" + this.prototype + "'";
    }
    
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PrototypeSize)) {
            return false;
        }
        final PrototypeSize size = (PrototypeSize)o;
        return this.prototype.equals(size.prototype);
    }
    
    public int hashCode() {
        return this.prototype.hashCode();
    }
    
    public String toString() {
        return this.encode();
    }
}
