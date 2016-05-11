package View;


import Controller.TreeListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.LinkedList;

/**
 * Created by einfach_vlad on 02.05.16.
 */
public class Tree {
    private JTree tree;
    private DefaultMutableTreeNode root;
    private LinkedList<String> expressions;

    public Tree() {
        expressions = new LinkedList<>();

        root = new DefaultMutableTreeNode("=");
        tree = new JTree(root);
        Dimension dimension = new Dimension(200, 250);

        tree.setMinimumSize(dimension);
    }

    public Tree(DefaultMutableTreeNode root) {
        this.root = root;
        tree = new JTree(root);
        Dimension dimension = new Dimension(200, 250);

        tree.setMinimumSize(dimension);
    }

    public void setRoot(DefaultMutableTreeNode node) {
        root = node;
        tree = new JTree(root);
        //DefaultMutableDefaultMutableTreeNode deepRoot = (DefaultMutableDefaultMutableTreeNode)tree.getTree().getModel().getRoot();
        //deepRoot=node.getNode();
    }

    public DefaultMutableTreeNode getRoot() {

        return root;
    }

    public JTree getTree() {
        return tree;
    }

    public LinkedList<String> getExpressions(){
        return expressions;
    }

    public void update() {
        tree.validate();
        tree.updateUI();
    }


}
