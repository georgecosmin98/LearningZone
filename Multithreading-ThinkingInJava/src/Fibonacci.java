public class Fibonacci implements Runnable {
    private int count = 0;
    private int numberOfElements;
    private static Object lock = new Object();

    public Fibonacci(int numberOfElements) {
        System.out.println("Number of elements is: " + numberOfElements);
        this.numberOfElements = numberOfElements;
    }

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) return 1;
        return fib(n - 2) + fib(n - 1);
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("Thread name: " + Thread.currentThread().getName());
            for (int i = 0; i < numberOfElements; i++)
                System.out.print(next() + " ");
            System.out.println();
        }
    }
}

