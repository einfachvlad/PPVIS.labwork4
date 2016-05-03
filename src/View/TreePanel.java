package View;

import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

/**
 * Created by einfach_vlad on 02.05.16.
 */
public class TreePanel {
    private JPanel panel;
    JTree tree;
    DefaultMutableTreeNode root;
    JScrollPane scrollPane;

    public TreePanel(){
        panel=new JPanel();

        root=new DefaultMutableTreeNode("=");
        tree=new JTree(root);

        scrollPane=new JScrollPane(tree);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);


        panel.add(scrollPane);
        Dimension dimension=new Dimension(200,250);
        panel.setMinimumSize(dimension);
        panel.setPreferredSize(dimension);
        panel.setSize(dimension);

        tree.setMinimumSize(dimension);
        tree.setPreferredSize(dimension);
        tree.setSize(dimension);
        tree.expandRow(1);
        tree.scrollRowToVisible(2);


        //tree.setVisibleRowCount(1);
    }

    public  JPanel getPanel(){
        return panel;
    }

    public DefaultMutableTreeNode getRoot(){

        return root;
    }
    public JTree getTree(){
        return tree;
    }

    public void setHeight(int height){
        Dimension dimension=new Dimension(200,height);
        panel.setMinimumSize(dimension);
        panel.setPreferredSize(dimension);
        panel.setSize(dimension);

        tree.setMinimumSize(dimension);
        tree.setPreferredSize(dimension);
        tree.setSize(dimension);
    }
    public void update(){
        tree.validate();
        tree.updateUI();
        panel.validate();
        panel.updateUI();
    }
}
