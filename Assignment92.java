public class Assignment92 {

    private static volatile Assignment92 uniqueInstance;

    private Assignment92() {}

    public static Assignment92 getInstance() {
        if (uniqueInstance == null) {
            synchronized (Assignment92.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Assignment92();
                }
            }
        }
        return uniqueInstance;
    }
    public void showMessage() {
        System.out.println("Hello from Nihanth Naidu!");
    }
    public static void main(String[] args) {
        Assignment92 instance = Assignment92.getInstance();
        instance.showMessage();
    }
}

