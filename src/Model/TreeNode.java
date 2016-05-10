package Model;

import View.Tree;

import javax.swing.tree.DefaultMutableTreeNode;

public class TreeNode {

    private DefaultMutableTreeNode node;
    private String operand;
    private double value;

    public DefaultMutableTreeNode getNode(){
        return node;
    }

    public TreeNode() {
        node = new DefaultMutableTreeNode();
    }

    public TreeNode(Object object) {
        node = new DefaultMutableTreeNode(object);
    }

    public String getOperand() {
        return operand;
    }

    public String setOperand(String operand) {
        this.operand = operand;
        return this.operand;
    }

    public double getValue() {
        return value;
    }

    public double setValue(double value) {
        this.value = value;
        return value;
    }

    public int getChildCount(){
        return node.getChildCount();
    }

    public void add(TreeNode treeNode){
        node.add(treeNode.getNode());
    }
    public void removeAllChildren(){
        node.removeAllChildren();
    }
    public void setUserObject(Object object){
        node.setUserObject(object);
    }
    public Object getUserObject(){
        return node.getUserObject();
    }

    public TreeNode getNextNode()
    {
        node=node.getNextNode();
        return this;
    }

}
