package Trees;

/**
 * Binäärihakupuun solmu.
 *
 * @author Emmi
 */
public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private int key;

    /**
     * Konstruktori. Asettaa vanhemman sekä oikean ja vasemman lapsen tyhjiksi.
     */
    public Node() {
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    /**
     * Konstruktori. Asettaa avaimen arvon halutuksi. Asettaa vanhemman sekä
     * oikean ja vasemman lapsen tyhjiksi.
     */
    public Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}