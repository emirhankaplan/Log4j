package org.example;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class myTimerLoggings {
    private static final Logger logger = LogManager.getLogger(myTimerLoggings.class);
    public static void main(String[] args) {
        Timer timer = new Timer();

        // Debug için saniye artışı ile loglama
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.debug(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }, 0, 1000); // 1 saniye aralığı

        // Info için dakika artışı ile loglama
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.info(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }, getNextMinute(), 60000); // Dakika başında başlatma ve 1 dakika aralığı

        // Error için saat artışı ile loglama
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                logger.error(new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }, getNextHour(), 3600000); // Saat başında başlatma ve 1 saat aralığı
    }

    private static long getNextMinute() {
        long currentTime = System.currentTimeMillis();
        return 60000 - (currentTime % 60000);
    }

    private static long getNextHour() {
        long currentTime = System.currentTimeMillis();
        return 3600000 - (currentTime % 3600000);
    }
}
