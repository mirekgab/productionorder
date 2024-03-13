package pl.mirekgab.productionorder.order;

import java.util.Comparator;

public class OutputResourceComparator implements Comparator<OutputResource> {

    @Override
    public int compare(OutputResource o1, OutputResource o2) {
        return o1.getProduct().getName().compareTo(o2.getProduct().getName());
    }
}
