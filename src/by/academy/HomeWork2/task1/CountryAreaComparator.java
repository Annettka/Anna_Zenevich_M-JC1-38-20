package by.academy.HomeWork2.task1;

import java.util.Comparator;

public class CountryAreaComparator implements Comparator<Country> {

    @Override
    public int compare(Country o1, Country o2) {
        if (o1.getArea() < o2.getArea()) {
            return -1;
        } else if (o1.getArea() > o2.getArea()) {
            return 1;
        } else
            return 0;
    }

    public String getLargestArea(Country c1, Country c2) {
        switch (compare(c1, c2)) {
            case 0:
                return c1 + " area is equal to " + c2 + " area";
            case 1:
                return c1 + " area more than " + c2 + " area";
            case -1:
                return c2 + " area more than " + c1 + " area";
            default:
                return "Invalid parameters";
        }
    }
}
