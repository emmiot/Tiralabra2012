package Trees;

public class AVLTree {

    private AVLNode root;
    private int size;

    /**
     * Konstruktori. Asettaa puun koon nollaksi.
     */
    public AVLTree() {
        this.size = 0;
    }

    /**
     * Kuormitettu konstruktori, jossa voi asettaa halutun arvon juureksi.
     *
     * @param rootValue Arvo joka halutaan juureksi.
     */
    public AVLTree(int rootValue) {
        this.size = 0;
        insert(rootValue);
    }

    /**
     * Puuhun lisätään käyttämällä tätä operaatiota.
     *
     * @param value Arvo joka halutaan lisätä.
     */
    public void insert(int value) {
        AVLNode newNode = avlInsert(value);
        AVLNode p = newNode.getParent();
        AVLNode parent;
        AVLNode subtree;
        while (p != null) {
            if (height(p.getLeft()) == height(p.getRight()) + 2) {
                parent = p.getParent();
                if (height(p.getLeft().getLeft()) > height(p.getLeft().getRight())) {
                    subtree = rightRotate(p);
                } else {
                    subtree = leftRightRotate(p);
                }
                if (parent == null) {
                    this.root = subtree;
                } else if (parent.getLeft() == p) {
                    parent.setLeft(subtree);
                } else {
                    parent.setRight(subtree);
                }
                if (parent != null) {
                    parent.setHeight(Math.max(height(parent.getLeft()), height(parent.getRight())) + 1);
                }
                break;
            }
            if (height(p.getRight()) == height(p.getLeft()) + 2) {
                parent = p.getParent();
                if (height(p.getRight().getRight()) > height(p.getRight().getLeft())) {
                    subtree = leftRotate(p);
                } else {
                    subtree = rightLeftRotate(p);
                }
                if (parent == null) {
                    this.root = subtree;
                } else if (parent.getLeft() == p) {
                    parent.setLeft(subtree);
                } else {
                    parent.setRight(subtree);
                }
                if (parent != null) {
                    parent.setHeight(Math.max(height(parent.getLeft()), height(parent.getRight())) + 1);
                }
                break;
            }
            p.setHeight(Math.max(height(p.getLeft()), height(p.getRight())) + 1);
            p = p.getParent();
        }
    }

    /**
     * AVL-insertin apumetodi, jossa varsinainen lisäys tapahtuu.
     *
     * @param value
     */
    private AVLNode avlInsert(int value) {
        if (root == null) {
            root = new AVLNode(value);
            size++;
            return root;
        } else if (search(root, value) != null) {
            System.out.println("Arvo oli jo puussa.");
            return null;
        } else {
            AVLNode node = root;
            AVLNode parent = null;
            while (node != null) {
                parent = node;
                if (value < node.getKey()) {
                    node = node.getLeft();
                } else {
                    node = node.getRight();
                }
            }
            AVLNode newNode = new AVLNode(value);
            newNode.setParent(parent);
            if (newNode.getKey() < parent.getKey()) {
                parent.setLeft(newNode);
            } else {
                parent.setRight(newNode);
            }
            size++;
            return newNode;
        }
    }

    /**
     * Poistaa halutun alkion, jos sellainen löytyy puusta, muuten ei tee
     * mitään.
     *
     * @param value Poistettava arvo.
     */
    public void delete(int value) {
        AVLNode node = avlDelete(value);
        AVLNode p = node.getParent();
        AVLNode parent = null;
        AVLNode subtree;
        while (p != null) {
            if (height(p.getLeft()) == height(p.getRight()) + 2 || height(p.getRight()) == height(p.getLeft()) + 2) {
                if (height(p.getLeft()) == height(p.getRight()) + 2) {
                    parent = p.getParent();
                    if (height(p.getLeft().getLeft()) > height(p.getLeft().getRight())) {
                        subtree = rightRotate(p);
                    } else {
                        subtree = leftRightRotate(p);
                    }
                } else {
                    parent = p.getParent();
                    if (height(p.getRight().getRight()) > height(p.getRight().getLeft())) {
                        subtree = leftRotate(p);
                    } else {
                        subtree = rightLeftRotate(p);
                    }
                }
                if (p == this.root) {
                    this.root = subtree;
                    break;
                }
                if (parent.getLeft() == p) {
                    parent.setLeft(subtree);
                } else {
                    parent.setRight(subtree);
                }
                p = p.getParent();
            } else {
                p.setHeight(Math.max(height(p.getLeft()), height(p.getRight())) + 1);
                p = p.getParent();
            }
        }
    }

