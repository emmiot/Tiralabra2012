package Trees;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Trie trie = new Trie();
        trie.insert(186);
        trie.insert(17);
        trie.insert(18);
        trie.insert(241);
        trie.insert(1);
        trie.insert(965);
        trie.insert(966);
        System.out.println(trie.search(0));
        System.out.println(trie.search(965));
//        SpeedTest speed = new SpeedTest();
//        speed.addValues(10000);
//        speed.testausValmis();
    }
}