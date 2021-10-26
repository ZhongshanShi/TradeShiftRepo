# TradeShiftRepo
 TradeShift
This is a demo App for Trade Shift Tree Node

API language and framework: JAVA, SpingBoot;
UI framework: React.js;

Two http APIs:
1, GET "/getDescendantNodesId" return list of Tree Node Object;

2, POST "/changeParent" change parent of given Node;


Each node object contains Id, value, parentNode, childrenNode, height.

![nodetree](https://user-images.githubusercontent.com/55010634/138937614-d22d0c42-1405-49c3-b3e2-0ee4f4458a98.png)

[
    {
        "id": 1,
        "val": 101,
        "parentId": 0,
        "height": 1
    },
    {
        "id": 4,
        "val": 104,
        "parentId": 1,
        "height": 2
    },
    {
        "id": 5,
        "val": 105,
        "parentId": 1,
        "height": 2
    },
    {
        "id": 2,
        "val": 102,
        "parentId": 0,
        "height": 1
    },
    {
        "id": 3,
        "val": 103,
        "parentId": 2,
        "height": 2
    }
]

![image](https://user-images.githubusercontent.com/55010634/138938360-8002196d-3c7a-4c15-baab-ab24c72ef2ef.png)

