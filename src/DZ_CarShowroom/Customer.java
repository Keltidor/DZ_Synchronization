package DZ_CarShowroom;

public class Customer {
    private Showroom showroom;

    public Customer(Showroom showroom) {
        this.showroom = showroom;
    }

    public synchronized Car buyCar() {
        try {
            System.out.printf("%s зашел в автосалон\n", Thread.currentThread().getName());
            Thread.sleep(2000);
            while (showroom.cars.size() == 0) {
                System.out.printf("Нет автомобилей в наличии\n");
                wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("%s Купил автомобиль\n", Thread.currentThread().getName());
        return showroom.cars.remove(0);
    }

    public synchronized void receiveCar() {
        try {
            Thread.sleep(1000);
            notify();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
