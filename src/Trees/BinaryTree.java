package Trees;

/**
 * Binäärihakupuu.
 *
 * @author Emmi
 */
public class BinaryTree implements Tree {

    private Node root;
    private int size;

    /**
     * Konstruktori. Asettaa puun kokoindikaattorin nollaksi.
     */
    public BinaryTree() {
        this.size = 0;
    }

    /**
     * Kuormitettu konstruktori, jolle voidaan antaa arvo, joka asetetaan
     * juureksi.
     *
     * @param rootValue
     */
    public BinaryTree(int rootValue) {
        this.size = 0;
        this.insert(rootValue);
    }

    /**
     * Lisää halutun alkion ja kasvattaa puun kokoa. Jos alkio on jo puussa, ei
     * tehdä mitään.
     */
    @Override
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else if (searchBin(root, value) != null) {
            System.out.println("Arvo oli jo puussa.");
        } else {
            Node node = root;
            Node parent = null;
            while (node != null) {
                parent = node;
                if (value < node.getKey()) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
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
     * Poistaa halutun alkion, jos sellainen löytyy puusta, muuten ei tee
     * mitään.
     */
    @Override
    public void delete(int value) {
        Node node = searchBin(this.root, value);
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                deleteNoChildren(node);
            } else if (node.getLeft() == null || node.getRight() == null) {
                deleteOneChild(node);
            } else {
                deleteTwoChildren(node);
            }
            size--;
        }
    }

    /**
     * Poisto tapauksessa että poistettavalla ei ole lapsia.
     *
     * @param node
     */
    private void deleteNoChildren(Node node) {
        Node parent = node.getParent();
        if (parent == null) {
            this.root = null;
        } else if (node == parent.getLeft()) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
    }

    /**
     * Poisto tapauksessa poistettavalla yksi lapsi.
     *
     * @param node
     */
    private void deleteOneChild(Node node) {
        Node child;
        if (node.getLeft() != null) {
            child = node.getLeft();
        } else {
            child = node.getRight();
        }
        Node parent = node.getParent();
        if (parent == null) {
            this.root = child;
            child.setParent(null);
        } else {
            child.setParent(parent);
            if (parent.getLeft() != null) {
                if (node == parent.getLeft()) {
                    parent.setLeft(child);
                }
            }
            if (parent.getRight() != null) {
                if (node == parent.getRight()) {
                    parent.setRight(child);
                }
            }
        }
    }

    /**
     * Poisto tapauksessa poistettavalla kaksi lasta.
     *
     * @param node
     */
    private void deleteTwoChildren(Node node) {
        Node follower = min(node.getRight());
        node.setKey(follower.getKey());
        Node child = follower.getRight();
        Node parent = follower.getParent();
        if (parent.getLeft() == follower) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
        if (child != null) {
            child.setParent(parent);
        }
    }

    /**
     * Etsimistoiminto aikatestauskäyttöön. Muuten sama kuin puun itsensä
     * käyttämä searchBin, mutta palauttaa boolean-arvon solmun sijaan, jotta
     * toteuttaa rajapinnan.
     *
     * @param value Arvo, joka halutaan etsiä.
     * @return True tai false.
     */
    @Override
    public boolean search(int value) {
        return booleanSearch(root, value);
    }

    private boolean booleanSearch(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.getKey() == value) {
            return true;
        }
        if (value < node.getKey()) {
            return booleanSearch(node.getLeft(), value);
        } else {
            return booleanSearch(node.getRight(), value);
        }
    }

    /**
     * Etsimistoiminto puun omaan käyttöön. Etsii ja palauttaa halutun alkion,
     * jos sellainen löytyy.
     *
     * @param node Solmu, josta lähdetään etsimään.
     * @param value Arvo, jota halutaan etsiä.
     * @return Node, johon päädyttiin, tai null, jos ei löytynyt.
     */
    public Node searchBin(Node node, int value) {
        if (node == null || node.getKey() == value) {
            return node;
        }
        if (value < node.getKey()) {
            return searchBin(node.getLeft(), value);
        } else {
            return searchBin(node.getRight(), value);
        }
    }

    /**
     * Laskee puun korkeuden, kun annetaan syötteeksi juurisolmu.
     */
    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int heightLeft = getHeight(node.getLeft());
        int heightRight = getHeight(node.getRight());
        if (heightLeft > heightRight) {
            return heightLeft + 1;
        } else {
            return heightRight + 1;
        }
    }

    /**
     * Palauttaa syötteeksi saadun solmun alipuiden pienimmän arvon.
     *
     * @param node
     * @return Syötteeksi saadun solmun alipuiden pienin arvo.
     */
    public Node min(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Palauttaa syötteeksi saadun solmun alipuiden suurimman arvon.
     *
     * @param node
     * @return Syötteeksi saadun solmun alipuiden suurin arvo.
     */
    public Node max(Node node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    /**
     * Tulostaa puun alkiot järjestyksessä.
     */
    public void print(Node node) {
        if (node != null) {
            print(node.getLeft());
            System.out.println(node.getKey());
            print(node.getRight());
        }
    }

    /**
     * Sisäjärjestysläpikäynti.
     *
     * @param node Juuri
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.getLeft());
            System.out.println(node.getKey());
            inorder(node.getRight());
        }
    }

    /**
     * Esijärjestysläpikäynti.
     *
     * @param node Juuri
     */
    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.getKey());
            preorder(node.getLeft());
            preorder(node.getRight());
        }
    }

    /**
     * Jälkijärjestysläpikäynti.
     *
     * @param node Juuri
     */
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.getLeft());
            postorder(node.getRight());
            System.out.println(node.getKey());
        }
    }

    public int getSize() {
        return this.size;
    }

    public Node getRoot() {
        return this.root;
    }

    /**
     * Puun nimi testejä varten.
     *
     * @return Puun nimi testejä varten.
     */
    @Override
    public String getName() {
        return "Binääripuu";
    }
}
