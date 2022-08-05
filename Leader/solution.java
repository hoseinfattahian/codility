// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.*;
class Solution {
    public int solution(int[] A) {
        int equiLeaderCount=0;
        
        int[] forwardScanLeaderValue=new int[A.length];
        int[] backwardScanLeaderValue=new int[A.length];

        Map<Integer,Integer> container=new HashMap<>();

        int maxCount=0 ;
        int maxValue=2000000000 ;
        //invalid value

        for(int i=0;i<A.length;i++){
            int tempCount=0;
            if(container.get(A[i])==null){
                container.put(A[i],1);
                tempCount=1;
            }
            else{
                tempCount=container.get(A[i])+1;
                container.put(A[i],tempCount);
            }

            if(tempCount>maxCount){
                maxCount=tempCount;
                maxValue=A[i];
            }
            if(maxCount>(i+1)/2)
                forwardScanLeaderValue[i]=maxValue;
            else
                forwardScanLeaderValue[i]=2000000000;
            

        }
        maxCount=0 ;
        maxValue=2000000000 ;
        container.clear();

        for(int i=A.length-1;i>=0;i--){
            int tempCount=0;
            if(container.get(A[i])==null){
                container.put(A[i],1);
                tempCount=1;
            }
            else{
                tempCount=container.get(A[i])+1;
                container.put(A[i],tempCount);
            }
            if(tempCount>maxCount){
                maxCount=tempCount;
                maxValue=A[i];
            }
            if(maxCount>(A.length-i)/2)
                backwardScanLeaderValue[i]=maxValue;
            else
                backwardScanLeaderValue[i]=2000000000;
            

        }
        // for(int i=0;i<A.length;i++){
        //     System.out.print(forwardScanLeaderValue[i]+",");
        // }
        // System.out.println();
        // for(int i=0;i<A.length;i++){
        //     System.out.print(backwardScanLeaderValue[i]+",");
        // }
        // System.out.println();

        for(int i=0;i<A.length-1;i++){
            if(forwardScanLeaderValue[i]==backwardScanLeaderValue[i+1]&& forwardScanLeaderValue[i]!=2000000000)
                equiLeaderCount++;
        }

        return equiLeaderCount;
    }
}