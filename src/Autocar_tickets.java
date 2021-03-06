import java.util.*;

public class Autocar_tickets {
    static String[] Cities = {"Vierson", "Salbris", "Nouans", "Lamotte-Beuvron", "La Ferté Saint-Aubin", "Orleans"};
    static double[] Prices = {3.2, 1.8, 2.3, 4.2, 5};

    public static int getStationNumber(String city) {
        for (int i = 0; i < Cities.length; i++)
            if (city.equals(Cities[i])) {
                return i;
            }
        return -1;
    }

    public static double TravelPrice(String city1, String city2) {
        double price = 0;
        int indexA = getStationNumber(city1);
        int indexB = getStationNumber(city2);
        if (indexA < indexB) {
            for (int i = indexA, j=0; i < indexB; i++, j++) {
                price = price + Prices[i] * (1 - j * 0.1);
            }
        } else {
            for (int i = indexA-1, j=0; i >= indexB; i--, j++) {
                price = price + Prices[i] * (1 - j * 0.1);
            }
        }
        return price;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Saisir votre ville de départ :");
        String cityA = scan.nextLine();
        System.out.println("Saisir votre ville d'arrivée :");
        String cityB = scan.nextLine();
        System.out.println("total de votre trajet :" + TravelPrice(cityA, cityB));
    }
}
