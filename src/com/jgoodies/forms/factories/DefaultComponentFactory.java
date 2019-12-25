// 
// Decompiled by Procyon v0.5.36
// 

package com.jgoodies.forms.factories;

import java.awt.FontMetrics;
import com.jgoodies.forms.layout.Sizes;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import javax.accessibility.AccessibleContext;
import java.awt.Component;
import java.awt.LayoutManager;
import javax.swing.JPanel;
import com.jgoodies.forms.util.FormUtils;
import javax.swing.JSeparator;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class DefaultComponentFactory implements ComponentFactory2
{
    private static final DefaultComponentFactory INSTANCE;
    private static final char MNEMONIC_MARKER = '&';
    
    public static DefaultComponentFactory getInstance() {
        return DefaultComponentFactory.INSTANCE;
    }
    
    public JLabel createLabel(final String textWithMnemonic) {
        final JLabel label = new FormsLabel();
        setTextAndMnemonic(label, textWithMnemonic);
        return label;
    }
    
    public JLabel createReadOnlyLabel(final String textWithMnemonic) {
        final JLabel label = new ReadOnlyLabel();
        setTextAndMnemonic(label, textWithMnemonic);
        return label;
    }
    
    public JLabel createTitle(final String textWithMnemonic) {
        final JLabel label = new TitleLabel();
        setTextAndMnemonic(label, textWithMnemonic);
        label.setVerticalAlignment(0);
        return label;
    }
    
    public JComponent createSeparator(final String textWithMnemonic) {
        return this.createSeparator(textWithMnemonic, 2);
    }
    
    public JComponent createSeparator(final String textWithMnemonic, final int alignment) {
        if (textWithMnemonic == null || textWithMnemonic.length() == 0) {
            return new JSeparator();
        }
        final JLabel title = this.createTitle(textWithMnemonic);
        title.setHorizontalAlignment(alignment);
        return this.createSeparator(title);
    }
    
    public JComponent createSeparator(final JLabel label) {
        if (label == null) {
            throw new NullPointerException("The label must not be null.");
        }
        final int horizontalAlignment = label.getHorizontalAlignment();
        if (horizontalAlignment != 2 && horizontalAlignment != 0 && horizontalAlignment != 4) {
            throw new IllegalArgumentException("The label's horizontal alignment must be one of: LEFT, CENTER, RIGHT.");
        }
        final JPanel panel = new JPanel(new TitledSeparatorLayout(!FormUtils.isLafAqua()));
        panel.setOpaque(false);
        panel.add(label);
        panel.add(new JSeparator());
        if (horizontalAlignment == 0) {
            panel.add(new JSeparator());
        }
        return panel;
    }
    
    public static void setTextAndMnemonic(final JLabel label, final String textWithMnemonic) {
        int markerIndex = textWithMnemonic.indexOf(38);
        if (markerIndex == -1) {
            label.setText(textWithMnemonic);
            return;
        }
        int mnemonicIndex = -1;
        int begin = 0;
        final int length = textWithMnemonic.length();
        int quotedMarkers = 0;
        final StringBuffer buffer = new StringBuffer();
        do {
            int end;
            if (markerIndex + 1 < length && textWithMnemonic.charAt(markerIndex + 1) == '&') {
                end = markerIndex + 1;
                ++quotedMarkers;
            }
            else {
                end = markerIndex;
                if (mnemonicIndex == -1) {
                    mnemonicIndex = markerIndex - quotedMarkers;
                }
            }
            buffer.append(textWithMnemonic.substring(begin, end));
            begin = end + 1;
            markerIndex = ((begin < length) ? textWithMnemonic.indexOf(38, begin) : -1);
        } while (markerIndex != -1);
        buffer.append(textWithMnemonic.substring(begin));
        final String text = buffer.toString();
        label.setText(text);
        if (mnemonicIndex != -1 && mnemonicIndex < text.length()) {
            label.setDisplayedMnemonic(text.charAt(mnemonicIndex));
            label.setDisplayedMnemonicIndex(mnemonicIndex);
        }
    }
    
    static {
        INSTANCE = new DefaultComponentFactory();
    }
    
    private static class FormsLabel extends JLabel
    {
        public AccessibleContext getAccessibleContext() {
            if (this.accessibleContext == null) {
                this.accessibleContext = new AccessibleFormsLabel();
            }
            return this.accessibleContext;
        }
        
        private final class AccessibleFormsLabel extends AccessibleJLabel
        {
            public String getAccessibleName() {
                if (this.accessibleName != null) {
                    return this.accessibleName;
                }
                final String text = FormsLabel.this.getText();
                if (text == null) {
                    return super.getAccessibleName();
                }
                return text.endsWith(":") ? text.substring(0, text.length() - 1) : text;
            }
        }
    }
    
    private static final class ReadOnlyLabel extends FormsLabel
    {
        private static final String[] UIMANAGER_KEYS;
        
        public void updateUI() {
            super.updateUI();
            this.setForeground(this.getDisabledForeground());
        }
        
        private Color getDisabledForeground() {
            for (int i = 0; i < ReadOnlyLabel.UIMANAGER_KEYS.length; ++i) {
                final String key = ReadOnlyLabel.UIMANAGER_KEYS[i];
                final Color foreground = UIManager.getColor(key);
                if (foreground != null) {
                    return foreground;
                }
            }
            return null;
        }
        
        static {
            UIMANAGER_KEYS = new String[] { "Label.disabledForeground", "Label.disabledText", "Label[Disabled].textForeground", "textInactiveText" };
        }
    }
    
    private static final class TitleLabel extends FormsLabel
    {
        public void updateUI() {
            super.updateUI();
            final Color foreground = this.getTitleColor();
            if (foreground != null) {
                this.setForeground(foreground);
            }
            this.setFont(this.getTitleFont());
        }
        
        private Color getTitleColor() {
            return UIManager.getColor("TitledBorder.titleColor");
        }
        
        private Font getTitleFont() {
            return FormUtils.isLafAqua() ? UIManager.getFont("Label.font").deriveFont(1) : UIManager.getFont("TitledBorder.font");
        }
    }
    
    private static final class TitledSeparatorLayout implements LayoutManager
    {
        private final boolean centerSeparators;
        
        private TitledSeparatorLayout(final boolean centerSeparators) {
            this.centerSeparators = centerSeparators;
        }
        
        public void addLayoutComponent(final String name, final Component comp) {
        }
        
        public void removeLayoutComponent(final Component comp) {
        }
        
        public Dimension minimumLayoutSize(final Container parent) {
            return this.preferredLayoutSize(parent);
        }
        
        public Dimension preferredLayoutSize(final Container parent) {
            final Component label = this.getLabel(parent);
            final Dimension labelSize = label.getPreferredSize();
            final Insets insets = parent.getInsets();
            final int width = labelSize.width + insets.left + insets.right;
            final int height = labelSize.height + insets.top + insets.bottom;
            return new Dimension(width, height);
        }
        
        public void layoutContainer(final Container parent) {
            synchronized (parent.getTreeLock()) {
                final Dimension size = parent.getSize();
                final Insets insets = parent.getInsets();
                final int width = size.width - insets.left - insets.right;
                final JLabel label = this.getLabel(parent);
                final Dimension labelSize = label.getPreferredSize();
                final int labelWidth = labelSize.width;
                final int labelHeight = labelSize.height;
                final Component separator1 = parent.getComponent(1);
                final int separatorHeight = separator1.getPreferredSize().height;
                final FontMetrics metrics = label.getFontMetrics(label.getFont());
                final int ascent = metrics.getMaxAscent();
                final int hGapDlu = this.centerSeparators ? 3 : 1;
                final int hGap = Sizes.dialogUnitXAsPixel(hGapDlu, label);
                final int vOffset = this.centerSeparators ? (1 + (labelHeight - separatorHeight) / 2) : (ascent - separatorHeight / 2);
                final int alignment = label.getHorizontalAlignment();
                final int y = insets.top;
                if (alignment == 2) {
                    int x = insets.left;
                    label.setBounds(x, y, labelWidth, labelHeight);
                    x += labelWidth;
                    x += hGap;
                    final int separatorWidth = size.width - insets.right - x;
                    separator1.setBounds(x, y + vOffset, separatorWidth, separatorHeight);
                }
                else if (alignment == 4) {
                    int x = insets.left + width - labelWidth;
                    label.setBounds(x, y, labelWidth, labelHeight);
                    x -= hGap;
                    final int separatorWidth = --x - insets.left;
                    separator1.setBounds(insets.left, y + vOffset, separatorWidth, separatorHeight);
                }
                else {
                    final int xOffset = (width - labelWidth - 2 * hGap) / 2;
                    int x2 = insets.left;
                    separator1.setBounds(x2, y + vOffset, xOffset - 1, separatorHeight);
                    x2 += xOffset;
                    x2 += hGap;
                    label.setBounds(x2, y, labelWidth, labelHeight);
                    x2 += labelWidth;
                    x2 += hGap;
                    final Component separator2 = parent.getComponent(2);
                    final int separatorWidth2 = size.width - insets.right - x2;
                    separator2.setBounds(x2, y + vOffset, separatorWidth2, separatorHeight);
                }
            }
        }
        
        private JLabel getLabel(final Container parent) {
            return (JLabel)parent.getComponent(0);
        }
    }
}
