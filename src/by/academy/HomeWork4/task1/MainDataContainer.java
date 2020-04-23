package by.academy.HomeWork4.task1;

import java.util.*;

public class MainDataContainer {

    public static void main(String[] args) {
        Random rnd = new Random();
        DataContainer<Person> data1 = new DataContainer<>(new Person[10]);
        DataContainer<Animal> data2 = new DataContainer<>(new Animal[10]);

        for (int i = 0; i < 10; i++) {
            data1.add(new Person(getRndStr(), getRndStr(), new Date(Math.abs(System.currentTimeMillis() - rnd.nextLong()))));
            data2.add(new Animal(rnd.nextInt(), getRndStr()));
        }

        System.out.println(Arrays.toString(data1.getData()));
//        System.out.println(Arrays.toString(data2.getData()));

       // Collections.sort(data1, new PersonRegistrationComparator());
 //       Arrays.sort();

      //  data1.delete();
        data1.delete(3);
        DataContainer.sort(data1, new PersonRegistrationComparator());
        System.out.println(Arrays.toString(data1.getData()));

    }

//

    public static String getRndStr(){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(5);
        for (int i = 0; i < 5; i++) {
            char c = chars[rnd.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
