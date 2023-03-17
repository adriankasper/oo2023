public class Main {
    public static void main(String[] args) {
        int kiirus1 = 60;
        int kiirus2 = 50;
        System.out.println(kiirus1 + " km/h ja " + kiirus2 + " km/h keskmine on " + kaheKeskmine(kiirus1, kiirus2));


    }
    public static double kaheKeskmine(double kiirus1, double kiirus2) {
        double keskmineKiirus = (kiirus1 + kiirus2) / 2;
        return keskmineKiirus;
    }
    public static double listiKeskmine(double kiirus1, double kiirus2) {

        return 1;
    }

}