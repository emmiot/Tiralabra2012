package Trees;

/**
 * Trie-puu positiivisten kokonaislukujen tallentamiseen.
 *
 * @author Emmi
 */
public class Trie implements Tree {

    private TrieNode root;
    private String subStr;
    private String number;
    private TrieNode parent;
    private TrieNode node;

    /**
     * Konstruktori. Luo juureen uuden TrieNoden.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Lisää parametrina annetun luvun, jos sitä ei jo ole.
     *
     * @param value Luku, joka halutaan lisätä.
     */
    @Override
    public void insert(int value) {
        number = new Integer(value).toString();
        node = this.root;
        parent = root;
        for (int i = 0; i < number.length(); i++) {
            subStr = number.substring(i, i + 1);
            value = Integer.parseInt(subStr);
            if (!node.has(value)) {
                node.add(value);
            }
            if (i == number.length() - 1) {
                node.getChild(value).setFinalNode(true);
                node.getChild(value).setParent(parent);
                break;
            } else {
                parent = node;
                node = node.getChild(value);
            }
        }
    }

    /**
     * Poistaa halutun arvon jos se löytyy puusta, muuten ei tee mitään.
     *
     * @param value
     */
    @Override
    public void delete(int value) {
        if (search(value)) {
            number = new Integer(value).toString();
            node = this.root;
            int i;
            for (i = 0; i < number.length(); i++) {
                value = Integer.parseInt(number.substring(i, i + 1));
                node = node.getChild(value);
            }
            node.setFinalNode(false);
            while (!hasChildren(node)) {
                if (i == 0) {
                    root.setChild(value, null);
                    break;
                }
                node = node.getParent();
                node.setChild(value, null);
                i--;
                value = Integer.parseInt(number.substring(i, i + 1));
            }
        }
    }

    /**
     * Metodi joka käy läpi TrieNoden lapsitaulukon ja palauttaa tiedon,
     * sisältääkö se lapsia.
     *
     * @param nodes TrieNode, jonka lapset halutaan käydä läpi.
     * @return
     */
    private boolean hasChildren(TrieNode node) {
        for (int i = 0; i < 10; i++) {
            if (node.getChild(i) != null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Hakee puusta, palauttaa joko true (löytyi) tai false (ei löytynyt).
     *
     * @param value Arvo, jota haetaan.
     * @return
     */
    @Override
    public boolean search(int value) {
        number = new Integer(value).toString();
        node = this.root;
        for (int i = 0; i < number.length(); i++) {
            subStr = number.substring(i, i + 1);
            value = Integer.parseInt(subStr);
            if (node.getChild(value) != null) {
                if (i == number.length() - 1) {
                    if (node.isFinalNode()) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    node = node.getChild(value);
                }
            } else {
                return false;
            }
        }
        return false;
    }
    
    public void print(TrieNode node) {
        
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