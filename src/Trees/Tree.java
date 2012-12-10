package Trees;

/**
 * Rajapintaluokka, jonka kaikki puut toteuttavat.
 *
 * @author Emmi
 */
public interface Tree {

    public void insert(int value);

    public void delete(int value);

    public boolean search(int value);

    public String getName();
}
