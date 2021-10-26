package com.example.tradeshift.service;

import com.example.tradeshift.model.NodeObject;
import com.example.tradeshift.model.TreeNode;

import java.util.List;

public interface tradeshiftService {

    List<NodeObject> getAllDescendantNodesId(int givenNodeId);
    void changeParent(int givenNodeId, int targetNodeId);
}
