package ace.data.player.attributes;

import ace.core.errors.IllegalPlayerDataException;

/**
 * Defines all the methods to get and modify for setting and getting attributes
 */
public interface IAttributesData {
    /**
     * @return helper method for interface to calculate step size
     */
    Integer getCharacteristicGain();

    /**
     * @return helper method for interface to calculate step size
     */
    Integer getFluidGain();

    /**
     * @return unspent attribute points
     */
    Integer getUnspentAttributePoints();

    /**
     * @param attributePoints set unspent attribute points
     * @throws IllegalPlayerDataException if attributePoints less than zero
     */
    void setUnspentAttributePoints(Integer attributePoints) throws IllegalPlayerDataException;

    /**
     * Unassigns all spent attribute points
     */
    void resetAllAttributes();

    /**
     * @return spent strength attribute points
     */
    Integer getStrengthAttribute();

    /**
     * @param attributePoints sets strength attribute points
     * @throws IllegalPlayerDataException if attributePoints less than minimal allowed
     */
    void setStrengthAttribute(Integer attributePoints) throws IllegalPlayerDataException;

    /**
     * @return spent dexterity attribute points
     */
    Integer getDexterityAttribute();

    /**
     * @param attributePoints sets dexterity attribute points
     * @throws IllegalPlayerDataException if attributePoints less than minimal allowed
     */
    void setDexterityAttribute(Integer attributePoints) throws IllegalPlayerDataException;

    /**
     * @return spent intelligence attribute points
     */
    Integer getIntelligenceAttribute();

    /**
     * @param attributePoints sets intelligence attribute points
     * @throws IllegalPlayerDataException if attributePoints less than minimal allowed
     */
    void setIntelligenceAttribute(Integer attributePoints) throws IllegalPlayerDataException;

    /**
     * @return spent health attribute points
     */
    Integer getHealthAttribute();

    /**
     * @param attributePoints sets health attribute points
     * @throws IllegalPlayerDataException if attributePoints less than minimal allowed
     */
    void setHealthAttribute(Integer attributePoints) throws IllegalPlayerDataException;

    /**
     * @return spent mana attribute points
     */
    Integer getManaAttribute();

    /**
     * @param attributePoints sets mana attribute points
     * @throws IllegalPlayerDataException if attributePoints less than minimal allowed
     */
    void setManaAttribute(Integer attributePoints) throws IllegalPlayerDataException;
}
