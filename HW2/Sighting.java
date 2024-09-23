public class Sighting {
    private Observer observer;
    private Silhouette silhouette;
    private Size size;
    private String date;

    public Sighting(Silhouette silhouette, Size size, Observer observer, String date) {
        this.observer = observer;
        this.silhouette = silhouette;
        this.size = size;
        this.date = date;
        UFO.getUfo(silhouette, size).newSighting();
    }
    public String toString() {
        String sizeString = size == Size.REGULAR ? "" : size.toString().toLowerCase() + " ";
        return observer.toString() + " spotted a " + sizeString + "flying " + silhouette.toString().toLowerCase()
                + ", a UFO seen " + UFO.getUfo(silhouette, size).getSightings() + " times, on " + date;
    }
    public static UFO mostSighted(Sighting[] sightings) {
        UFO mostSightedUFO = null;
        int max = 0;
        for (Sighting sighting : sightings) {
            if (UFO.getUfo(sighting.silhouette, sighting.size).getSightings() > max) {
                max = UFO.getUfo(sighting.silhouette, sighting.size).getSightings();
                mostSightedUFO = UFO.getUfo(sighting.silhouette, sighting.size);
            }
        }
        return mostSightedUFO;
    }
}