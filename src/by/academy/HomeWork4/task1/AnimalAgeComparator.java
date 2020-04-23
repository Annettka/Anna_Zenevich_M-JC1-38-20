package by.academy.HomeWork4.task1;

import java.util.Comparator;

public class AnimalAgeComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal a1, Animal a2) {
        return Integer.compare(a1.getAge(), a2.getAge());
    }
}
