public class Assignment98 implements AutoCloseable {
    public Assignment98() {
        System.out.println("ResourceWithFinalizer created");
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("ResourceWithFinalizer is being garbage collected");
        super.finalize();
    }
    @Override
    public void close() {
        System.out.println("ResourceWithFinalizer is being closed");
    }
    public void useResource() {
        System.out.println("Using ResourceWithFinalizer");
    }
    public static void main(String[] args) {
        // Using try-with-resources
        try (Assignment98 resource = new Assignment98()) {
            resource.useResource();
        }
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
