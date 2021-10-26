package com.example.tradeshift.service;


import com.example.tradeshift.model.MakeTree;
import com.example.tradeshift.model.NodeObject;
import com.example.tradeshift.model.TreeNode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class tradeshiftServiceImpl implements tradeshiftService {

    private MakeTree makeTree = new MakeTree();

    @Override
    public List<NodeObject> getAllDescendantNodesId(int givenNodeId) {
        TreeNode root= makeTree.getTreeNode();
       TreeNode givenNode=findNode(root,givenNodeId);
        List<TreeNode> result=new ArrayList<>();
        findDescendants(givenNode,result);
        result.remove(0);
        List<NodeObject> listOfNodes = new ArrayList<>();
        for(TreeNode n: result){
            NodeObject nodeObject = new NodeObject();
            nodeObject.setId(n.id);
            nodeObject.setVal(n.val);
            nodeObject.setHeight(n.height);
            nodeObject.setParent(n.parent.id);
            listOfNodes.add(nodeObject);
        }
        List<Integer> returnValue=result.stream().map(ttt->ttt.val).collect(Collectors.toList());
        return listOfNodes;
    }

    @Override
    public void changeParent(int givenNodeId, int targetNodeId) {
        TreeNode root= makeTree.getTreeNode();
        TreeNode srcNode=findNode(root,givenNodeId);
        TreeNode targetNode=findNode(root,targetNodeId);
        srcNode.parent.children.remove(srcNode);
        targetNode.children.add(srcNode);
        srcNode.parent=targetNode;
        makeTree.setTreeNode(root);
        updateHeight(srcNode);
    }

    private TreeNode findNode(TreeNode root, int nodeId) {
        if (root.id == nodeId) {
            return root;
        } else {
            for (TreeNode child: root.children) {
                TreeNode result = findNode(child, nodeId);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    private void findDescendants(TreeNode root, List<TreeNode> descendants) {
        if (root != null) {
            descendants.add(root);
            for ( TreeNode child : root.children) {
                findDescendants(child, descendants);
            }
        }
    }


    private void updateHeight(TreeNode root) {
        if (root != null) {
            root.height= root.parent.height + 1;
            for ( TreeNode child : root.children) {
                updateHeight(child);
            }
        }
    }

}
