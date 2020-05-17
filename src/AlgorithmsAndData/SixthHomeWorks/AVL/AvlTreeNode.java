package AlgorithmsAndData.SixthHomeWorks.AVL;


public class AvlTreeNode {
    private int value;
    private AvlTreeNode leftTree;
    private AvlTreeNode rightTree;
    private AvlTreeNode parent;
    private int height;

    public AvlTreeNode(int value) {
        this.value = value;
        this.height = 0;
    }

    public AvlTreeNode(int value,AvlTreeNode parent){
        this.value = value;
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public int bFactor(){
        return (this.getRightTree() == null ? 0 : this.getRightTree().height) - (this.getLeftTree() == null ? 0 : this.getLeftTree().height);
    }

    public int fixHeight(){
        int hl = this.getLeftTree() == null ? 0: this.getLeftTree().fixHeight();
        int hr = this.getRightTree() == null ? 0: this.getRightTree().fixHeight();
        this.height = Math.max(hl,hr) + 1;
        return this.height;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public AvlTreeNode getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(AvlTreeNode leftTree) {
        this.leftTree = leftTree;
    }

    public AvlTreeNode getRightTree() {
        return rightTree;
    }

    public void setRightTree(AvlTreeNode rightTree) {
        this.rightTree = rightTree;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AvlTreeNode getParent() {
        return parent;
    }
}
