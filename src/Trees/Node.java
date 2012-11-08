package Trees;

public class Node {

    Node left;
    Node right;
    Node parent;
    int key;

    /**
     * Konstruktori. Asettaa avaimen arvon halutuksi. Asettaa vanhemman sekä oikean ja vasemman lapsen tyhjiksi.
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