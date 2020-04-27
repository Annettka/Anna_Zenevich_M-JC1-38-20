package by.academy.Classwork12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionMain {

        public static void main(String[] args) {
            int result;
            int n = 0;
            do {
                try {
                    n++;
                    result = input();
                    if (0 < result && result <= 10) {
                        System.out.println("Молодец! Ты ввел верное число");
                        System.exit(0);
                    }
                } catch (IllegalArgumentException | InputMismatchException e) {
                    if (n < 3) {
                        System.err.println("Ты ввел неверное число, попробуй еще раз");
                    }
                }
            } while (n < 3);
                throw new IllegalArgumentException("Попыток больше нет");
        }

        public static int input() {
            Scanner scan = new Scanner(System.in);
            int i = scan.nextInt();
            if (0 < i && i <= 10) {
                return i;
            } else {
                scan.close();
                throw new IllegalArgumentException();
            }
        }
    }
