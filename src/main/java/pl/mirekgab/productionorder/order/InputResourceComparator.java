package pl.mirekgab.productionorder.order;

import java.util.Comparator;

public class InputResourceComparator implements Comparator<InputResource> {

    @Override
    public int compare(InputResource o1, InputResource o2) {
        return o1.getMaterial().getName().compareTo(o2.getMaterial().getName());
    }
}
