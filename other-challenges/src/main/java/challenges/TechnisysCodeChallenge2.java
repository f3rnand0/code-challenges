package technical.challenges;

public class TechnisysCodeChallenge2 implements Runnable {


    private String name;

    public TechnisysCodeChallenge2(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TechnisysCodeChallenge2("1"));
        Thread t2 = new Thread(new TechnisysCodeChallenge2("2"));
        Thread t3 = new Thread(new TechnisysCodeChallenge2("3"));
        Thread t4 = new Thread(new TechnisysCodeChallenge2("4"));
        Thread t5 = new Thread(new TechnisysCodeChallenge2("5"));
        t5.start();
        t3.start();
        t1.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
