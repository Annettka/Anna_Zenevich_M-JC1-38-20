package by.academy.HomeWork7;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainStudents1 {
    public static void main(String[] args) throws IOException {
        Random rnd = new Random();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            students.add(new Student(getRndStr(), (17 + rnd.nextInt(30 - 17)), rnd.nextInt(100000)));
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Students.bin"));
        /**
         * first var:
         * out.writeObject(students);
         *
         * second var:
         */
        for (Student student : students) {
            out.writeObject(student);
        }
        out.close();
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

}
