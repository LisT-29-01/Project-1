// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.util;

import javax.swing.UIManager;
import javax.swing.LookAndFeel;

public final class FormUtils
{
    private static LookAndFeel cachedLookAndFeel;
    private static Boolean cachedIsLafAqua;
    
    private FormUtils() {
    }
    
    public static void assertNotBlank(final String text, final String description) {
        if (text == null) {
            throw new NullPointerException("The " + description + " must not be null.");
        }
        if (isBlank(text)) {
            throw new IllegalArgumentException("The " + description + " must not be empty, or whitespace. " + "See FormUtils.isBlank(String)");
        }
    }
    
    public static void assertNotNull(final Object object, final String description) {
        if (object == null) {
            throw new NullPointerException("The " + description + " must not be null.");
        }
    }
    
    public static boolean equals(final Object o1, final Object o2) {
        return (o1 != null && o2 != null && o1.equals(o2)) || (o1 == null && o2 == null);
    }
    
    public static boolean isBlank(final String str) {
        final int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }
        for (int i = length - 1; i >= 0; --i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNotBlank(final String str) {
        final int length;
        if (str == null || (length = str.length()) == 0) {
            return false;
        }
        for (int i = length - 1; i >= 0; --i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }
    
    public static boolean isLafAqua() {
        ensureValidCache();
        if (FormUtils.cachedIsLafAqua == null) {
            FormUtils.cachedIsLafAqua = computeIsLafAqua();
        }
        return FormUtils.cachedIsLafAqua;
    }
    
    public static void clearLookAndFeelBasedCaches() {
        FormUtils.cachedIsLafAqua = null;
        DefaultUnitConverter.getInstance().clearCache();
    }
    
    private static boolean computeIsLafAqua() {
        return UIManager.getLookAndFeel().getID().equals("Aqua");
    }
    
    static void ensureValidCache() {
        final LookAndFeel currentLookAndFeel = UIManager.getLookAndFeel();
        if (currentLookAndFeel != FormUtils.cachedLookAndFeel) {
            clearLookAndFeelBasedCaches();
            FormUtils.cachedLookAndFeel = currentLookAndFeel;
        }
    }
}
