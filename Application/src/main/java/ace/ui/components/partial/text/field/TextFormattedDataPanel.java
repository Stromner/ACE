package ace.ui.components.partial.text.field;

import ace.ui.utils.FormatCreator;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.lang.reflect.Method;

/**
 * Displays a {@link Label} and an implementation of {@link JFormattedTextField}
 * @param <T> type of stored data
 */
public class TextFormattedDataPanel<T> extends ATextField<T, JFormattedTextField> {
    private static final Logger log = LoggerFactory.getLogger(TextFormattedDataPanel.class);

    /**
     * @param name name to display on the {@link Label} in the super class
     * @param variableValue value to show in the {@link TextFormattedDataPanel#variableValueContainer}
     */
    public TextFormattedDataPanel(String name, T variableValue) {
        super(name);

        this.variableValueContainer = new JFormattedTextField(FormatCreator.buildFormatter(variableValue));
        this.variableValueContainer.setValue(variableValue);

        add(this.variableValueContainer);
    }

    /**
     * Listener for updating the data layer upon losing focus
     * @param instance clazz used by reflection
     * @param method   invoked by reflection
     */
    public void createListener(Object instance, Method method) {
        variableValueContainer.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                log.debug("Setting value {} for method {}", variableValueContainer.getText(), method.getName());
                if (NumberUtils.isCreatable(variableValueContainer.getText())) {
                    executeMethod(instance, method, Integer.parseInt(variableValueContainer.getText()));
                } else {
                    executeMethod(instance, method, variableValueContainer.getText());
                }
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(variableValueContainer);
                updateAllVariableRows(frame.getContentPane());
            }
        });
    }
}
