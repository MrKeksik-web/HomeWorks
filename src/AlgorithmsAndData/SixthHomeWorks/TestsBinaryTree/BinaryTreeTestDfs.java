package AlgorithmsAndData.SixthHomeWorks.TestsBinaryTree;

import AlgorithmsAndData.SixthHomeWorks.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTestDfs {

    @Test
    public void dfsFalse() {
        BinaryTree tree = new BinaryTree(5);
        tree.add(10);
        tree.add(6);

        boolean expected = true;
        boolean actual = tree.dfs(13);

        Assert.assertNotEquals(expected,actual);
    }

    @Test
    public void dfsTrue() {
        BinaryTree tree = new BinaryTree(5);
        tree.add(10);
        tree.add(6);

        boolean expected = true;
        boolean actual = tree.dfs(10);

        Assert.assertEquals(expected,actual);
    }
}