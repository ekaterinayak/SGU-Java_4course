package mirzoeva.sorter;

import java.util.List;

/**
 * @author mirzoeva
 */
public interface Sorter<T extends Comparable> {
    List<T> sort(List<T> arrayToSort);
}
