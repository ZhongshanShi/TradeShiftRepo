package com.example.tradeshift.model;


public class MakeTree {

    TreeNode treeNode=makeTree();

    private TreeNode makeTree() {
        TreeNode root = new TreeNode(0,100,null,0);
        TreeNode a = new TreeNode(1,101,null,0);
        TreeNode b = new TreeNode(2,102,null,0);
        TreeNode c = new TreeNode(3,103,null,0);
        TreeNode d = new TreeNode(4,104,null,0);
        TreeNode e = new TreeNode(5,105,null,0);
        //add a as root's child
        root.children.add(a);
        a.parent=root;
        a.height=a.parent.height+1;
        //add b as root's child
        root.children.add(b);
        b.parent=root;
        b.height = b.parent.height + 1;
        //add d as a's child
        d.parent=a;
        d.height= d.parent.height+1;
        a.children.add(d);
        //add e as a's second child
        e.parent=a;
        a.children.add(e);
        e.height=e.parent.height+1;
        //add c as b's child
        b.children.add(c);
        c.parent=b;
        c.height=c.parent.height+1;
        return root;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }
}
