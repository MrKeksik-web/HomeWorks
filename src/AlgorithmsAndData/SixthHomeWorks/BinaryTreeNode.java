package AlgorithmsAndData.SixthHomeWorks;

public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode leftTree;
    private BinaryTreeNode rightTree;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(BinaryTreeNode leftTree) {
        this.leftTree = leftTree;
    }

    public BinaryTreeNode getRightTree() {
        return rightTree;
    }

    public void setRightTree(BinaryTreeNode rightTree) {
        this.rightTree = rightTree;
    }
}
