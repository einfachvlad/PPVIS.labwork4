package Model;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Created by einfach_vlad on 10.05.16.
 */
public class TreeModel {
    JTree tree;

    public TreeModel() {
        tree = new JTree();
    }

    public TreeModel(TreeNode node) {
        tree = new JTree(node.getNode());
    }

    public TreeModel(DefaultMutableTreeNode node) {
        tree = new JTree(node);
    }

    public JTree getTree() {
        return tree;
    }

}
