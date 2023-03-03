package md.utm.lab1;

import java.time.Duration;
import java.util.Timer;

public class Lab1 {
    public static void main(String[] args) throws InterruptedException {
        if (args.length < 2) {
            throw new IllegalArgumentException("You should specify the delay and execution time in seconds!" +
                    "Example: java Lab1 1 30");
        }
        var timer = new Timer(true);
        var task = new PrintTimestampTask();
        var delay = Duration.ofSeconds(Long.parseLong(args[0]));
        var executionTime = Duration.ofSeconds(Long.parseLong(args[1]));

        System.out.printf("Task will be executed with %d seconds delay for %d seconds\n",
                delay.toSeconds(), executionTime.toSeconds());
        timer.schedule(task, delay.toMillis(), delay.toMillis());

        Thread.sleep(executionTime.toMillis());
    }
}