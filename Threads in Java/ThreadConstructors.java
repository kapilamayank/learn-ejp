class MyThr extends Thread {
    public MyThr(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("hello world");
    }
}
public class ThreadConstructors {
    public static void main(String[] args) {
        MyThr t1 = new MyThr("Thread 1");
        System.out.println(t1.getName());
        System.out.println(t1.threadId()); // all threads have a unique id 
    }
}
