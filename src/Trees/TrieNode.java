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

    /**
     * Konstruktori. Luo lapsitaulukon.
     *
     * @param value
     */
    public TrieNode() {
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
        TrieNode node = new TrieNode();
        children[index] = node;
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
}