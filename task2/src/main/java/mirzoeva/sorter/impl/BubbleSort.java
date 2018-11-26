package mirzoeva.sorter.impl;

import mirzoeva.sorter.Sorter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mirzoeva
 */
@Component
public class BubbleSort<T extends Comparable> implements Sorter<T> {

    @Override
    public List<T> sort(List<T> arrayToSort) {
        List<T> sortedArray = new ArrayList<>(arrayToSort);
        int n = sortedArray.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sortedArray.get(j).compareTo(sortedArray.get(j + 1)) > 0) {
                    // swap temp and arr[i]
                    T temp = sortedArray.get(j);
                    sortedArray.set(j, sortedArray.get(j + 1));
                    sortedArray.set(j + 1, temp);
                }
            }
        }
        return sortedArray;
    }
}
