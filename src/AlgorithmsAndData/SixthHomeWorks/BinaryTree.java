package AlgorithmsAndData.SixthHomeWorks;

import AlgorithmsAndData.FirstHomeWorks.Queue;

public class BinaryTree {
    public BinaryTreeNode head;
    private int count;

    public BinaryTree(int value) {
        head = new BinaryTreeNode(value);
        count = 0;
    }

    public BinaryTree(BinaryTree tree) {
        count = 0;
        this.head = tree.getHead();
    }

    public void add(int value){
        count++;
        if(head == null) {
            head = new BinaryTreeNode(value);
        } else {
            addTo(head,value);
        }
    }

    private void addTo(BinaryTreeNode node,int value){
        if(value < node.getValue()){
            if(node.getLeftTree() == null){
                node.setLeftTree(new BinaryTreeNode(value));
            } else{
                addTo(node.getLeftTree(),value);
            }
        } else {
            if(node.getRightTree() == null){
                node.setRightTree(new BinaryTreeNode(value));
            } else{
                addTo(node.getRightTree(),value);
            }
        }
    }

    public boolean dfs(int elem){
        return dfSearch(this.getHead(), elem);
    }

    private boolean dfSearch(BinaryTreeNode node,int elem){
        if(node.getValue() == elem) {
            return true;
        } else {
            if (node.getLeftTree() != null) {
                return dfSearch(node.getLeftTree(), elem);
            }
            if (node.getRightTree() != null) {
                return dfSearch(node.getRightTree(), elem);
            }
        }
        return false;
    }

    public boolean bfs(int elem){
        Queue<BinaryTreeNode> queue = new Queue<>(count);
        queue.insert(head);

        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.get();
            if(node.getValue() == elem) {
                return true;
            }
            if(node.getLeftTree() != null){
                queue.insert(node.getLeftTree());
            }
            if(node.getRightTree() != null){
                queue.insert(node.getRightTree());
            }
        }
        return false;
    }

    public BinaryTreeNode getHead() {
        return head;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(5);
        tree.add(18);
        tree.add(29);
        tree.add(15);
        tree.add(14);
        tree.add(13);
        tree.add(21);
        tree.add(27);
        tree.add(19);
        tree.add(20);
        tree.add(4);
        tree.add(1);
        tree.add(3);
        tree.add(2);

        System.out.println(tree.dfs(27));
    }
}
