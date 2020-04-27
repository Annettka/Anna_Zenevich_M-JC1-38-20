package by.academy.HomeWork6.task1;

public class StackOverflowErrorMain {

    public static void main(String[] args) {

        try {
            Man man = new Man();
        } catch (StackOverflowError e) {
            e.getMessage();
            System.err.println("Ой! Переполнение стека при создании объекта класса Man");
        }
    }
}

class Man {
    String name;
    Man man = new Man();
}
