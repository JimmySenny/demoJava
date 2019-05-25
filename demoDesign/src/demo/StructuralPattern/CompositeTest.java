package demo.StructuralPattern;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 组合模式有时又叫部分-整体模式
 */

class TreeNode{
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<TreeNode>();

    public TreeNode(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void add(TreeNode node){
        children.add(node);
    }

    public void remove(TreeNode node){
        children.remove(node);
    }

    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }
}

public class CompositeTest {
    TreeNode root = null;
    public CompositeTest(String name){
        this.root = new TreeNode(name);
    }

    public static void main(String[] args) {
        CompositeTest tree = new CompositeTest("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");

        nodeB.add(nodeC);
        tree.root.add(nodeB);

        Enumeration<TreeNode> enu = tree.root.getChildren();
        while (enu.hasMoreElements()){
            String name = enu.nextElement().getName();
            System.out.println(name);
        }
    }
}
