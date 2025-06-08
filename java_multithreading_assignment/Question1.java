public class Question1{
    public static void main(String[] args) {
        int maxnumber = 20; // You can change the max number here
        oddevenprinter printer = new oddevenprinter(maxnumber);

        Thread oddThread = new oddthread(printer);
        Thread evenThread = new eventhread(printer);

        oddThread.start();
        evenThread.start();
    }
}



 class oddevenprinter {
    private final int max;
    private int number = 1;
    private final Object lock = new Object();

    public oddevenprinter(int max) {
        this.max = max;
    }

    public void printodd() {
        while (number <= max) {
            synchronized (lock) {
                while (number % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (number <= max) {
                    System.out.println("oddthread: " + number);
                    number++;
                    lock.notify();
                }
            }
        }
    }

    public void printeven() {
        while (number <= max) {
            synchronized (lock) {
                while (number % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (number <= max) {
                    System.out.println("eventhread: " + number);
                    number++;
                    lock.notify();
                }
            }
        }
    }
}

 class oddthread extends Thread {
    private final oddevenprinter printer;

    public oddthread(oddevenprinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printodd();
    }
}

 class eventhread extends Thread {
    private final oddevenprinter printer;

    public eventhread(oddevenprinter printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.printeven();
    }
}
