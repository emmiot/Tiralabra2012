package Trees;

/**
 * Trie-puun solmu.
 *
 * @author Emmi
 */
public class TrieNode {

    private boolean finalNode;
    private TrieNode[] children;
    private TrieNode parent;
    private int key;

    /**
     * Konstruktori. Luo lapsitaulukon.
     *
     * @param value
     */
    public TrieNode() {
        this.children = new TrieNode[10];
    }

    /**
     * Kuormitettu konstruktori, joka lisää myös avaimelle arvon.
     *
     * @param value
     */
    public TrieNode(int value) {
        this.key = value;
        this.children = new TrieNode[10];
    }

    /**
     * Palauttaa viitteen lapsitaulukkoon.
     *
     * @return
     */
    public TrieNode[] getChildren() {
        return this.children;
    }

    /**
     * Tarkistaa, löytyykö haluttu arvo solmun lapsista.
     *
     * @param value
     * @return
     */
    public boolean has(int value) {
        if (children[value] != null) {
            return true;
        }
        return false;
    }

    public void add(int index) {
        TrieNode node = new TrieNode(index);
        this.children[index] = node;
    }

    public TrieNode getChild(int index) {
        return children[index];
    }

    public void setChild(int index, TrieNode node) {
        children[index] = node;
    }

    public TrieNode getParent() {
        return parent;
    }

    public void setParent(TrieNode parent) {
        this.parent = parent;
    }

    /**
     * Tarkistaa, onko päätössolmu, eli päättyykö jokin luku tähän solmuun.
     *
     * @return
     */
    public boolean isFinalNode() {
        return finalNode;
    }

    public void setFinalNode(boolean finalNode) {
        this.finalNode = finalNode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void print() {
        System.out.println("Tämän solmun avain on: " + this.key);
        System.out.println("Tämän solmun vanhempi on: " + this.parent.getKey());
        System.out.println("Tämän solmun lapset ovat: ");
        for (int i = 0; i < children.length; i++) {
            if (children[i] == null) {
                System.out.println("null");
            } else {
                System.out.println(children[i].getKey());
            }
        }
    }
}