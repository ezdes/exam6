public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ProgrammingLangThread("Java"));
        Thread thread2 = new Thread(new ProgrammingLangThread("C#"));
        Thread thread3 = new Thread(new ProgrammingLangThread("JavaScript"));
        Thread thread4 = new Thread(new ProgrammingLangThread("PHP"));
        Thread thread5 = new Thread(new ProgrammingLangThread("Go"));
        Thread thread6 = new Thread(new ProgrammingLangThread("Python"));

        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        thread3.start();
        thread3.join();
        thread4.start();
        thread4.join();
        thread5.start();
        thread5.join();
        thread6.start();
    }
}

class ProgrammingLangThread implements Runnable {
    private final String name;

    public ProgrammingLangThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
