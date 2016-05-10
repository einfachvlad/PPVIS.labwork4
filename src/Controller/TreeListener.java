package Controller;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;

/**
 * Created by einfach_vlad on 10.05.16.
 */
public class TreeListener implements TreeExpansionListener {

    private JTree tree;

    public TreeListener(JTree tree){
        this.tree=tree;
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent treeExpansionEvent) {

        System.out.println(tree.getWidth());
        System.out.println(tree.getHeight());

    }

    @Override
    public void treeExpanded(TreeExpansionEvent treeExpansionEvent) {
        System.out.println(tree.getWidth());
        System.out.println(tree.getHeight());
        TreePath path=treeExpansionEvent.getPath();
        DefaultMutableTreeNode node=(DefaultMutableTreeNode)path.getLastPathComponent();
        //  node.setUserObject("!!!");

    }
}
