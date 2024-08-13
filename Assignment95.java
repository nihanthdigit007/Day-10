import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Assignment95 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1);

        Thread producer = new Thread(() -> {
            try {
                String[] messages = {"Message 1", "Message 2", "Message 3"};
                for (String message : messages) {
                    System.out.println("Producer: Putting " + message);
                    queue.put(message);
                    System.out.println("Producer: Put " + message);
                }
                queue.put("DONE");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                String message;
                while (!(message = queue.take()).equals("DONE")) {
                    System.out.println("Consumer: Took " + message);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
    }
}
