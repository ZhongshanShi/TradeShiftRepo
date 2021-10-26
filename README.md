# TradeShiftRepo
 TradeShift
This is a demo App for Trade Shift Tree Node

API language and framework: JAVA, SpingBoot;
UI framework: React.js;

Two http APIs:
1, GET "/getDescendantNodesId" return list of Tree Node Object;
2, POST "/changeParent" change parent of given Node;


Each node object contains Id, value, parentNode, childrenNode, height.