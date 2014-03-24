public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor(new FileEvent());
        try {
            monitor
            .addFile("i:/Users/10/sundrop/1.txt")
            .addFile("i:/Users/10/sundrop/2.txt")
            .start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
