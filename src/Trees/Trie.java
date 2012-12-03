package Trees;

public class Trie implements Tree {

    private TrieNode[] children;
    private String subStr;
    private String number;
    private TrieNode parent;
    private TrieNode[] nodes;

    public Trie() {
        this.children = new TrieNode[10];
    }

    @Override
    public void insert(int value) {
        number = new Integer(value).toString();
        nodes = this.children;
        parent = null;
        for (int i = 0; i < number.length(); i++) {
            subStr = number.substring(i, i + 1);
            value = Integer.parseInt(subStr);
            if (nodes[value - 1] == null) {
                TrieNode newNode = new TrieNode(value);
                nodes[value - 1] = newNode;
            }
            if (i == number.length() - 1) {
                nodes[value - 1].setFinalNode(true);
                nodes[value - 1].setParent(parent);
                break;
            } else {
                parent = nodes[value - 1];
                nodes = nodes[value - 1].getChildren();
            }
        }
    }

    @Override
    public void delete(int value) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean search(int value) {
        number = new Integer(value).toString();
        nodes = this.children;
        for (int i = 0; i < number.length(); i++) {
            subStr = number.substring(i, i + 1);
            value = Integer.parseInt(subStr);
            if (i == number.length() - 1) {
                if (nodes[value - 1].isFinalNode()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                nodes = nodes[value - 1].getChildren();
            }
        }
        return false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    @Override
    public String getName() {
        return "Trie";
    }
}