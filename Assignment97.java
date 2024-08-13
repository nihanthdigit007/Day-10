public class Assignment97 {
    public Assignment97() {
        System.out.println("GCExample object created");
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("GCExample object is being garbage collected");
        super.finalize();
    }
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Assignment97 obj = new Assignment97();
            obj = null;
        }
        System.gc();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