    /**
     * avlDeleten apumetodi, joka suorittaa varsinaisen poiston.
     */
    private AVLNode avlDelete(int value) {
        AVLNode node = search(this.root, value);
        if (node != null) {
            if (node.getLeft() == null && node.getRight() == null) {
                node = deleteNoChildren(node);
            } else if (node.getLeft() == null || node.getRight() == null) {
                node = deleteOneChild(node);
            } else {
                node = deleteTwoChildren(node);
            }
            size--;
        }
        return node;
    }

    /**
     * Poisto tapauksessa että poistettavalla ei ole lapsia.
     *
     * @param node
     */
    private AVLNode deleteNoChildren(AVLNode node) {
        AVLNode parent = node.getParent();
        if (parent == null) {
            this.root = null;
        } else if (node == parent.getLeft()) {
            parent.setLeft(null);
        } else {
            parent.setRight(null);
        }
        return node;
    }

    /**
     * Poisto tapauksessa poistettavalla yksi lapsi.
     *
     * @param node
     */
    private AVLNode deleteOneChild(AVLNode node) {
        AVLNode child;
        if (node.getLeft() != null) {
            child = node.getLeft();
        } else {
            child = node.getRight();
        }
        AVLNode parent = node.getParent();
        child.setParent(parent);
        if (parent == null) {
            this.root = child;
            return node;
        }
        if (node == parent.getLeft()) {
            parent.setLeft(child);
        }
        if (node == parent.getRight()) {
            parent.setRight(child);
        }
        return node;
    }

    /**
     * Poisto tapauksessa poistettavalla kaksi lasta.
     *
     * @param node
     */
    private AVLNode deleteTwoChildren(AVLNode node) {
        AVLNode follower = min(node.getRight());
        node.setKey(follower.getKey());
        AVLNode child = follower.getRight();
        AVLNode parent = follower.getParent();
        if (parent.getLeft() == follower) {
            parent.setLeft(child);
        } else {
            parent.setRight(child);
        }
        if (child != null) {
            child.setParent(parent);
        }
        return follower;
    }

    /**
     * Palauttaa syötteeksi saadun solmun alipuiden pienimmän arvon.
     *
     * @param node
     * @return
     */
    public AVLNode min(AVLNode node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    /**
     * Palauttaa syötteeksi saadun solmun alipuiden suurimman arvon.
     *
     * @param node
     * @return
     */
    public AVLNode max(AVLNode node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    /**
     * Kertoo annetun solmun korkeuden.
     *
     * @param node
     * @return
     */
    public int height(AVLNode node) {
        if (node == null) {
            return -1;
        } else {
            return node.getHeight();
        }
    }

    /**
     * Kierto vasemmalle.
     *
     * @param n1 Solmu, joka kierretään.
     * @return
     */
    public AVLNode leftRotate(AVLNode n1) {
        AVLNode n2 = n1.getRight();
        n2.setParent(n1.getParent());
        n1.setParent(n2);
        n1.setRight(n2.getLeft());
        n2.setLeft(n1);
        if (n1.getRight() != null) {
            n1.getRight().setParent(n1);
        }
        n1.setHeight(Math.max(height(n1.getLeft()), height(n1.getRight())));
        n2.setHeight(Math.max(height(n2.getLeft()), height(n2.getRight())));
        return n2;
    }

    /**
     * Kierto oikealle.
     *
     * @param n1 Solmu, joka kierretään.
     * @return
     */
    public AVLNode rightRotate(AVLNode n1) {
        AVLNode n2 = n1.getLeft();
        n2.setParent(n1.getParent());
        n1.setParent(n2);
        n1.setLeft(n2.getRight());
        n2.setRight(n1);
        if (n1.getLeft() != null) {
            n1.getLeft().setParent(n1);
        }
        n1.setHeight(Math.max(height(n1.getLeft()), height(n1.getRight())));
        n2.setHeight(Math.max(height(n2.getLeft()), height(n2.getRight())));
        return n2;
    }

    public AVLNode rightLeftRotate(AVLNode n1) {
        AVLNode n2 = n1.getRight();
        n1.setRight(rightRotate(n2));
        return leftRotate(n1);
    }

    public AVLNode leftRightRotate(AVLNode n1) {
        AVLNode n2 = n1.getLeft();
        n1.setLeft(leftRotate(n2));
        return rightRotate(n1);
    }

    public AVLNode search(AVLNode node, int value) {
        if (node == null || node.getKey() == value) {
            return node;
        }
        if (value < node.getKey()) {
            return search(node.getLeft(), value);
        } else {
            return search(node.getRight(), value);
        }
    }
}