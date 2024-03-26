import java.util.ArrayList;
import java.util.Random;

class TSP {
    private ArrayList<City> cities;
    private int numCities;

    public TSP(ArrayList<City> cities) {
        this.cities = cities;
        this.numCities = cities.size();
    }

    public double totalDistance(ArrayList<Integer> tour) {
        double total = 0.0;
        for (int i = 0; i < numCities - 1; i++) {
            int cityIndex1 = tour.get(i);
            int cityIndex2 = tour.get(i + 1);
            total += cities.get(cityIndex1).distanceTo(cities.get(cityIndex2));
        }
        // Return to the starting city
        total += cities.get(tour.get(numCities - 1)).distanceTo(cities.get(tour.get(0)));
        return total;
    }

    public ArrayList<Integer> nearestNeighborTour() {
        ArrayList<Integer> tour = new ArrayList<>();
        boolean[] visited = new boolean[numCities];
        Random rand = new Random();

        int startCity = rand.nextInt(numCities); // Rastgele başlangıç şehri seçimi
        tour.add(startCity);
        visited[startCity] = true;

        while (tour.size() < numCities) {
            int lastCity = tour.get(tour.size() - 1);
            int nearestCity = -1;
            double minDistance = Double.MAX_VALUE;

            // En yakın komşuyu bul
            for (int i = 0; i < numCities; i++) {
                if (!visited[i]) {
                    double distance = cities.get(lastCity).distanceTo(cities.get(i));
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestCity = i;
                    }
                }
            }

            if (nearestCity == -1) // Ziyaret edilmemiş şehir kalmadıysa döngüden çık
                break;

            tour.add(nearestCity);
            visited[nearestCity] = true;
        }

        // Eğer tüm şehirler ziyaret edilmediyse, başlangıç şehrinden başla ve kalan şehirleri ekleyerek döngüyü tamamla
        if (tour.size() < numCities) {
            for (int i = 0; i < numCities; i++) {
                if (!visited[i]) {
                    tour.add(i);
                    visited[i] = true;
                }
            }
        }

        return tour;
    }

}
