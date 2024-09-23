public class Observer {
    private String name;
    private String location;

    public Observer(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Sighting documentSighting(Silhouette silhouette, Size size, String date) {
        if (UFO.getUfo(silhouette, size) != null) {
            return new Sighting(silhouette, size, this, date);
        } else {
            UFO newUFO = new UFO(silhouette, size);
            return new Sighting(silhouette, size, this, date);
        }
    }
    public String toString() {
        return this.name + " in " + this.location;
    }
}