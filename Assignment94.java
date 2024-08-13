public class Assignment94 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread: Interrupting the worker thread");
        thread.interrupt();
    }
}
class Task implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Worker thread: Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Worker thread: Interrupted");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Worker thread: Exiting");
    }
}
