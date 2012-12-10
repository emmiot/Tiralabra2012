package Trees;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Aikatestauksen toteuttava luokka.
 *
 * @author Emmi
 */
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

    /**
     * Konstruktori. Luo puut ja kutsuu metodia initPW().
     *
     * @throws FileNotFoundException
     */
    public SpeedTest() throws FileNotFoundException {
        bintree = new BinaryTree();
        avltree = new AVLTree();
        trie = new Trie();
        initPW();
    }

    /**
     * Luo PrintWriter-olion ja tiedoston, jonne testitulokset tallennetaan.
     *
     * @throws FileNotFoundException
     */
    private void initPW() throws FileNotFoundException {
        date = new Date();
        String filename = "Tulokset - " + date.toString().replace(':', '-') + ".txt";
        file = new File(filename);
        pw = new PrintWriter(file);
    }

    /**
     * Luo listan, jossa haluttu määrä alkioita satunnaisessa järjestyksessä.
     *
     * @param amount
     */
    public void initList(int amount) {
        list = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
    }

    /**
     * Luo ensin halutunkokoisen listan, ja kutsuu sen jälkeen test()-metodia
     * kaikille puille parametrilla "lisääminen".
     *
     * @param amount
     */
    public void addValues(int amount) {
        initList(amount);
        test(bintree, "lisääminen", list);
        test(avltree, "lisääminen", list);
        test(trie, "lisääminen", list);
        pw.println("----------------");
    }

    /**
     * Luo ensin halutunkokoisen listan, ja kutsuu sen jälkeen test()-metodia
     * kaikille puille parametrilla "poistaminen".
     *
     * @param amount
     */
    public void deleteValues(int amount) {
        initList(amount);
        test(bintree, "poistaminen", list);
        test(avltree, "poistaminen", list);
        test(trie, "poistaminen", list);
        pw.println("----------------");
    }

    /**
     * Luo ensin halutunkokoisen listan, ja kutsuu sen jälkeen test()-metodia
     * kaikille puille parametrilla "hakeminen".
     *
     * @param amount
     */
    public void searchValues(int amount) {
        initList(amount);
        test(bintree, "hakeminen", list);
        test(avltree, "hakeminen", list);
        test(trie, "hakeminen", list);
        pw.println("----------------");
    }

    /**
     * Suorittaa halutun operaation, laskee siihen kuluneen ajan millisekunteina
     * ja tulostaa tuloksen tiedostoon.
     *
     * @param tree Puu, jolle operaatio tehdään.
     * @param operation Halutun operaation nimi.
     * @param list Lista, jonka alkioilla suoritetaan haluttu operaatio.
     */
    private void test(Tree tree, String operation, ArrayList<Integer> list) {
        startTime = System.currentTimeMillis();
        switch (operation) {
            case "lisääminen":
                for (int i = 0; i < list.size(); i++) {
                    tree.insert(list.get(i));
                }
                break;
            case "poistaminen":
                for (int i = 0; i < list.size(); i++) {
                    tree.delete(list.get(i));
                }
                break;
            case "hakeminen":
                for (int i = 0; i < list.size(); i++) {
                    tree.search(list.get(i));
                }
                break;
        }
        endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        String result = tree.getName() + ": " + list.size() + " alkion " + operation + " kesti " + resultTime + " millisekuntia.";
        pw.println(result);
    }

    /**
     * Metodi, jota kutsutaan testauksen päätyttyä. Sulkee tiedoston.
     */
    public void testausValmis() {
        pw.close();
    }
}