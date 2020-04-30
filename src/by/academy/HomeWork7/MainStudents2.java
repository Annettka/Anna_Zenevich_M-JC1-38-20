package by.academy.HomeWork7;

import java.io.*;
import java.util.*;

public class MainStudents2 {
    public static void main(String[] args) throws IOException {

        ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("Students.bin")));
        ArrayList<Student> students = new ArrayList<>();
        /**
         * first variant:
         */
        /*try {
            students = (ArrayList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/

        /**
         * second variant:
         */
        while (true) {
            try {
                students.add((Student) in.readObject());
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }

        System.out.println("Unsorted list of students\n" + students);
        System.out.println();

        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
        System.out.println("Sorted by name list of students\n" + students);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("StudentsSorted.txt"));
        for (Student student : students) {
//            out.writeChars(student.getName());
            out.writeUTF(student.getName());
            out.writeInt(student.getAge());
            out.writeInt(student.getId());
//            out.writeChars("\n");
        }
        out.flush();
        out.close();

        ObjectInputStream in1 = new ObjectInputStream(new BufferedInputStream(new FileInputStream("StudentsSorted.txt")));
        ArrayList<Student> students1 = new ArrayList<>();

        while (true) {
            try {
                students1.add(new Student(in1.readUTF(), in1.readInt(), in1.readInt()));
            } catch (EOFException e) {
                break;
            }
        }
        System.out.println("Sorted by name list of students. From StudentsSorted.txt\n" + students1);

    }
}
