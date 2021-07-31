package DZ_CarShowroom;

import java.util.ArrayList;
import java.util.List;

public class Showroom {
    private static final long TIME_FOR_BUY_CAR = 1000L;
    private final List<Car> cars = new ArrayList<>(1);

    public synchronized void receiveCar(Car car) {
        System.out.println("Принимаю машину");
        cars.add(car);
        notify();
        System.out.println("Машина принята");
    }

    public synchronized void sellCar() {
        System.out.printf("%s зашел в магазин\n\n", Thread.currentThread().getName());
        try {
            System.out.printf("%s запросил автомобиль\n", Thread.currentThread().getName());
            while (cars.size() == 0) {
                System.out.println("Машин нет в наличии");
                wait();
            }
            Thread.sleep(TIME_FOR_BUY_CAR);
            System.out.println(Thread.currentThread().getName() + " купил автомобиль");
        } catch (Exception e) {
            e.printStackTrace();
        }
        cars.remove(cars.size() - 1);
    }
}
