/**
 * Represents the class for Song.
 * @author Diya Sharma
 * @version 21.0.1
 */

public class Song implements Comparable<Song>, Likeable {

    private String title;
    private int duration;
    private int likes;
    private int dislikes;

    /**
     * Constructs a Song object with a title and duration.
     * Default values of likes and dislikes is 0.
     * @param t the title of the song.
     * @param d the duration of the song.
     */
    public Song(String t, int d) {
        title = t;
        duration = d;
        likes = 0;
        dislikes = 0;
    }

    /**a
     * compares two songs likeFactor.
     * @param s song to compare to.
     * @return 0 if equal, 1 if this > s, -1 if this < s.
     */
    public int compareTo(Song s) {
        //Song s = (Song) o;
        int thisLikeFactor = this.likes - this.dislikes;
        int sLikeFactor = s.likes - s.dislikes;
        return Integer.compare(thisLikeFactor, sLikeFactor);
    }

    @Override
    /**
     * two songs are equal if same title, duration, likes, and dislikes.
     * @return true if equal false otherwise.
     */
    public boolean equals(Object o) {
        Song s = (Song) o;
        return this.title == s.title && this.duration == s.duration
            && this.likes == s.likes && this.dislikes == s.dislikes;
    }

    @Override
    /**
     * overrides toString method.
     * @return string stating title, duration, likes, and dislikes.
     */
    public String toString() {
        return title + ", Duration: " + duration + ", Likes: " + likes + ", Dislikes: " + dislikes;
    }

    /**
     * Increases likes by 1.
     */
    public void like() {
        likes++;
    }

    /**
     * Increases dislikes by 1.
     */
    public void dislike() {
        dislikes++;
    }

    /**
     * gets value of likes.
     * @return likes.
     */
    public int getLikes() {
        return likes;
    }

    /**
     * gets value of dislikes.
     * @return dislikes.
     */
    public int getDislikes() {
        return dislikes;
    }

    /**
     * gets value of duration.
     * @return duration.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * gets title.
     * @return title.
     */
    public String getTitle() {
        return title;
    }
}