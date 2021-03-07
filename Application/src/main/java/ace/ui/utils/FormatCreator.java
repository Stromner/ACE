package ace.ui.utils;

import javax.swing.*;
import javax.swing.text.DefaultFormatter;
import javax.swing.text.NumberFormatter;
import java.text.Format;
import java.text.NumberFormat;

/**
 * {@link Format} applicator
 */
public class FormatCreator {
    /**
     * Builds formatter depending on the parameter instance
     * @param value Parameter type
     * @param <T> Parameter type
     * @return built formatter
     */
    public static <T> JFormattedTextField.AbstractFormatter buildFormatter(T value) {
        if (value instanceof Integer) {
            NumberFormat format = NumberFormat.getInstance();
            format.setGroupingUsed(false);
            NumberFormatter formatter = new NumberFormatter(format);
            formatter.setMinimum(0);
            formatter.setMaximum(Integer.MAX_VALUE);
            formatter.setAllowsInvalid(false);
            formatter.setOverwriteMode(false);

            return formatter;
        } else if (value instanceof String) {
            DefaultFormatter formatter = new DefaultFormatter();
            formatter.setOverwriteMode(false);
            return formatter;
        } else {
            throw new RuntimeException("Unsupported data type for field");
        }
    }
}
