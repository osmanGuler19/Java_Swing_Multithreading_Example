import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class PrimeThread implements Runnable {
    Thread primethread;
    JLabel label;
    private long num;
    private final AtomicBoolean running = new AtomicBoolean(false);
    PrimeThread(long var1, JLabel var3) {
        this.num = var1;
        this.label = var3;
    }

    public void stop() {
        running.set(false);
    }

    public void run() {
        running.set(true);

        while(running.get()) {
            long var1 = 2L;
            long var3 = this.num;

            for (long var5 = var1; var5 <= var3; ++var5) {
                if (isPrime(var5)) {
                    System.out.println(var5);
                    this.label.setText("Sonuc : Prime sayi => " + var5);
                }
            }
        }
    }

    public void start() {
        System.out.println("Thread started");
        if (this.primethread == null) {
            this.primethread = new Thread(this, "primethread");
            this.primethread.start();
        }

    }

    public  boolean isPrime(long var0) {
        for(int var2 = 2; (long)var2 <= var0 / (long)var2; ++var2) {
            if (var0 % (long)var2 == 0L) {
                return false;
            }
        }

        return true;
    }
}
