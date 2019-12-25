// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.layout;

import java.util.HashMap;
import java.util.Locale;
import com.jgoodies.forms.util.FormUtils;
import java.util.Map;

public final class ColumnSpec extends FormSpec
{
    public static final DefaultAlignment LEFT;
    public static final DefaultAlignment CENTER;
    public static final DefaultAlignment MIDDLE;
    public static final DefaultAlignment RIGHT;
    public static final DefaultAlignment FILL;
    public static final DefaultAlignment DEFAULT;
    private static final Map CACHE;
    
    public ColumnSpec(final DefaultAlignment defaultAlignment, final Size size, final double resizeWeight) {
        super(defaultAlignment, size, resizeWeight);
    }
    
    public ColumnSpec(final Size size) {
        super(ColumnSpec.DEFAULT, size, 0.0);
    }
    
    public ColumnSpec(final String encodedDescription) {
        super(ColumnSpec.DEFAULT, encodedDescription);
    }
    
    public static ColumnSpec createGap(final ConstantSize gapWidth) {
        return new ColumnSpec(ColumnSpec.DEFAULT, gapWidth, 0.0);
    }
    
    public static ColumnSpec decode(final String encodedColumnSpec) {
        return decode(encodedColumnSpec, LayoutMap.getRoot());
    }
    
    public static ColumnSpec decode(final String encodedColumnSpec, final LayoutMap layoutMap) {
        FormUtils.assertNotBlank(encodedColumnSpec, "encoded column specification");
        FormUtils.assertNotNull(layoutMap, "LayoutMap");
        final String trimmed = encodedColumnSpec.trim();
        final String lower = trimmed.toLowerCase(Locale.ENGLISH);
        return decodeExpanded(layoutMap.expand(lower, true));
    }
    
    static ColumnSpec decodeExpanded(final String expandedTrimmedLowerCaseSpec) {
        ColumnSpec spec = (ColumnSpec) ColumnSpec.CACHE.get(expandedTrimmedLowerCaseSpec);
        if (spec == null) {
            spec = new ColumnSpec(expandedTrimmedLowerCaseSpec);
            ColumnSpec.CACHE.put(expandedTrimmedLowerCaseSpec, spec);
        }
        return spec;
    }
    
    public static ColumnSpec[] decodeSpecs(final String encodedColumnSpecs) {
        return decodeSpecs(encodedColumnSpecs, LayoutMap.getRoot());
    }
    
    public static ColumnSpec[] decodeSpecs(final String encodedColumnSpecs, final LayoutMap layoutMap) {
        return FormSpecParser.parseColumnSpecs(encodedColumnSpecs, layoutMap);
    }
    
    protected boolean isHorizontal() {
        return true;
    }
    
    static {
        LEFT = FormSpec.LEFT_ALIGN;
        CENTER = FormSpec.CENTER_ALIGN;
        MIDDLE = ColumnSpec.CENTER;
        RIGHT = FormSpec.RIGHT_ALIGN;
        FILL = FormSpec.FILL_ALIGN;
        DEFAULT = ColumnSpec.FILL;
        CACHE = new HashMap();
    }
}
