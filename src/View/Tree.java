package View;


import Controller.TreeListener;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Created by einfach_vlad on 02.05.16.
 */
public class Tree {
    private JTree tree;
    DefaultMutableTreeNode root;

    public Tree() {
        root = new DefaultMutableTreeNode("=");
        tree = new JTree(root);
        Dimension dimension = new Dimension(200, 250);

        tree.setMinimumSize(dimension);
        tree.addTreeExpansionListener(new TreeListener(tree));
    }

    public DefaultMutableTreeNode getRoot(){

        return root;
    }
    public JTree getTree(){
        return tree;
    }

    public void update(){
        tree.validate();
        tree.updateUI();
    }
}
