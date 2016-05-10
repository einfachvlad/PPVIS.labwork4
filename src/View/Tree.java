package View;


import Controller.TreeListener;
import Model.TreeModel;
import Model.TreeNode;

import javax.swing.*;
import java.awt.*;

/**
 * Created by einfach_vlad on 02.05.16.
 */
public class Tree {
    private TreeModel tree;
    TreeNode root;

    public Tree() {
        root = new TreeNode("=");
        tree = new TreeModel(root);
        Dimension dimension = new Dimension(200, 250);

        tree.getTree().setMinimumSize(dimension);
        tree.getTree().addTreeExpansionListener(new TreeListener(tree.getTree()));
    }

    public TreeNode getRoot(){

        return root;
    }
    public TreeModel getTree(){
        return tree;
    }

    public void update(){
        tree.getTree().validate();
        tree.getTree().updateUI();
    }


}
