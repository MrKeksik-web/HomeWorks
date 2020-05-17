package AlgorithmsAndData.SixthHomeWorks;

import AlgorithmsAndData.FirstHomeWorks.Queue;

import java.util.Comparator;
import java.util.Stack;

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

    public void dfs(){
        dfSearch(this.getHead());
    }

    private void dfSearch(BinaryTreeNode node){
        System.out.println(node.getValue());
        if(node.getLeftTree() != null){
            dfSearch(node.getLeftTree());
        }
        if(node.getRightTree() != null) {
            dfSearch(node.getRightTree());
        }
    }

    public void bfs(){
        Queue<BinaryTreeNode> queue = new Queue<>(count);
        queue.insert(head);

        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.get();
            System.out.println(node.getValue());
            if(node.getLeftTree() != null){
                queue.insert(node.getLeftTree());
            }
            if(node.getRightTree() != null){
                queue.insert(node.getRightTree());
            }
        }
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

        tree.bfs();
    }
}
