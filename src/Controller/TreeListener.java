package Controller;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
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
        //tree.setPreferredSize(new Dimension(tree.getWidth(),tree.getHeight()));

    }

    @Override
    public void treeExpanded(TreeExpansionEvent treeExpansionEvent) {
        //tree.setPreferredSize(new Dimension(tree.getWidth(),tree.getHeight()));
        System.out.println(tree.getWidth());
        System.out.println(tree.getHeight());

    }
}
