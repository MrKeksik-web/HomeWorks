package AlgorithmsAndData.SixthHomeWorks.TestsBinaryTree;

import AlgorithmsAndData.SixthHomeWorks.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTestBfs {

    @Test
    public void bfsFalse() {
        BinaryTree tree = new BinaryTree(5);
        tree.add(10);
        tree.add(6);

        boolean expected = true;
        boolean actual = tree.bfs(13);

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void bfsTrue() {
        BinaryTree tree = new BinaryTree(5);
        tree.add(10);
        tree.add(6);

        boolean expected = true;
        boolean actual = tree.bfs(10);

        Assert.assertEquals(expected,actual);
    }
}