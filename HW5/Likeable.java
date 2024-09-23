/**
 * Represents the interface for Likeable.
 * @author Diya Sharma
 * @version 21.0.1
 */

public interface Likeable {
    /**
     * like method.
     */
    void like();
    /**
     * dislike method.
     */
    void dislike();
    /**
     * getLikes method.
     * @return likes.
     */
    int getLikes();
    /**
     * getDislikes method.
     * @return dislikes.
     */
    int getDislikes();
}