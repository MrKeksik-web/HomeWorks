package AlgorithmsAndData.SixthHomeWorks.TestsBinaryTree;

import AlgorithmsAndData.SixthHomeWorks.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTestGetHead {

    @Test
    public void getHeadTrue() {
        BinaryTree tree = new BinaryTree(5);
        Assert.assertEquals(tree.head,tree.getHead());
    }
}