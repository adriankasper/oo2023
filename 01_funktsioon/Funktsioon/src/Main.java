public class Main {
    public static void main(String[] args) {

        int EAP = 180;
        int hours = 79;

        System.out.println(EAP + " EAP = " + GetEAPWorkTime(EAP) + " tundi tööd.");
        System.out.println(hours + " tundi = " + GetHoursFromDays(hours) + " päeva.");
        System.out.println();
        MultiplicationTable();


    }

    private static void MultiplicationTable() {
        System.out.println("Korrutustabel:");
        for (int x = 1; x < 11; x++) {
            if (x != 1) {
                System.out.println();
            }
            for (int y = 1; y < 11; y++) {
                int number = x*y;
                System.out.format("%-4d", number);
            }
        }
    }

    private static int GetEAPWorkTime(int EAP) {
        return EAP*26;
    }
    private static double GetHoursFromDays(int hours) {
        return (double) hours /24;
    }


}
