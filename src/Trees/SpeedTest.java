package Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SpeedTest {

    private BinaryTree bintree;
    private AVLTree avltree;
    private Trie trie;
    private PrintWriter pw;
    private File file;
    private Date date;
    private ArrayList<Integer> list;
    private long startTime;
    private long endTime;

    public SpeedTest() throws FileNotFoundException {
        bintree = new BinaryTree();
        avltree = new AVLTree();
        trie = new Trie();
        initPW();
    }

    private void initPW() throws FileNotFoundException {
        date = new Date();
        String filename = "Tulokset - " + date.toString().replace(':', '-') + ".txt";
        file = new File(filename);
        pw = new PrintWriter(file);
    }

    public void initList(int amount) {
        list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
    }

    public void addValues(int amount) {
        initList(amount);
        addAmount(bintree, list);
        addAmount(avltree, list);
        addAmount(trie, list);
    }

    public void deleteValues(int amount) {
        initList(amount);
        deleteAmount(bintree, list);
        deleteAmount(avltree, list);
        deleteAmount(trie, list);
    }

    private void addAmount(Tree tree, ArrayList<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            tree.insert(list.get(i));
        }
        endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        String result = tree.getName() + ": " + list.size() + " alkion lisäämiseen kesti " + resultTime + " millisekuntia.";
        pw.println(result);
    }

    private void deleteAmount(Tree tree, ArrayList<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            tree.delete(list.get(i));
        }
        endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        String result = tree.getName() + ": " + list.size() + " alkion poistamiseen kesti " + resultTime + " millisekuntia.";
        pw.println(result);
    }

    public void testausValmis() {
        pw.close();
    }
}