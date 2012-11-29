package Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SpeedTest {

    private BinaryTree btree;
    private AVLTree avltree;
    private Trie trie;
    private PrintWriter pw;
    private File file;
    private Date date;
    private ArrayList<Integer> list;
    private long startTime;
    private long endTime;

    public SpeedTest() throws FileNotFoundException {
        btree = new BinaryTree();
        avltree = new AVLTree();
//        trie = new Trie();
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
        addBinary(list);
        addAVL(list);
//        addTrie(list);
    }

    private void addBinary(ArrayList<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            btree.insert(list.get(i));
        }
        endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        String result = "Binääripuulla kesti " + list.size() + " alkion lisäämiseen " + resultTime + " millisekuntia.";
        pw.println(result);
    }

    private void addAVL(ArrayList<Integer> list) {
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            avltree.insert(list.get(i));
        }
        endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        String result = "AVL-puulla kesti " + list.size() + " alkion lisäämiseen " + resultTime + " millisekuntia.";
        pw.println(result);
    }
    
//    private void addTrie(ArrayList<Integer> list) {
//        long startTime = System.currentTimeMillis();
//        for (int i = 0; i < list.size(); i++) {
//            trie.insert(list.get(i));
//        }
//        long finishTime = System.currentTimeMillis();
//        long resultTime = finishTime - startTime;
//        String result = "Triellä kesti " + list.size() + " alkion lisäämiseen " + resultTime + " millisekuntia.";
//        pw.print(result);
//    }

    public void testausValmis() {
        pw.close();
    }

    
}