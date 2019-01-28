package util;

import entity.Passenger;

import java.util.Comparator;

public class ComparatorPassengerByName implements Comparator<Passenger> {
    @Override
    public int compare(Passenger o1, Passenger o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name1.compareTo(name2);
    }
}
