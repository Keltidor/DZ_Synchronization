package DZ_CarShowroom;

public class Main {
    public static final int NUMBER_OF_CLIENTS = 10;
    public static final long DELAY_BETWEEN_CLIENTS = 1000L;

    public static void main(String[] args) throws InterruptedException {
        final Showroom showroom = new Showroom();

        Runnable shopping = showroom::sellCar;
        new Producer(showroom).start();

        for (int i = 0; i < NUMBER_OF_CLIENTS; i++) {
            Thread.sleep(DELAY_BETWEEN_CLIENTS);
            new Thread(null, shopping, "Покупатель " + (i + 1)).start();
        }
    }
}