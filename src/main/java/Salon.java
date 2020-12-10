import java.util.ArrayList;
import java.util.List;

public class Salon {
    int cars = 10;
    int delivery = 1000;
    long[] arrive = new long[]{1000, 2000, 3000};

    List<Car> car = new ArrayList<>();

    public synchronized void receiveCar() {
        try {
            for (int i = 0; i < cars; i++) {
                Thread.sleep(delivery);
                notifyAll();
                System.out.println(Thread.currentThread().getName() + " Saab пригнал авто. Машин в парке: " + (getCars().size() + 1));
                getCars().add(new Car());
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sellCar() {
        try {
            int n = (int) Math.floor(Math.random() * arrive.length);
            Thread.sleep(arrive[n]);
            System.out.println(Thread.currentThread().getName() + " зашел в автосалон.");
            while (getCars().size() == 0) {
                System.out.println("Машин нет.");
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " уехал на новеньком авто.");
            getCars().remove(0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    List<Car> getCars() {
        return car;
    }
}