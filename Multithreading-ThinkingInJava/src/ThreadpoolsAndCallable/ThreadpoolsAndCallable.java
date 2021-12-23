package ThreadpoolsAndCallable;

public class ThreadpoolsAndCallable {
    public static void main(String[] args) throws InterruptedException {
        final int NB_OF_ELEMENTS = 500_000_000;
        final int NB_OF_THREADS = 4;

        int[] array = new int[NB_OF_ELEMENTS];

        for (int i = 0; i < NB_OF_ELEMENTS; i++) {
            array[i] = i + 1;
        }

        long sum = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < NB_OF_ELEMENTS; i++) {
            sum += array[i];
        }
        long endTime = System.currentTimeMillis();

        System.out.println("Sequential sum = " + sum + " computed in " + (endTime - startTime) + " ms");

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
    }
}
