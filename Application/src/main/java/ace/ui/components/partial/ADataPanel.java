package ace.ui.components.partial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Method;

/**
 * Base class for displaying a {@link Label} and a {@link JComponent} with a stored value inside. Takes two generics:
 *
 * @param <T> type of stored data
 * @param <V> swing object that extends {@link JComponent}
 */
public abstract class ADataPanel<T, V extends JComponent> extends JPanel {
    /**
     * {@link JComponent} that stores the variableValue
     */
    protected V variableValueContainer;
    private static final Logger log = LoggerFactory.getLogger(ADataPanel.class);
    private final Label variableName;
    private Object instance;
    private Method method;

    /**
     * @param name name to display on the {@link ADataPanel#variableName}
     */
    public ADataPanel(String name) {
        super();
        setLayout(new GridLayout(1, 0));

        this.variableName = new Label(name);

        add(this.variableName);
    }

    /**
     * Reflection method to connect interface with data layer
     *
     * @param instance clazz used by reflection
     * @param method   invoked by reflection
     */
    public void setDataGetter(Object instance, Method method) {
        this.instance = instance;
        this.method = method;
    }

    /**
     * Fetches data from the data layer
     */
    public void reloadData() {
        log.debug("Getting value from method {}", method.getName());
        T fetchedValue = (T) executeMethod(instance, method, null);
        setData(fetchedValue);
    }

    /**
     * Method invoked by listeners in children
     *
     * @param instance clazz used by reflection
     * @param method   invoked by reflection
     * @param args     additional argument
     * @return the return type of the invoked method, old value if invocation fails
     */
    protected Object executeMethod(Object instance, Method method, Object args) {
        try {
            if (args == null) {
                return method.invoke(instance);
            } else {
                return method.invoke(instance, args);
            }
        } catch (Exception e) {
            exceptionHandling(e);
            return null;
        }
    }

    /**
     * @param value sets {@link ADataPanel#variableValueContainer}
     */
    protected abstract void setData(T value);

    /**
     * Method invoked by listeners for updating all {@link Container} with new data
     *
     * @param c {@link Container} to update
     */
    protected void updateAllVariableRows(Container c) {
        for (Component comp : c.getComponents()) {
            if (comp instanceof ADataPanel) {
                ((ADataPanel<?, ?>) comp).reloadData();
            } else if (comp instanceof Container) {
                updateAllVariableRows((Container) comp);
            }
        }
    }

    private void exceptionHandling(Exception e) {
        String errorMessage;
        if (e.getCause() != null) {
            errorMessage = e.getCause().getMessage();
        } else {
            errorMessage = e.toString();
        }

        JOptionPane.showMessageDialog(this, errorMessage, "Invalid Data", JOptionPane.ERROR_MESSAGE);
    }
}
