package Model;

import View.Tree;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {

    private DefaultMutableTreeNode node;
    private String operator;
    private double value;

    public DefaultMutableTreeNode getNode() {
        return node;
    }

    public TreeNode() {
        node = new DefaultMutableTreeNode();
    }

    public TreeNode(Object object) {
        node = new DefaultMutableTreeNode(object);
    }

    public TreeNode(DefaultMutableTreeNode node) {
        this.node = node;
    }

    public String getOperator() {
        return operator;
    }

    public String setOperator(String operand) {
        this.operator = operand;
        return this.operator;
    }

    public double getValue() {
        return value;
    }

    public double setValue(double value) {
        this.value = value;
        return value;
    }

    public int getChildCount() {
        return node.getChildCount();
    }

    public void add(TreeNode treeNode) {
        node.add(treeNode.getNode());
    }

    public void removeAllChildren() {
        node.removeAllChildren();
    }

    public void setUserObject(Object object) {
        node.setUserObject(object);
    }

    public Object getUserObject() {
        return node.getUserObject();
    }

}
