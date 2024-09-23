/**
 * Music Player driver class.
 * @author Diya Sharma
 * @version 21.0.1
 */
public class MusicPlayer {
    /**
     * driver method.
     * @param args args.
     */
    public static void main(String[] args) {
        User user1 = new User("dsharma333");
        User user2 = new User("srh7");
        user1.createPlaylist("user1_playlist1", 0);
        user1.createPlaylist("user1_playlist2", 0);
        user2.createPlaylist("user2_playlist1", 0);

        user1.getPlaylist("user1_playlist1").addSong(new Song("Song1", 0));
        user1.getPlaylist("user1_playlist1").addSong(new Song("Song2", 0));
        user1.getPlaylist("user1_playlist1").addSong(new Song("Song3", 0));
        user1.getPlaylist("user1_playlist2").addSong(new Song("Song1", 0));
        user1.getPlaylist("user1_playlist2").addSong(new Song("Song2", 0));
        user1.getPlaylist("user1_playlist2").addSong(new Song("Song3", 0));

        user2.getPlaylist("user2_playlist1").addSong(new Song("Song1", 0));
        user2.getPlaylist("user2_playlist1").addSong(new Song("Song2", 0));
        user2.getPlaylist("user2_playlist1").addSong(new Song("Song3", 0));

        user1.getPlaylist("user1_playlist1").dislike();
        user1.getPlaylist("user1_playlist2").like();
        user1.getPlaylist("user1_playlist1").getSongs().get(0).dislike();
        user1.getPlaylist("user1_playlist1").getSongs().get(1).like();
        for (int i = 0; i < user1.getPlaylist("user1_playlist1").getSongs().size(); i++) {
            System.out.println(user1.getPlaylist("user1_playlist1").getSongs().get(i).getTitle());
        }
        Song[] topAndWorst = user1.getPlaylist("user1_playlist1").topAndWorstSong();
        System.out.println("Top Song: " + topAndWorst[0]);
        System.out.println("Worst Song: " + topAndWorst[1]);
        user1.sharePlaylist(user2, 1);
        System.out.println(user2.getPlaylist(user1.getLibrary().get(1).getTitle()).getTitle() + " shared!");
        System.out.println(user1.getPlaylist("user1_playlist1").toString());
        System.out.println(user1.getPlaylist("user1_playlist1").getSongs().get(0).toString());
        Song newSong = new Song("newSong", 2);
        user2.getPlaylist("user2_playlist1").addSong(newSong);
        boolean songReplaced = user2.getPlaylist("user2_playlist1").removeSong(newSong);
        System.out.println(songReplaced);
        user2.playSong(newSong);
        System.out.println(user2.toString());
        user2.pauseSong();
        System.out.println(user2.toString());
        user2.removePlaylist("Liked");
        user2.removePlaylist("user2_playlist1");
        user2.removePlaylist(user2.getPlaylist(user1.getLibrary().get(1).getTitle()).getTitle());
        for (int i = 0; i < user2.getLibrary().size(); i++) {
            System.out.println(user2.getLibrary().get(i).getTitle());
        }
    }
}