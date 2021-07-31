package DZ_CarShowroom;

import static DZ_CarShowroom.Main.NUMBER_OF_CLIENTS;

public class Producer extends Thread {
    private static final long TIME_FOR_CREATE_CAR = 3000L;
    private final Showroom showroom;

    public Producer(Showroom showroom) {
        this.showroom = showroom;
    }

    public void deliveryCar(Car car) {
        showroom.receiveCar(car);
    }

    public Car produceCar() {
        return new Car();
    }

    @Override
    public void run() {
        for (int i = 0; i < NUMBER_OF_CLIENTS; i++) {
            try {
                System.out.println("Создаю машину");
                Thread.sleep(TIME_FOR_CREATE_CAR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Car car = produceCar();
            System.out.println("Машина создалась, отправляю в автосалон");
            deliveryCar(car);
        }
    }
}
