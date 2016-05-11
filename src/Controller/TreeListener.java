package Controller;

import View.CalculatorParts.Screen;
import View.Tree;

import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;
import java.util.LinkedList;


/**
 * Created by einfach_vlad on 10.05.16.
 */
public class TreeListener implements TreeExpansionListener {

    private Tree tree;
    private Screen screen;
    LinkedList<String> minus;
    LinkedList<String> division;
    LinkedList<String> mod;
    private int index;

    public final static String SECOND = "second";
    public final static String FIRST = "first";

    public TreeListener(Tree tree, Screen screen) {
        this.tree = tree;
        this.screen = screen;

        minus = new LinkedList<>();
        division = new LinkedList<>();
        mod = new LinkedList<>();

        index = 0;
    }

    @Override
    public void treeCollapsed(TreeExpansionEvent treeExpansionEvent) {
        TreePath path = treeExpansionEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        if (node.getChildCount() == 1) {
            DefaultMutableTreeNode firstOperand = node.getNextNode();
            if (node.getUserObject().toString().equals("1/x")) {
                node.setUserObject(String.valueOf(1 / Double.parseDouble(firstOperand.toString())));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("sqrt")) {
                node.setUserObject(String.valueOf(Math.sqrt(Double.parseDouble(firstOperand.toString()))));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("sin")) {
                node.setUserObject(String.valueOf(Math.sin(Double.parseDouble(firstOperand.toString()))));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("cos")) {
                node.setUserObject(String.valueOf(Math.cos(Double.parseDouble(firstOperand.toString()))));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("tan")) {
                node.setUserObject(String.valueOf(Math.tan(Double.parseDouble(firstOperand.toString()))));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("sinh")) {
                node.setUserObject(String.valueOf(Math.sinh(Double.parseDouble(firstOperand.toString()))));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("cosh")) {
                node.setUserObject(String.valueOf(Math.cosh(Double.parseDouble(firstOperand.toString()))));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("tanh")) {
                node.setUserObject(String.valueOf(Math.tanh(Double.parseDouble(firstOperand.toString()))));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            }

        } else {
            DefaultMutableTreeNode firstOperand = node.getNextNode();
            DefaultMutableTreeNode secondOperand = firstOperand.getNextSibling();

            if (node.getUserObject().toString().equals("+")) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) + Double.parseDouble(secondOperand.toString()));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("+")) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) + Double.parseDouble(secondOperand.toString()));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("-") && minus.getLast() == TreeListener.FIRST) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) - Double.parseDouble(secondOperand.toString()));
                minus.removeLast();
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("-") && minus.getLast() == TreeListener.SECOND) {
                node.setUserObject(Double.parseDouble(secondOperand.toString()) - Double.parseDouble(firstOperand.toString()));
                minus.removeLast();
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("/") && division.getLast() == TreeListener.FIRST) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) / Double.parseDouble(secondOperand.toString()));
                division.removeLast();
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("/") && division.getLast() == TreeListener.SECOND) {
                node.setUserObject(Double.parseDouble(secondOperand.toString()) / Double.parseDouble(firstOperand.toString()));
                division.removeLast();
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("*")) {
                node.setUserObject((Double.parseDouble(secondOperand.toString()) * Double.parseDouble(firstOperand.toString())));
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("%") && mod.getLast() == TreeListener.FIRST) {
                node.setUserObject(Double.parseDouble(firstOperand.toString()) % Double.parseDouble(secondOperand.toString()));
                mod.removeLast();
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            } else if (node.getUserObject().toString().equals("%") && mod.getLast() == TreeListener.SECOND) {
                node.setUserObject(Double.parseDouble(secondOperand.toString()) % Double.parseDouble(firstOperand.toString()));
                mod.removeLast();
                index++;
                screen.getScreen().setText(tree.getExpressions().get(index));
            }
        }

    }

    @Override
    public void treeExpanded(TreeExpansionEvent treeExpansionEvent) {
        if (index == 0)
            index = tree.getExpressions().size() - 1;
        TreePath path = treeExpansionEvent.getPath();
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
        if (path.getPathCount() != 1) {
            if (node.getChildCount() == 1) {
                DefaultMutableTreeNode firstOperand = node.getNextNode();
                if ((1 / Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("1/x");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Math.sqrt(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("sqrt");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Math.sin(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("sin");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Math.cos(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("cos");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Math.tan(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("tan");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Math.sinh(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("sinh");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Math.cosh(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("cosh");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Math.tanh(Double.parseDouble(firstOperand.toString())) == Double.parseDouble(node.toString())) {
                    node.setUserObject("tanh");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                }
            } else {
                DefaultMutableTreeNode firstOperand = node.getNextNode();
                DefaultMutableTreeNode secondOperand = firstOperand.getNextSibling();

                if (Double.parseDouble(firstOperand.toString()) + Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("+");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) * Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("*");
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) % Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("%");
                    mod.add(TreeListener.FIRST);
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Double.parseDouble(secondOperand.toString()) % Double.parseDouble(firstOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("%");
                    mod.add(TreeListener.SECOND);
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Double.parseDouble(secondOperand.toString()) - Double.parseDouble(firstOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("-");
                    minus.add(TreeListener.SECOND);
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) - Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("-");
                    minus.add(TreeListener.FIRST);
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Double.parseDouble(firstOperand.toString()) / Double.parseDouble(secondOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("/");
                    division.add(TreeListener.FIRST);
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                } else if (Double.parseDouble(secondOperand.toString()) / Double.parseDouble(firstOperand.toString()) == Double.parseDouble(node.toString())) {
                    node.setUserObject("/");
                    division.add(TreeListener.SECOND);
                    index--;
                    screen.getScreen().setText(tree.getExpressions().get(index));
                }
            }
        }

    }
}
