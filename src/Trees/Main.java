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
        TrieNode[] children = trie.getChildren();
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(children[j]);
            }
        }
//        SpeedTest speed = new SpeedTest();
//        speed.addValues(10000);
//        speed.testausValmis();
    }
}