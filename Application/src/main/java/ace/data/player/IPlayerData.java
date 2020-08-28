package ace.data.player;

import ace.core.errors.IllegalPlayerDataException;

/**
 * Defines all the methods to get and modify a player character
 */
public interface IPlayerData {
    String getPlayerName();

    void setPlayerName(String playerName);

    Integer getMoney();

    void setMoney(Integer money) throws IllegalPlayerDataException;

    Integer getPlayerLevel();

    void setPlayerLevel(Integer newLevel) throws IllegalPlayerDataException;

    Integer getUnspentSkillPoints();

    void setUnspentSkillPoints(Integer skillPoints) throws IllegalPlayerDataException;
}
