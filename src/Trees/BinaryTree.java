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

    public BinaryTree(int value) {
        this.size = 0;
        this.insert(value);
    }

    /**
     * Lisää halutun alkion.
     */
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else if (search(root, value) != null) {
            System.out.println("Arvo oli jo puussa.");
        } else {
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
     * Poistaa halutun alkion, jos sellainen löytyy puusta, muuten ei tee mitään.
     */
    public void delete(int value) {
        Node node = search(this.root, value);
        if (node != null) {
            if (node.left == null && node.right == null) {
                deleteNoChildren(node);
            } else if (node.left == null || node.right == null) {
                deleteOneChild(node);
            } else {
                deleteTwoChildren(node);
            }
            size --;
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
        }
        else if (node == parent.left) {
            parent.left = null;
        }
        else {
            parent.right = null;
        }
    }

    /**
     * Poisto tapauksessa poistettavalla yksi lapsi.
     *
     * @param node
     */
    private void deleteOneChild(Node node) {
        Node child = new Node();
        if (node.left != null) {
            child = node.getLeft();
        }
        else {
            child = node.getRight();
        }
        Node parent = node.getParent();
        child.setParent(parent);
        if (parent == null) {
            this.root = child;
        }
        if (node == parent.left) {
            parent.setLeft(child);
        }
        if (node == parent.right) {
            parent.setRight(child);
        }
    }

    /**
     * Poisto tapauksessa poistettavalla kaksi lasta.
     *
     * @param node
     */
    private void deleteTwoChildren(Node node) {
        Node follower = min(node.right);
        node.setKey(follower.getKey());
        Node child = follower.right;
        Node parent = follower.parent;
        if (parent.left == follower) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
        if (child != null) {
            child.setParent(parent);
        }
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
        } else {
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
        } else {
            return heightRight + 1;
        }
    }

    /**
     * Palauttaa syötteeksi saadun solmun alipuiden pienimmän arvon.
     *
     * @param node
     * @return
     */
    public Node min(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    /**
     * Palauttaa syötteeksi saadun solmun alipuiden suurimman arvon.
     *
     * @param node
     * @return
     */
    public Node max(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    /**
     * Tulostaa puun alkiot järjestyksessä.
     */
    public void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.getKey());
            print(node.right);
        }
    }

    public Node getRoot() {
        return root;
    }

    /**
     * Sisäjärjestysläpikäynti.
     * @param node 
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.getKey());
            inorder(node.right);
        }
    }

    /**
     * Esijärjestysläpikäynti.
     * @param node 
     */
    public void preorder(Node node) {
        if (node != null) {
            System.out.println(node.getKey());
            preorder(node.left);
            preorder(node.right);
        }
    }

    /**
     * Jälkijärjestysläpikäynti.
     * @param node 
     */
    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.getKey());
        }
    }
    
    public int getSize() {
        return this.size;
    }
}
