package test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Trees.BinaryTree;
import Trees.Node;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Binääripuun testitiedosto.
 *
 * @author Emmi
 */
public class BinaryTreeTest {

    private BinaryTree bintree;
    private Node apunode;

    public BinaryTreeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        bintree = new BinaryTree();
        bintree.insert(14);
        bintree.insert(17);
        bintree.insert(2);
        bintree.insert(19);
        bintree.insert(15);
        bintree.insert(3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void eiVoiLisätäJosOnJo() {
        int size = bintree.getSize();
        bintree.insert(3);
        int size2 = bintree.getSize();
        assertEquals(size2, size);
    }

    @Test
    public void etsiminenLöytää() {
        apunode = bintree.searchBin(bintree.getRoot(), 14);
        assertEquals(14, apunode.getKey());
    }

    @Test
    public void etsiminenEiLöydä() {
        apunode = bintree.searchBin(bintree.getRoot(), 7);
        assertEquals(null, apunode);
    }

    @Test
    public void lisääminenKasvattaaKokoa() {
        int size = bintree.getSize();
        bintree.insert(5);
        int size2 = bintree.getSize();
        assertEquals(size2, size + 1);
    }

    @Test
    public void poistoPienentääKokoa() {
        int size = bintree.getSize();
        bintree.delete(15);
        int size2 = bintree.getSize();
        assertEquals(size2, size - 1);
    }

    @Test
    public void toisenKaksilapsisenPoistoOnnistuu() {
        int size = bintree.getSize();
        bintree.delete(17);
        int size2 = bintree.getSize();
        System.out.println("--------------\nKaksilapsisen poisto: ");
        bintree.print(bintree.getRoot());
        System.out.println("--------------");
        assertEquals(size2, size - 1);
    }

    @Test
    public void juurenPoistoOnnistuu() {
        int size = bintree.getSize();
        bintree.delete(14);
        int size2 = bintree.getSize();
        System.out.println("--------------\nJuuren poisto: ");
        bintree.print(bintree.getRoot());
        System.out.println("--------------");
        assertEquals(size2, size - 1);
    }

    @Test
    public void lehdenPoistoOnnistuu() {
        int size = bintree.getSize();
        bintree.delete(3);
        int size2 = bintree.getSize();
        System.out.println("--------------\nLehden poisto: ");
        bintree.print(bintree.getRoot());
        System.out.println("--------------");
        assertEquals(size2, size - 1);
    }

    @Test
    public void yksiLapsisenPoistoOnnistuu() {
        int size = bintree.getSize();
        bintree.delete(2);
        int size2 = bintree.getSize();
        System.out.println("--------------\nYksilapsisen poisto: ");
        bintree.print(bintree.getRoot());
        System.out.println("--------------");
        assertEquals(size2, size - 1);
    }
}
