package Trees;

public class Trie implements Tree {

    private TrieNode[] children;
    private String subStr;
    private String number;
    private TrieNode parent;
    private TrieNode[] nodes;

    /**
     * Konstruktori. Luo uuden taulukon lapsia varten.
     */
    public Trie() {
        this.children = new TrieNode[10];
    }

    /**
     * Lisää parametrina annetun luvun, jos sitä ei jo ole.
     *
     * @param value Luku, joka halutaan lisätä.
     */
    @Override
    public void insert(int value) {
        number = new Integer(value).toString();
        nodes = this.children;
        parent = null;
        for (int i = 0; i < number.length(); i++) {
            subStr = number.substring(i, i + 1);
            value = Integer.parseInt(subStr);
            if (nodes[value] == null) {
                TrieNode newNode = new TrieNode();
                nodes[value] = newNode;
            }
            if (i == number.length() - 1) {
                nodes[value].setFinalNode(true);
                nodes[value].setParent(parent);
                break;
            } else {
                parent = nodes[value];
                nodes = nodes[value].getChildren();
            }
        }
    }

    @Override
    public void delete(int value) {
        if (search(value)) {
        }
    }

    /**
     * Hakee puusta, palauttaa joko true (löytyi) tai false (ei löytynyt).
     *
     * @param value Arvo, jota haetaan.
     * @return
     */
    public boolean search(int value) {
        number = new Integer(value).toString();
        nodes = this.children;
        for (int i = 0; i < number.length(); i++) {
            subStr = number.substring(i, i + 1);
            value = Integer.parseInt(subStr);
            if (nodes[value] != null) {
                if (i == number.length() - 1) {
                    if (nodes[value].isFinalNode()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    nodes = nodes[value].getChildren();
                }
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Puun nimi testejä varten.
     *
     * @return
     */
    @Override
    public String getName() {
        return "Trie";
    }
}