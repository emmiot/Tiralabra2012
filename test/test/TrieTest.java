/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Trees.Trie;
import Trees.TrieNode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Emmi
 */
public class TrieTest {

    private Trie trie;
    private TrieNode apunode;

    public TrieTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        trie = new Trie();
        trie.insert(186);
        trie.insert(17);
        trie.insert(18);
        trie.insert(241);
        trie.insert(1);
        trie.insert(965);
        trie.insert(966);
        System.out.println(trie.search(0));
        System.out.println(trie.search(965));
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
