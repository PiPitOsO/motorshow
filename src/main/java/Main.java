public class Main {
    public static void main(String[] args) {
        int cars = 10;
        Salon salon = new Salon();
        System.out.println("\nАвтосалон");
        System.out.println("Добро пожаловать в Saab\n");

        ThreadGroup visitor = new ThreadGroup("Посетитель");
        for (int i = 0; i < cars; i++) {
            int n = i + 1;
            new Thread(visitor, salon::sellCar, "Посетитель" + n).start();
        }
        new Thread(null, salon::receiveCar, "Производитель").start();
    }
}