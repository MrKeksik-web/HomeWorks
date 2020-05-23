package AlgorithmsAndData.SixthHomeWorks.TestsBinaryTree;

import AlgorithmsAndData.SixthHomeWorks.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTestAdd {

    @Test
    public void add() {
        BinaryTree tree = new BinaryTree(5);
        tree.add(10);
        tree.add(6);

        boolean expected = true;
        boolean actual = tree.bfs(10);

        Assert.assertEquals(expected,actual);
    }
}