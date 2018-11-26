package mirzoeva.sorter.impl;

import mirzoeva.sorter.Sorter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mirzoeva
 */
@Component
public class SelectSort<T extends Comparable> implements Sorter<T> {

    @Override
    public List<T> sort(List<T> arrayToSort) {
        List<T> sortedArray = new ArrayList<>(arrayToSort);
        for (int i = 0; i < sortedArray.size(); i++) {
            T min = sortedArray.get(i);
            int minIndex = i;
            for (int j = i + 1; j < sortedArray.size(); j++) {
                //Если находим, запоминаем его индекс
                if (sortedArray.get(j).compareTo(min) < 0) {
                    min = sortedArray.get(j);
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                T tmp = sortedArray.get(i);
                sortedArray.set(i, sortedArray.get(minIndex));
                sortedArray.set(minIndex, tmp);
            }
        }

        return sortedArray;
    }
}