import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
//        LiftOff launch = new LiftOff();
//        launch.run();

//        Thread t = new Thread(new LiftOff());
//        t.start();
//        System.out.println("Waiting for LiftOff");

//        Ex 1
//        Thread t = new Thread(new Exercise1());
//        Thread t1 = new Thread(new Exercise1());
//        t.setName("First thread!");
//        t1.setName("Second thread!");
//        t.start();
//        t1.start();

//        Ex 2
        Thread t = new Thread(new Fibonacci(38),"First Thread");
        Thread t1 = new Thread(new Fibonacci(40),"Second Thread");
        Instant start1 = Instant.now();
        t.start();
        Instant end1 = Instant.now();
        Instant start2 = Instant.now();
        t1.start();

        List<Thread> threads = new ArrayList<>();
        threads.add(t);
        threads.add(t1);

        for (Thread th : threads) {
            th.join();
        }
        Instant end2 = Instant.now();
        System.out.println(Duration.between(start1, end1));
        System.out.println(Duration.between(start2, end2));
        System.out.println(Duration.between(start1, end2));
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        executorService.execute(new Fibonacci(18));
//        executorService.execute(new Fibonacci(16));
//        executorService.shutdown();
    }
}
