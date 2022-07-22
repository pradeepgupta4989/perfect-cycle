#### perfect-cycle  
Problem Statement :  
Part1:  
In this part of the assessment, you are to develop an endpoint to track the occurrence of a perfect cycle in a list.  
The perfect cycle has two conditions needed to arise in a list, and they are as follows:  
All elements of the list must be visited.  
The last element to be visited takes you back to position zero.  

#### Approach: Use DFS  
1. Given array input [].  
2. Create a visited[] to check if the array element is already visited.  
3. Initialize Node with {index, input[i]]   
4. Now start with input[0].   
5. If {i} is not already visited then mark {i} as visited and jump to the next index which is at the index = input[i].   
6. For example (1, 0) and i = 0 then jump to  index=1. Repeat this process until you find an index which is already visited.   
7. set perfectCycle flag to true if all index are visited &&  last visited index value == 0 (Start index).    
8. Return perfectcycle flag.   
 
 
 #### How to execute :
- Rest endpoint : http://localhost:9080/api/v1/perfect-cycle
- Sample Json Input :
{
    "inputSet" :[
        {
            "listName": "list2",
            "listData": [0, 2 , 5]
        },
         {
            "listName": "list3",
            "listData":  [3,0,1,2]
        },
        {
            "listName": "list4",
            "listData":  [2,0,1]
        },
         {
            "listName": "list",
            "listData":  [1,2,3]
        }
    ]
}
- Output result :
[
    "list2 : perfect cycle : false",
    "list3 : perfect cycle : true",
    "list4 : perfect cycle : true",
    "list : perfect cycle : false"
]
