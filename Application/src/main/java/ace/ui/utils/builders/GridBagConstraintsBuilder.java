package ace.ui.utils.builders;

import java.awt.*;

/**
 * Builder class for GridBagConstraints
 */
public class GridBagConstraintsBuilder {
    private final GridBagConstraints constraints;

    /**
     * Create a new GridBagConstraints
     */
    public GridBagConstraintsBuilder() {
        constraints = new GridBagConstraints();
    }

    /**
     * Sets grid height {@link GridBagConstraintsBuilder#constraints}
     * @param gridHeight sets constraint
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withGridHeight(int gridHeight) {
        constraints.gridheight = gridHeight;
        return this;
    }

    /**
     * Sets grid width {@link GridBagConstraintsBuilder#constraints}
     * @param gridWidth sets constraint
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withGridWidth(int gridWidth) {
        constraints.gridwidth = gridWidth;
        return this;
    }

    /**
     * Sets grid fill {@link GridBagConstraintsBuilder#constraints}
     * @param fill sets constraint
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withFill(int fill) {
        constraints.fill = fill;
        return this;
    }

    /**
     * Sets grid padding on all sides {@link GridBagConstraintsBuilder#constraints}
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withDefaultPadding() {
        constraints.insets = new Insets(10, 10, 10, 10);
        return this;
    }

    /**
     * Sets grid padding horizontally {@link GridBagConstraintsBuilder#constraints}
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withDefaultWidthPadding() {
        constraints.insets = new Insets(0, 10, 0, 10);
        return this;
    }

    /**
     * Sets grid padding vertically {@link GridBagConstraintsBuilder#constraints}
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withDefaultHeightPadding() {
        constraints.insets = new Insets(10, 0, 10, 0);
        return this;
    }

    /**
     * Sets grid weightx {@link GridBagConstraintsBuilder#constraints}
     * @param weightX sets constraint
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withWeightX(int weightX) {
        constraints.weightx = weightX;
        return this;
    }

    /**
     * Sets grid weightY {@link GridBagConstraintsBuilder#constraints}
     * @param weightY sets constraint
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withWeightY(int weightY) {
        constraints.weighty = weightY;
        return this;
    }

    /**
     * Sets grid weight {@link GridBagConstraintsBuilder#constraints}
     * @return builder for chaining
     */
    public GridBagConstraintsBuilder withFillOutWeight() {
        constraints.weightx = 1;
        constraints.weighty = 1;
        return this;
    }

    /**
     * @return the built GridBagConstraints
     */
    public GridBagConstraints build() {
        return constraints;
    }
}
