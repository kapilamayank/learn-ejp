class MyThr extends Thread {
    public Long val;

    @Override 
    public void run() {
        System.out.print(this.val);
    }
}

public class ThreadMethods {
    public static void main(String[] args) {
        MyThr obj = new MyThr();

        obj.start();
    }
}
