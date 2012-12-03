package Trees;

public class Trie implements Tree {

    private TrieNode[] children;
    private String subStr;
    private String number;
    private TrieNode parent;

    public Trie() {
        this.children = new TrieNode[10];
    }

    @Override
    public void insert(int value) {
        number = new Integer(value).toString();
        TrieNode[] nodes = this.children;
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
                break;
            } else {
                nodes = nodes[value - 1].getChildren();
            }
        }
    }

    @Override
    public void delete(int value) {
        throw new UnsupportedOperationException("Not supported yet.");
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