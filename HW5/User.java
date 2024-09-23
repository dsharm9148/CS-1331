import java.util.ArrayList;
/**
 * Represents the class for User.
 * @author Diya Sharma
 * @version 21.0.1
 */
public class User {
    private String username;
    private ArrayList<Playlist> library;
    private Song currentPlaying;

    /**
     * Constructs a user object with a userame.
     * Creates library with playlist "Liked".
     * @param u the username of the user.
     */
    public User(String u) {
        if (u != null) {
            username = u;
        } else {
            username = "";
        }
        library = new ArrayList<Playlist>();
        createPlaylist("Liked", 0);
    }

    /**
     * creates playlist and adds to library.
     * @param title playlist title.
     * @param age playlist age.
     */
    public void createPlaylist(String title, int age) {
        if (getPlaylist(title) == null) {
            Playlist playlist = new Playlist(title, this, age);
            library.add(playlist);
        }
    }

    /**
     * adds playlist to library.
     * @param p playlist to add.
     * @return true if if overwrite performed, false otherwise.
     */
    public boolean addPlaylist(Playlist p) {
        if (getPlaylist(p.getTitle()) == null) {
            for (int i = 0; i < library.size(); i++) {
                if (library.get(i).getDateCreated() >= p.getDateCreated()) {
                    library.add(i, p);
                    return false;
                }
            }
        } else {
            library.remove(getPlaylist(p.getTitle()));
            for (int i = 0; i < library.size(); i++) {
                if (library.get(i).getDateCreated() >= p.getDateCreated()) {
                    library.add(i, p);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * searches for playlist in library.
     * @param t title of playlist to get.
     * @return playlist from library.
     */
    public Playlist getPlaylist(String t) {
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).getTitle().equals(t)) {
                return library.get(i);
            }
        }
        return null;
    }

    /**
     * removes playlist from library.
     * @param t title of playlist to remove.
     * @return true if playlist removed, false otherwise.
     */
    public boolean removePlaylist(String t) {
        for (Playlist p : library) {
            if (p.getTitle().equals(t) && !p.getUser().equals(this) && !t.equals("Liked")) {
                library.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     * likes song and adds to 'Liked' playlist if not likes before.
     * @param s song to like.
     */
    public void likeSong(Song s) {
        Playlist p = library.get(0);
        if (!p.getSongs().contains(s)) {
            s.like();
            p.addSong(s);
        }
    }

    /**
     * dislikes song.
     * @param s song to dislike.
     */
    public void dislikeSong(Song s) {
        s.dislike();
    }

    /**
     * likes playlist.
     * @param p playlist to like.
     */
    public void likePlaylist(Playlist p) {
        p.like();
    }

    /**
     * dislikes playlist.
     * @param p playlist to dislike.
     */
    public void dislikePlaylist(Playlist p) {
        p.dislike();
    }

    /**
     * shares playlist.
     * @param u user.
     * @param index index of playlist.
     */
    public void sharePlaylist(User u, int index) {
        u.addPlaylist(library.get(index));
    }

    /**
     * sets currentPlaying to song s.
     * @param s song to set currentPlaying to.
     */
    public void playSong(Song s) {
        currentPlaying = s;
    }

    /**
     * sets currentPlaying to null.
     */
    public void pauseSong() {
        currentPlaying = null;
    }

    //@Override
    /**
     * overrides toString method.
     * @return if song is playing, returns string stating username, song title, duration, and likes/dislikes.
     */
    public String toString() {
        if (currentPlaying == null) {
            return username + " is idle";
        } else {
            return username + " is listening to " + currentPlaying.getTitle() + ", Duration: "
                + currentPlaying.getDuration() + ", Likes: " + currentPlaying.getLikes()
                + ", Dislikes: " + currentPlaying.getDislikes();
        }
    }

    /**
     * gets library.
     * @return library.
     */
    public ArrayList<Playlist> getLibrary() {
        return library;
    }

    /**
     * gets currentlyPlaying.
     * @return currentlyPlaying.
     */
    public Song getCurrentlyPlaying() {
        return currentPlaying;
    }
}