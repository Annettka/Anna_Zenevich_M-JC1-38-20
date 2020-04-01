package by.academy.HomeWork2.task2;

public class CounterNumsOfRepeat {
    public int getOddRepeatedNumber(int[] numbers) {
        int repNum = 0;
        for (int number : numbers) {
            int n = 0;
            for (int i : numbers) {
                if (number == i) {
                    n++;
                }
            }
            if (n % 2 != 0) {
                repNum = number;
                break;
            }
        }
        return repNum;
    }
}
