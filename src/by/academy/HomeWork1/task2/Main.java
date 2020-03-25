package by.academy.HomeWork1.task2;

public class Main {
    public static void main(String[] args) {
        Counter count = new Counter();
        int[] numbers1 = new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5};
        int[] numbers2 = new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5};
        int[] numbers3 = new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5};
        int[] numbers4 = new int[]{10};
        int[] numbers5 = new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1};
        int[] numbers6 = new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10};

        System.out.println("Number " + count.getOddRepeatedNumber(numbers1) + " occurs in numbers1 an odd number of times");
        System.out.println("Number " + count.getOddRepeatedNumber(numbers2) + " occurs in numbers2 an odd number of times");
        System.out.println("Number " + count.getOddRepeatedNumber(numbers3) + " occurs in numbers3 an odd number of times");
        System.out.println("Number " + count.getOddRepeatedNumber(numbers4) + " occurs in numbers4 an odd number of times");
        System.out.println("Number " + count.getOddRepeatedNumber(numbers5) + " occurs in numbers5 an odd number of times");
        System.out.println("Number " + count.getOddRepeatedNumber(numbers6) + " occurs in numbers6 an odd number of times");
    }
}
