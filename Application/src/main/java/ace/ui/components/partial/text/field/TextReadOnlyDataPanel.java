package ace.ui.components.partial.text.field;

import javax.swing.*;
import java.awt.*;

/**
 * Displays a {@link Label} and a {@link JTextField} which disables editing the field
 * @param <T> type of stored data
 */
public class TextReadOnlyDataPanel<T> extends ATextField<T, JTextField> {
    /**
     * @param name name to display on the {@link Label} in the super class
     * @param variableValue value to show in the {@link TextFormattedDataPanel#variableValueContainer}
     */
    public TextReadOnlyDataPanel(String name, T variableValue) {
        super(name);

        this.variableValueContainer = new JTextField();
        if (variableValue instanceof String) {
            this.variableValueContainer.setText((String) variableValue);
        } else {
            this.variableValueContainer.setText(String.valueOf(variableValue));
        }
        this.variableValueContainer.setEditable(false);

        add(this.variableValueContainer);
    }
}
