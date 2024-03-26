import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis(); // Başlangıç zamanı

        ArrayList<City> cities = new ArrayList<>();

        // Read data from file
        try (BufferedReader br = new BufferedReader(new FileReader("Resources/tsp_51_1"))) {
            int numCities = Integer.parseInt(br.readLine());
            for (int i = 0; i < numCities; i++) {
                String[] coordinates = br.readLine().split(" ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                cities.add(new City(x, y));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TSP tsp = new TSP(cities);
        ArrayList<Integer> tour = tsp.nearestNeighborTour();
        double totalDistance = tsp.totalDistance(tour);

        long endTime = System.currentTimeMillis(); // Bitiş zamanı
        long elapsedTime = endTime - startTime; // İşlem süresi

        System.out.println("Optimal Tour:");
        for (int i = 0; i < tour.size(); i++) {
            System.out.print(tour.get(i) + " ");
        }
        System.out.println("\nTotal Distance: " + totalDistance);
        System.out.println("Elapsed Time: " + elapsedTime + " milliseconds");
    }
}
