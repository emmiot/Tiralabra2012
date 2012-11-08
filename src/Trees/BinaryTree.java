package Trees;

public class BinaryTree {

    Node root;
    int size;

    /**
     * Konstruktori. Asettaa puun kokoindikaattorin nollaksi.
     */
    public BinaryTree() {
        this.size = 0;
    }

    /**
     * Lisää halutun alkion.
     */
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            size++;
        }
        else if (search(root, value) != null) {
            System.out.println("Arvo oli jo puussa.");
        }
        else {
            Node node = root;
            Node parent = null;
            while (node != null) {
                parent = node;
                if (value < node.getKey()) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            Node newNode = new Node(value);
            newNode.setParent(parent);
            if (newNode.getKey() < parent.getKey()) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
            size++;
        }
    }

    /**
     * Poistaa halutun alkion.
     */
    public void delete() {
    }

    /**
     * Etsii ja palauttaa halutun alkion, jos sellainen löytyy.
     */
    public Node search(Node node, int value) {
        if (node == null || node.getKey() == value) {
            return node;
        }
        if (value < node.getKey()) {
            return search(node.left, value);
        }
        else {
            return search(node.right, value);
        }
    }
    
    /**
     * Laskee puun korkeuden, kun annetaan syötteeksi juurisolmu.
     */
    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int heightLeft = getHeight(node.left);
        int heightRight = getHeight(node.right);
        if (heightLeft > heightRight) {
            return heightLeft + 1;
        }
        else {
            return heightRight + 1;
        }
    }
    
    /**
     * Palauttaa syötteeksi saadun solmun alipuiden pienimmän arvon.
     * @param node
     * @return 
     */
    public int min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.getKey();
    }
    
    /**
     * Palauttaa syötteeksi saadun solmun alipuiden suurimman arvon.
     * @param node
     * @return 
     */
    public int max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node.getKey();
    }

    /**
     * Tulostaa puun alkiot järjestyksessä.
     */
    public void print(Node node) {
        if (node == null) {
            print(node.left);
            System.out.println(node.getKey());
            print(node.right);
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
