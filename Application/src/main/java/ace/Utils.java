package ace;

import ace.database.entities.content.DataContent;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Utils
 */
public class Utils {
    /**
     * @param list to be searched
     * @param nrElements of elements in a row to be found
     * @param <T> type of data for the elements
     * @return list of first sequence of nrElements with the given data type
     */
    public static <T extends DataContent<?>> List<T> listFindSequence(List<T> list, int nrElements) {
        long lastId = -1;
        int sequence = 0;
        for (int i = 0; i < list.size(); i++) {
            if (++lastId != list.get(i).getId()) {
                sequence = 1;
                lastId = list.get(i).getId();
            } else {
                sequence++;
            }

            if (sequence == nrElements) {
                return list.subList(i - nrElements + 1, i + 1);
            }
        }
        throw new NoSuchElementException("Could not find a sequence of '" + nrElements + "' in the given list");
    }
}
