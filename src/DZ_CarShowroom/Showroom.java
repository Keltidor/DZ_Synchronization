package DZ_CarShowroom;

import java.util.ArrayList;
import java.util.List;

public class Showroom {
    List<Car> cars = new ArrayList<>(1);
    Customer customer = new Customer(this);
    int iMax = 10;

    public List<Car> cars() {
        return cars;
    }

    public void sellCar() {
        System.out.printf("%s начал продажу автомобилей!\n\n", Thread.currentThread().getName());
        try {
            while (iMax != 0) {
                Thread.sleep(3000);
                System.out.printf("%s подготовил автомобиль к продаже\n", Thread.currentThread().getName());
                cars.add(new Car());
                customer.receiveCar();
                iMax--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Car buyCar() {
        return customer.buyCar();
    }
}
