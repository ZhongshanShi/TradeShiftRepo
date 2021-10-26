package com.example.tradeshift.model;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int id;
    public int val;
    public TreeNode parent;
    public List<TreeNode> children=new ArrayList<>();
    public int height;


    public TreeNode(int id, int val, TreeNode parent, int height) {
        this.id=id;
        this.val=val;
        this.parent=parent;
        this.height=height;
    };
}
