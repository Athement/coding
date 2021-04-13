package graph.generateTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacent=new ArrayList<>();
        int[] preCount=new int[numCourses];
        int count=0;
        Queue<Integer> queue =new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            adjacent.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            adjacent.get(pre[1]).add(pre[0]);
            preCount[pre[0]]++;
        }
        for(int i=0;i<numCourses;i++){
            if(preCount[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            for(int adj:adjacent.get(cur)){
                if(--preCount[adj]==0){
                    queue.add(adj);
                }
            }
        }

        return count==numCourses;
    }
}
