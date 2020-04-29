package by.academy.HomeWork6.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OutOfMemoryErrMain {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        try {
            for (; ; ) {
                objects.add(new Object());
            }
        } catch (OutOfMemoryError e) {
            objects.clear();
            Scanner scan = new Scanner(System.in);
            System.out.println("Ошибка добавления Object в ArrayList<Object> objects.\nЗадайте размер ArrayList:");
            objects.ensureCapacity(scan.nextInt());
        }
        System.out.println(Arrays.toString(objects.toArray()));
    }
}
