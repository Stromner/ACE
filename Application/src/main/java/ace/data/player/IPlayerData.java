package ace.data.player;

import ace.core.errors.IllegalPlayerDataException;

/**
 * Defines all the methods to get and modify a player character
 */
public interface IPlayerData {
    /**
     * @return player's name
     */
    String getPlayerName();

    /**
     * @param playerName sets player's name
     */
    void setPlayerName(String playerName);

    /**
     * @return get money
     */
    Integer getMoney();

    /**
     * @param money sets money
     * @throws IllegalPlayerDataException if money less than zero
     */
    void setMoney(Integer money) throws IllegalPlayerDataException;

    /**
     * @return player's level
     */
    Integer getPlayerLevel();

    /**
     * @param newLevel sets player's level
     * @throws IllegalPlayerDataException if outside the allowed bounds
     */
    void setPlayerLevel(Integer newLevel) throws IllegalPlayerDataException;

    /**
     * @return unspent skill points
     */
    Integer getUnspentSkillPoints();

    /**
     * @param skillPoints sets skill points
     * @throws IllegalPlayerDataException if skillPoints less than zero
     */
    void setUnspentSkillPoints(Integer skillPoints) throws IllegalPlayerDataException;
}
