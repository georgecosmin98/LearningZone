public class Exercise1 implements Runnable{

    public Exercise1() {
        System.out.println("This thread is starting!");
    }

    @Override
    public void run() {
        System.out.println("Thread name is: " +Thread.currentThread().getName());
        Thread.yield();
        System.out.println("This is the first message");
        Thread.yield();
        System.out.println("This is the second message");
        Thread.yield();
        System.out.println("This is the third message");
        Thread.yield();

        System.out.println("The job is done!");
    }

}
