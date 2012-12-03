package Trees;

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
    TrieNode[] getChildren() {
        return this.children;
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