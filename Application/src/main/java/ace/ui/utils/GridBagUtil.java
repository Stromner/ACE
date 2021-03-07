package ace.ui.utils;

import javax.swing.*;
import java.awt.*;

/**
 * Utils class for applying {@link GridBagConstraints} to all {@link Container}
 */
public class GridBagUtil {
    /**
     * Sets title on a panel
     * @param parentContainer panel to set the title for
     * @param text title string
     * @param gridX x location
     * @param gridY y location
     */
    public static void addTitle
            (JComponent parentContainer, String text, int gridX, int gridY) {
        JLabel title = new JLabel(text);
        title.setFont(new Font("Ariel Heavy", Font.BOLD, 22));
        addComponentWithConstraints(parentContainer, title, gridX, gridY, null);
    }

    /**
     * @param parentContainer to add to
     * @param component to be added
     * @param gridX x location
     * @param gridY y location
     */
    public static void addComponent(JComponent parentContainer, JComponent component, int gridX, int gridY) {
        addComponentWithConstraints(parentContainer, component, gridX, gridY, null);
    }

    /**
     *
     * @param parentContainer to add to
     * @param component to be added
     * @param gridX x location
     * @param gridY y location
     * @param additionalConstraints extra constraints
     */
    public static void addComponentWithConstraints
            (JComponent parentContainer, JComponent component, int gridX, int gridY, GridBagConstraints additionalConstraints) {
        if (additionalConstraints == null) {
            additionalConstraints = new GridBagConstraints();
        }
        additionalConstraints.gridx = gridX;
        additionalConstraints.gridy = gridY;

        parentContainer.add(component, additionalConstraints);
    }
}
