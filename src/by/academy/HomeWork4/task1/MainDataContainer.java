package by.academy.HomeWork4.task1;

import java.time.LocalDate;
import java.util.*;

public class MainDataContainer {

    public static void main(String[] args) {
        DataContainer<Person> personDataContainer = new DataContainer<>(new Person[100000]);
        DataContainer<Animal> animalDataContainer = new DataContainer<>(new Animal[100000]);

        for (int i = 0; i < 100000; i++) {
            personDataContainer.add(new Person(getRndStr(), getRndStr(), getRndDate()));
            animalDataContainer.add(new Animal((int) (Math.random() * 200), getRndStr()));
        }

        System.out.println(Arrays.toString(personDataContainer.getData()));

        DataContainer.sort(personDataContainer, new PersonRegistrationComparator());
        System.out.println("Sorted PersonDataContainer:" + '\n' + Arrays.toString(personDataContainer.getData()));

        personDataContainer.delete(2);
        System.out.println("Delete element by index in PersonDataContainer:" + '\n' + Arrays.toString(personDataContainer.getData()));

//        personDataContainer.delete();
//        System.out.println("Delete element by item in PersonDataContainer:" + '\n' + Arrays.toString(personDataContainer.getData()));

        System.out.println(Arrays.toString(animalDataContainer.getData()));

        DataContainer.sort(animalDataContainer, new AnimalAgeComparator());
        System.out.println("Sorted AnimalDataContainer:" + '\n' + Arrays.toString(animalDataContainer.getData()));

        animalDataContainer.delete(2);
        System.out.println("Delete element by index in AnimalDataContainer:" + '\n' + Arrays.toString(animalDataContainer.getData()));

//        animalDataContainer.delete();
//        System.out.println("Delete element by item in AnimalDataContainer:" + '\n' + Arrays.toString(animalDataContainer.getData()));

    }

    public static String getRndStr() {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            char c = chars[rnd.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }

    public static LocalDate getRndDate() {
        Random random = new Random();
        int minDay = (int) LocalDate.of(1900, 1, 1).toEpochDay();
        int maxDay = (int) LocalDate.now().toEpochDay();
        long randomDay = minDay + random.nextInt(maxDay - minDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
