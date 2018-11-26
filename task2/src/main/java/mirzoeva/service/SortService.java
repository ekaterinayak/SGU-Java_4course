package mirzoeva.service;

import mirzoeva.sorter.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mirzoeva
 */
@Service
public class SortService {

    private final Sorter<Integer> sorter;

    @Autowired
    public SortService(@Qualifier("bubbleSort") Sorter<Integer> sorter) {
        this.sorter = sorter;
    }

    public List<Integer> sort(List<Integer> array) {
        return sorter.sort(array);
    }
}
