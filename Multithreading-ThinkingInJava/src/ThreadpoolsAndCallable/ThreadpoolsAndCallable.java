package ThreadpoolsAndCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadpoolsAndCallable {
    public static void main(String[] args) throws InterruptedException {
        final int NB_OF_ELEMENTS = 500_000_000;
        final int NB_OF_THREADS = 4;

        int[] array = new int[NB_OF_ELEMENTS];

        for (int i = 0; i < NB_OF_ELEMENTS; i++) {
            array[i] = i + 1;
        }

//        Sequential
        long sum = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NB_OF_ELEMENTS; i++) {
            sum += array[i];
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Sequential sum = " + sum + " computed in " + (endTime - startTime) + " ms");


//        Paralel using a vector of threads
        sum = 0;
        startTime = System.currentTimeMillis();

        ArraySummingThread[] threads = new ArraySummingThread[NB_OF_THREADS];

        for (int i = 0; i < NB_OF_THREADS; i++) {
            threads[i] = new ArraySummingThread(array, i * NB_OF_ELEMENTS / NB_OF_THREADS,
                    (i + 1) * NB_OF_ELEMENTS / NB_OF_THREADS);
            threads[i].start();
        }

        for (int i = 0; i < NB_OF_THREADS; i++) {
            threads[i].join();
        }

        for (int i = 0; i < NB_OF_THREADS; i++) {
            sum += threads[i].getSum();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Paralel sum = " + sum + " computed in " + (endTime - startTime) + " ms");

//        Paralel using ThreadPool

        sum = 0;
        startTime = System.currentTimeMillis();

        ExecutorService threadPool = Executors.newFixedThreadPool(NB_OF_THREADS);
        threads = new ArraySummingThread[NB_OF_THREADS];
        for (int i = 0; i < NB_OF_THREADS; i++) {
            threads[i] = new ArraySummingThread(array,
                    i * NB_OF_ELEMENTS / NB_OF_THREADS, (i + 1) * NB_OF_ELEMENTS / NB_OF_THREADS);

//            Add threads[i] in threadPool
            threadPool.execute(threads[i]);
        }
        threadPool.shutdown();
        threadPool. awaitTermination(30, TimeUnit.MINUTES);

        for (int i = 0; i < NB_OF_THREADS; i++) {
            sum += threads[i].getSum();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Paralel sum with ThreadPool = " + sum + " computed in " + (endTime - startTime) + " ms");

//            Working with callable

        sum = 0;
        startTime = System.currentTimeMillis();
        ArraySummingCallable[] callables = new ArraySummingCallable[NB_OF_THREADS];
        threadPool = Executors.newFixedThreadPool(NB_OF_THREADS);
        List<Future<Long>> results = new ArrayList<>();
        for (int i = 0; i < NB_OF_THREADS; i++) {
            callables[i] = new ArraySummingCallable(array,
                    i * NB_OF_ELEMENTS / NB_OF_THREADS, (i + 1) * NB_OF_ELEMENTS / NB_OF_THREADS);
            results.add(threadPool.submit(callables[i]));
        }

        threadPool.shutdown();

        for(Future<Long> f : results){
            try {
                sum+=f.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("Paralel sum with Callable = " + sum + " computed in " + (endTime - startTime) + " ms");

    }
}
