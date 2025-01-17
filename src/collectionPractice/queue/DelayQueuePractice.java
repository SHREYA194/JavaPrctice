package collectionPractice.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 
 */

public class DelayQueuePractice {
    public static void main(String[] args) {
        basicEx();
    }

    private static void basicEx() {
        BlockingQueue<DelayedTask> queue = new DelayQueue<>();
        try {
            queue.put(new DelayedTask("task 1", 5, TimeUnit.SECONDS));
            queue.put(new DelayedTask("task 2", 3, TimeUnit.SECONDS));
            queue.put(new DelayedTask("task 3", 10, TimeUnit.SECONDS));

            while (!queue.isEmpty()) {
                DelayedTask task = queue.take();
                System.out.println(task.getTaskName() + " " + System.currentTimeMillis());
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

class DelayedTask implements Delayed {

    private final String taskName;
    private final long startTime;

    DelayedTask(String taskName, long delay, TimeUnit unit) {
        this.taskName = taskName;
        this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
    }


    @Override
    public long getDelay(TimeUnit unit) {
        long remaining = startTime - System.currentTimeMillis();
        return unit.convert(remaining, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
       if (this.startTime < ((DelayedTask) o).startTime) {
           return -1;
       }
       if (this.startTime > ((DelayedTask) o).startTime) {
           return 1;
       }
       return 0;
    }

    public String getTaskName() {
        return taskName;
    }
}
