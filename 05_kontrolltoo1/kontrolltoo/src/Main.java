import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int kiirus1 = 60;
        int kiirus2 = 50;
        System.out.println(kiirus1 + " km/h ja " + kiirus2 + " km/h keskmine on " + kaheKeskmine(kiirus1, kiirus2));
        ArrayList<Double> kiirusedArray = new ArrayList<Double>(Arrays.asList(50.0,60.0,62.0));
        System.out.println("Listis olevate kiiruste keskmine on " + listiKeskmine(kiirusedArray));
        ArrayList<Double> kiirusedArrayFailist = new ArrayList<Double>();
        System.out.println("Faili kirjutati: " + listiKeskmineFailist(kiirusedArrayFailist));
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
    public static double listiKeskmineFailist(ArrayList<Double> kiirusedArrayFailist){
        // Failist lugemine
        try {
            BufferedReader br = new BufferedReader(new FileReader("kiirused.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                double number = Double.parseDouble(line);
                kiirusedArrayFailist.add(number);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Keskmise arvutamine
        double kiirusedTotal = 0;
        for (int i = 0; i < kiirusedArrayFailist.size(); i++) {
            kiirusedTotal += kiirusedArrayFailist.get(i);
        }

        double kiirusteKeskmine = kiirusedTotal / kiirusedArrayFailist.size();
        // Faili kirjutamine
        try {
            FileWriter writer = new FileWriter("keskminekiirus.txt");
            writer.write(Double.toString(kiirusteKeskmine));
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
        return kiirusedTotal / kiirusedArrayFailist.size();
    }


}