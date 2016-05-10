package Controller;

import Model.TreeModel;
import Model.TreeNode;
import View.Tree;

import javax.swing.*;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by einfach_vlad on 10.05.16.
 */
public class TreeListener implements TreeExpansionListener {

    private Tree tree;

    public TreeListener(Tree tree) {
        this.tree = tree;
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent treeExpansionEvent) {

        TreePath path = treeExpansionEvent.getPath();
        DefaultMutableTreeNode defaultMutableTreeNode = (DefaultMutableTreeNode) path.getLastPathComponent();
       /* TreeNode node = new TreeNode(defaultMutableTreeNode);
        node.setUserObject(node.getValue());*/


    }

    @Override
    public void treeExpanded(TreeExpansionEvent treeExpansionEvent) {
        LinkedList<String> list = new LinkedList<>();
        TreePath path = treeExpansionEvent.getPath();
        if (path.getPathCount() != 1) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();

            String stringPath = path.toString().substring(1, path.toString().length() - 1);
            String[] array = stringPath.split(", ");
            for (String string : array)
                list.add(string);

            list.removeFirst();
            TreeNode currentNode = tree.getRoot();
            while (list.size()!=0) {
                Enumeration children = currentNode.getNode().children();
                int index = 0;
                while (children.hasMoreElements()) {
                    if (children.nextElement().toString().equals(list.getFirst())) {
                        list.removeFirst();
                        TreeNode newCurrent=new TreeNode(currentNode.getNode().getChildAt(index));
                        currentNode=newCurrent;
                        break;
                    }
                    index++;
                }
            }
            currentNode.setUserObject(currentNode.getOperator());
        }


        /*TreeNode node = new TreeNode(defaultMutableTreeNode);
        node.setUserObject(node.getOperator());*/

    }
}
