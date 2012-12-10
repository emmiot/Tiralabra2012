/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Trees.AVLNode;
import Trees.AVLTree;
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
public class AVLTreeTest {
    
    private AVLTree avltree;
    private AVLNode node;

    public AVLTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        avltree = new AVLTree();
        avltree.insert(28);
        avltree.insert(3);
        avltree.insert(12);
        avltree.insert(29);
        avltree.insert(27);
        avltree.insert(32);
        avltree.insert(116);
        avltree.insert(4);
        avltree.insert(0);
        avltree.insert(14);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void etsiminenLöytää() {
        node = avltree.searchAVL(avltree.getRoot(), 14);
        assertEquals(14, node.getKey());
    }
    
    @Test
    public void juuriOnTasapainossa() {
        assertTrue(avltree.getRoot().isBalanced());
    }
    
    @Test
    public void juuriPysyyTasapainossaPoistonYhteydessä() {
        avltree.delete(32);
        avltree.delete(29);
        assertTrue(avltree.getRoot().isBalanced());
    }
}
