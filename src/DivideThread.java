import javax.swing.JLabel;
import java.util.concurrent.atomic.AtomicBoolean;

public class DivideThread implements Runnable {
    Thread dividethread;
    JLabel label;
    private int num1;
    private int num2;
    private final AtomicBoolean running = new AtomicBoolean(false);

    DivideThread(int var1, int var2, JLabel var3) {
        this.num1 = var1;
        this.num2 = var2;
        this.label = var3;
    }

    public void stop() {
        running.set(false);
    }

    public void run() {
        running.set(true);
        while (running.get()){
            this.label.setText("Sonuc :" + this.num1 / this.num2);
        }

    }

    public void start() {
        System.out.println("Thread started");
        if (this.dividethread == null) {
            this.dividethread = new Thread(this, "dividethread");
            this.dividethread.start();
        }

    }
}
