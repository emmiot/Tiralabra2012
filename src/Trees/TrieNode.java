package Trees;

public class TrieNode {

    private boolean finalNode;
    private int key;
    private TrieNode[] children;
    private TrieNode parent;

    public TrieNode(int value) {
        this.key = value;
        this.children = new TrieNode[10];
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    TrieNode[] getChildren() {
        return this.children;
    }

    public TrieNode getParent() {
        return parent;
    }

    public void setParent(TrieNode parent) {
        this.parent = parent;
    }

    public boolean isFinalNode() {
        return finalNode;
    }

    public void setFinalNode(boolean finalNode) {
        this.finalNode = finalNode;
    }

    public TrieNode getThis() {
        return this;
    }
}