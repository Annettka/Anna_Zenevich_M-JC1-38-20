package by.academy.HomeWork4.task1;

import java.util.Comparator;

public class PersonRegistrationComparator implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getRegistration().compareTo(p2.getRegistration());
    }
}
