package Trees;

/**
 * AVL-puun solmu. Sisältää tiedon korkeudestaan.
 *
 * @author Emmi
 */
public class AVLNode {

    private AVLNode left;
    private AVLNode right;
    private AVLNode parent;
    private int key;
    private int height;

    /**
     * Konstruktori. Asettaa kaikki arvot tyhjäksi/nollaksi.
     */
    public AVLNode() {
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }

    /**
     * Kuormitettu konstruktori, joka asettaa halutun arvon avaimeksi, ja muut
     * arvot tyhjäksi/nollaksi.
     *
     * @param key
     */
    public AVLNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.height = 0;
    }

    /**
     * Tarkistaa, onko solmu tasapainossa.
     *
     * @return
     */
    public boolean isBalanced() {
        int heightLeft = left.getHeight();
        int heightRight = right.getHeight();
        if (heightRight > heightLeft + 1 || heightLeft > heightRight + 1) {
            return false;
        }
        else if (heightRight == heightLeft + 1 || heightLeft == heightRight + 1) {
            return true;
        } else {
            return true;
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public AVLNode getParent() {
        return parent;
    }

    public void setParent(AVLNode parent) {
        this.parent = parent;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}