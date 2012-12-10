/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Trees.Node;
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
        trie.insert(9);
    }

    @After
    public void tearDown() {
    }
    @Test
    public void etsiminenLöytää() {
        assertEquals(true, trie.search(965));
    }
    
    @Test
    public void etsiminenEiLöydä() {
        assertEquals(false, trie.search(96));
    }
    
    @Test
    public void poistoPoistaaOikean() {
        trie.delete(965);
        assertFalse(trie.search(965));
    }
}
