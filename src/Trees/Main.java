package Trees;

public class Main {

    public static void main(String[] args) {
        BinaryTree bintree = new BinaryTree();
        bintree.insert(14);
        bintree.insert(17);
        bintree.insert(2);
        bintree.insert(19);
        bintree.insert(15);
        bintree.insert(3);
        bintree.insert(3);
        bintree.print(bintree.getRoot());
        Node apunode = bintree.search(bintree.getRoot(), 14);
        if (apunode != null) {
            System.out.println("Löytyi!");
        }
        else {
            System.out.println("Ei löytynyt.");
        }
    }
}