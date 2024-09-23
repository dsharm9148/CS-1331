public class UFO {
    private Silhouette silhouette;
    private Size size;
    private int sightings;
    private static UFO[] existingUFOs = new UFO[Silhouette.values().length * Size.values().length];

    public UFO(Silhouette silhouette, Size size) {
        this.silhouette = silhouette;
        this.size = size;
        if (getUfo(silhouette, size) == null) {
            this.sightings = 1;
            for (int i = 0; i < existingUFOs.length; i++) {
                if (existingUFOs[i] == null) {
                    existingUFOs[i] = this;
                    break;
                }
            }
        } else {
            getUfo(silhouette, size).newSighting();
        }
    }
    public static UFO getUfo(Silhouette silhouette, Size size) {
        for (UFO ufo : existingUFOs) {
            if (ufo != null && ufo.getSilhouette() == silhouette && ufo.getSize() == size) {
                return ufo;
            }
        }
        return null;
    }
    public Silhouette getSilhouette() {
        return silhouette;
    }

    public Size getSize() {
        return size;
    }

    public int getSightings() {
        return sightings;
    }

    public void newSighting() {
        this.sightings++;
    }

    public String toString() {
        String sizeString = size == Size.REGULAR ? "" : size.toString().toLowerCase() + " ";
        return sizeString + "flying " + silhouette.toString().toLowerCase() + ", a UFO seen " + sightings + " times";
    }
}