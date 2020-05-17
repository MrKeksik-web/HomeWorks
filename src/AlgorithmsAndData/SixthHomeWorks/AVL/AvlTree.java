package AlgorithmsAndData.SixthHomeWorks.AVL;

import AlgorithmsAndData.FirstHomeWorks.Queue;
import sun.util.locale.provider.AvailableLanguageTags;

public class AvlTree{
    public AvlTreeNode head;
    private int count;

    public AvlTree(int value){
        this.head = new AvlTreeNode(value);
        count = 0;
    }

    public AvlTree(AvlTreeNode tree) {
        this.head = tree;
        count = 0;
    }

    public void add(int value){
        count++;
        if(head == null) {
            head = new AvlTreeNode(value);
            head = balance(head);
        } else {
            addTo(this.head,value);
            head = balance(head);
        }
    }

    private void addTo(AvlTreeNode node,int value){
        if(value < node.getValue()){
            if(node.getLeftTree() == null){
                node.setLeftTree(new AvlTreeNode(value,node));
                node.getLeftTree().setHeight(0);
            } else{
                addTo(node.getLeftTree(),value);
            }
        } else {
            if(node.getRightTree() == null){
                node.setRightTree(new AvlTreeNode(value,node));
            } else{
                addTo(node.getRightTree(),value);
            }
        }
    }

    private AvlTreeNode balance(AvlTreeNode node){
        node.fixHeight();
        if(node.bFactor() == 2){
            if(node.getRightTree().bFactor() < 0) {
                node.setRightTree(rotateRight(node.getRightTree()));
            }
            return rotateLeft(node);
        }
        if(node.bFactor() == -2){
            if(node.getLeftTree().bFactor() > 0) {
                node.setLeftTree(rotateLeft(node.getLeftTree()));
            }
            return rotateRight(node);
        }
        return node;
    }

    private AvlTreeNode rotateRight(AvlTreeNode node){
        AvlTreeNode subNode = node.getLeftTree();
        node.setLeftTree(subNode.getRightTree());
        subNode.setRightTree(node);
        subNode.fixHeight();
        node.fixHeight();
        return subNode;
    }

    private AvlTreeNode rotateLeft(AvlTreeNode node){
        AvlTreeNode subNode = node.getRightTree();
        node.setRightTree(subNode.getLeftTree());
        subNode.setLeftTree(node);
        subNode.fixHeight();
        node.fixHeight();
        return subNode;
    }

    public void dfs(){
        dfSearch(head);
    }

    private void dfSearch(AvlTreeNode node){
        System.out.println(node.getValue());
        if(node.getLeftTree() != null){
            dfSearch(node.getLeftTree());
        }
        if(node.getRightTree() != null) {
            dfSearch(node.getRightTree());
        }
    }

    public void bfs(){
        Queue<AvlTreeNode> queue = new Queue<>(count);
        queue.insert(head);

        while(!queue.isEmpty()){
            AvlTreeNode node = queue.get();
            System.out.println(node.getValue());
            if(node.getLeftTree() != null){
                queue.insert(node.getLeftTree());
            }
            if(node.getRightTree() != null){
                queue.insert(node.getRightTree());
            }
        }
    }

    private AvlTreeNode findMin(AvlTreeNode node){
        return node.getLeftTree() != null ? findMin(node.getLeftTree()) : node;
    }

    private AvlTreeNode removeMin(AvlTreeNode node){
        if(node.getLeftTree() == null){
            return node.getRightTree();
        }
        node.setLeftTree(removeMin(node.getLeftTree()));
        return balance(node);
    }

    public AvlTree remove(int value){
        this.head = removeNode(this.head,value);
        return this;
    }

    private AvlTreeNode removeNode(AvlTreeNode node,int value){
        if(node == null){
            return null;
        }
        if(value < node.getValue()){
            node.setLeftTree(removeNode(node.getLeftTree(),value));
        } else if(value > node.getValue()){
            node.setRightTree(removeNode(node.getRightTree(),value));
        } else {
            AvlTreeNode leftNode = node.getLeftTree();
            AvlTreeNode rightNode = node.getRightTree();
            if(rightNode == null) {
                return leftNode;
            }
            AvlTreeNode min = findMin(rightNode);
            min.setRightTree(removeMin(rightNode));
            min.setLeftTree(leftNode);
            return balance(min);
        }
        return balance(node);
    }

    public static void main(String[] args) {
        AvlTree tree = new AvlTree(5);

        tree.add(18);
        tree.add(29);
        tree.add(15);
        tree.add(21);
        tree.add(27);
        tree.add(19);
        tree.add(20);
        tree.add(4);
        tree.add(1);

        tree.bfs();

        tree.remove(21);
        tree.remove(20);
        tree.remove(29);
        tree.remove(19);
    }
}

