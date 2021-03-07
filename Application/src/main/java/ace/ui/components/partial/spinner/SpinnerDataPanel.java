package ace.ui.components.partial.spinner;

import ace.ui.components.partial.ADataPanel;
import ace.ui.components.partial.text.field.TextFormattedDataPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

/**
 * Displays a {@link Label} and an implementation of {@link JSpinner}
 */
public class SpinnerDataPanel extends ADataPanel<Integer, JSpinner> {
    private static final Logger log = LoggerFactory.getLogger(SpinnerDataPanel.class);

    /**
     * @param name name to display on the {@link Label} in the super class
     * @param variableValue value to show in the {@link SpinnerDataPanel#variableValueContainer}
     * @param minValue the first number in the sequence
     * @param stepSize the difference between elements of the sequence
     */
    public SpinnerDataPanel(String name, Integer variableValue, int minValue, int stepSize) {
        super(name);

        this.variableValueContainer = new JSpinner(
                new SpinnerNumberModel(variableValue.intValue(), minValue, Integer.MAX_VALUE, stepSize));
        ((JSpinner.DefaultEditor) this.variableValueContainer.getEditor()).getTextField().setEditable(false);
        add(this.variableValueContainer);
    }

    /**
     * Listener for updating the data layer upon changes
     * @param instance clazz used by reflection
     * @param method   invoked by reflection
     */
    public void createListener(Object instance, Method method) {
        variableValueContainer.addChangeListener(e -> {
            log.debug("Setting value {} for method {}", variableValueContainer.getValue(), method.getName());
            executeMethod(instance, method, variableValueContainer.getValue());
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(variableValueContainer);
            updateAllVariableRows(frame.getContentPane());
        });
    }

    @Override
    protected void setData(Integer value) {
        variableValueContainer.setValue(value);
    }
}
