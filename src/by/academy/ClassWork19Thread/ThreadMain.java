package by.academy.ClassWork19Thread;

import java.util.concurrent.TimeUnit;

public class ThreadMain {

    static long a = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                for (long i = 0; i < 10L; i++) {
                    a += 1;
                    System.err.println("setter a = " + a);
                    TimeUnit.MILLISECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                System.err.println("InterruptedException");
            }
        });

        t1.start();

        int numOfAttempts = 0;

        try {
            do {
                t1.join(10);
                if (t1.isAlive()) {
                    numOfAttempts++;
                }
            } while (numOfAttempts < 5 && t1.isAlive());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (t1.isAlive() && numOfAttempts >= 5) {
            System.err.println("Bad");
        } else {
            System.out.println("Good");
        }


    }
}
