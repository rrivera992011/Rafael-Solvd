public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        car.setColor("Blue");
        car.setProductionYear(1999);

        String carColor = car.getColor();
        int carYear = car.getProductionYear();

        System.out.println(carColor);
        System.out.println(carYear);
    }
}