package DZ_CarShowroom;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Showroom showroom = new Showroom();

        new Thread(null, showroom::sellCar, "Автосалон").start();

        for (int i = 1; i < 11; i++) {
            Thread.sleep(3500);
            new Thread(null, showroom::buyCar, "Покупатель " + i).start();
        }
    }
}
