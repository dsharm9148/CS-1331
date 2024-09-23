import java.util.ArrayList;

/**
 * Represents the class for Playlist.
 * @author Diya Sharma
 * @version 21.0.1
 */
public class Playlist implements Comparable<Playlist>, Likeable {

    private String title;
    private User owner;
    private int dateCreated;
    private ArrayList<Song> songs;
    private int duration;
    private int likes;
    private int dislikes;

    /**
     * Constructs a Playlist object with a title, user, and date created.
     * Default values of likes, dislikes, and duration is 0.
     * @param t the title of the plalist.
     * @param o the owner/user of the playlist.
     * @param date the date created of the playlist.
     */
    public Playlist(String t, User o, int date) {
        if (t != null) {
            title = t;
        } else {
            title = "Untitled Playlist";
        }
        owner = o;
        if (date >= 0) {
            dateCreated = date;
        } else {
            dateCreated = 0;
        }
        songs = new ArrayList<Song>(0);
        duration = 0;
        likes = 0;
        dislikes = 0;
    }

    /**
     * adds song to playlist.
     * @param s song to add.
     */
    public void addSong(Song s) {
        if (s != null) {
            songs.add(s);
        }
    }

    /**
     * removes song from playlist.
     * @param s song to remove.
     * @return true if song removed, false otherwise.
     */
    public boolean removeSong(Song s) {
        for (Song song : songs) {
            if (song.equals(s)) {
                songs.remove(s);
                return true;
            }
        }
        return false;
    }

    /**
     * converts songs to array.
     * @return Song[] array.
     */
    public Song[] toArray() {
        Song[] output = new Song[songs.size()];
        for (int i = 0; i < songs.size(); i++) {
            output[i] = songs.get(i);
        }
        return output;
    }

    /**
     * finds topSong (highest likeFactor) and worstSong (lowest likeFactor).
     * @return Song array of top and worst song.
     */
    public Song[] topAndWorstSong() {
        Song topSong = songs.get(0);
        Song worstSong = songs.get(0);
        int topLikeFactor = topSong.getLikes() - topSong.getDislikes();
        int worstLikeFactor = topLikeFactor;
        for (Song song : songs) {
            int likeFactor = song.getLikes() - song.getDislikes();
            if (likeFactor > topLikeFactor) {
                topLikeFactor = likeFactor;
                topSong = song;
            } else if (likeFactor < worstLikeFactor) {
                worstLikeFactor = likeFactor;
                worstSong = song;
            }
        }
        return new Song[] {topSong, worstSong};
    }

    @Override
    /**
     * overrides toString method.
     * @return string stating title, size, duration, likeFactor, and dateCreated.
     */
    public String toString() {
        return title + " has " + songs.size() + " songs, is " + duration + " long, has a "
            + "like factor of " + (likes - dislikes) + ", and was created " + dateCreated
            + " days after the platform released.";
    }

    @Override
    /**
     * two playlists are equal if same title, owner, size, and duration.
     * @return true if equal false otherwise.
     */
    public boolean equals(Object o) {
        Playlist p = (Playlist) o;
        return this.title.equals(p.title) && this.owner == p.owner
            && this.songs.size() == p.songs.size() && this.duration == p.duration;
    }

    /**
     * compares two playlists date created.
     * @param p playlist to compare to.
     * @return 0 if equal, positive value if this > p, and negative value if this < p.
     */
    public int compareTo(Playlist p) {
        //Playlist p = (Playlist) o;
        return this.dateCreated - p.dateCreated;
    }

    /**
     * gets title.
     * @return title.
     */
    public String getTitle() {
        return title;
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
     * gets songs.
     * @return songs.
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * gets user.
     * @return owner.
     */
    public User getUser() {
        return owner;
    }

    /**
     * gets dateCreated.
     * @return dateCreated.
     */
    public int getDateCreated() {
        return dateCreated;
    }
}