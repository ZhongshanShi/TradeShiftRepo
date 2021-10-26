package com.example.tradeshift.controller;

import com.example.tradeshift.model.NodeObject;
import com.example.tradeshift.model.TreeNode;
import com.example.tradeshift.model.ResponseMessage;
import com.example.tradeshift.service.tradeshiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tradeshift")
public class tradeshiftController {

    @Autowired
    private tradeshiftService tradeshiftService;

    @GetMapping("/healthCheck")
    public ResponseEntity<ResponseMessage> healthCheck(){
        String message = "healthcheck successful";
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(200,message));
    }

    @RequestMapping("/getDescendantNodesId")
    public ResponseEntity<List<NodeObject>> findDescendants(@RequestParam("givenNodeId") int givenNodeId){
        try{
            List<NodeObject> result = tradeshiftService.getAllDescendantNodesId(givenNodeId);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/changeParent")
    public ResponseEntity<ResponseMessage> changeParent(@RequestParam("givenNodeId") int givenNodeId, @RequestParam("targetNodeId") int targetNodeId){
        try{
            tradeshiftService.changeParent(givenNodeId,targetNodeId);
            String message="parent node changed successfully!";
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(200,message));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseMessage(500,"ERROR COORRUED!"));
        }
    }}
