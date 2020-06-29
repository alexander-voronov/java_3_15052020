package lesson4;

public class Main {

    //pull
    static Object one = new Object();
    static volatile int currentLetter = 1;
    static final int letter = 4;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                for (int i = 0; i < letter; i++) {
                    synchronized (one) {
                        while (currentLetter != 1) {
                            one.wait();
                        }
                        System.out.print("A");
                        currentLetter = 2;
                        one.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < letter; i++) {
                    synchronized (one) {
                        while (currentLetter != 2) {
                            one.wait();
                        }
                        System.out.print("B");
                        currentLetter = 3;
                        one.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < letter; i++) {
                    synchronized (one) {
                        while (currentLetter != 3) {
                            one.wait();
                        }
                        System.out.print("C");
                        currentLetter = 1;
                        one.notifyAll();
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
