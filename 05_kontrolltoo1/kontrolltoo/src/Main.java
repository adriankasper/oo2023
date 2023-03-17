import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        int kiirus1 = 60;
        int kiirus2 = 50;
        System.out.println(kiirus1 + " km/h ja " + kiirus2 + " km/h keskmine on " + kaheKeskmine(kiirus1, kiirus2));
        ArrayList<Double> kiirusedArray = new ArrayList<Double>(Arrays.asList(50.0,60.0));

        System.out.println("Listis olevate kiiruste keskmine on " + listiKeskmine(kiirusedArray));

    }
    public static double kaheKeskmine(double kiirus1, double kiirus2) {
        double keskmineKiirus = (kiirus1 + kiirus2) / 2;
        return keskmineKiirus;
    }
    public static double listiKeskmine(ArrayList<Double> kiirusedArray) {
        double kiirusedTotal = 0;
        for (int i = 0; i < kiirusedArray.size(); i++) {
            kiirusedTotal += kiirusedArray.get(i);
        }
        return kiirusedTotal / kiirusedArray.size();
    }

}