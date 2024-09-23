public class Investigation {
    public static void main(String[] args) {
        Observer observer1 = new Observer("Diya", "Ellicott City");
        Observer observer2 = new Observer("Sarah", "Myrtle Beach");
        Sighting[] sightings = new Sighting[4];
        sightings[0] = observer1.documentSighting(Silhouette.SAUCER, Size.REGULAR, "02-10-2024");
        sightings[1] = observer2.documentSighting(Silhouette.PYRAMID, Size.GINORMOUS, "02-11-2024");
        sightings[2] = observer1.documentSighting(Silhouette.BLOB, Size.TINY, "02-12-2024");
        sightings[3] = observer2.documentSighting(Silhouette.SPHERE, Size.REGULAR, "02-13-2024");
        for (Sighting s : sightings) {
            System.out.println(s);
        }
        System.out.println("Most-sighted UFO: " + Sighting.mostSighted(sightings).toString());
    }
}