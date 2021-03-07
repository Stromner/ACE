package ace.ui.components.partial.text.field;

import ace.ui.components.partial.ADataPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Base class for displaying a {@link Label} and a {@link JTextField} with a stored value inside. Takes two generics:
 *
 * @param <T> type of stored data
 * @param <V> swing object that extends {@link JTextField}
 */
public abstract class ATextField<T, V extends JTextField> extends ADataPanel<T, V> {
    /**
     * @param name name to display on the {@link Label} in the super class
     */
    public ATextField(String name) {
        super(name);
    }

    @Override
    protected void setData(T value) {
        if (value instanceof Integer) {
            variableValueContainer.setText(String.valueOf(value));
        } else {
            variableValueContainer.setText((String) value);
        }
    }
}
