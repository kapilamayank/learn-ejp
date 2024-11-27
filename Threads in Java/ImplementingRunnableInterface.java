class MyRunnable implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.print("1");
        }   
    }
}

public class ImplementingRunnableInterface {
    public static void main(String[] args) {
        MyRunnable r1 = new MyRunnable();
        Thread t1 = new Thread(r1);

        t1.start();
    }
}
