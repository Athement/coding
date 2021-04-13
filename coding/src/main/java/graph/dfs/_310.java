package graph.dfs;

import graph.generateTree._684;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _310 {
    boolean[] visited;
    List<Integer> res;
    List<Integer>[] adjs;
    int minHeight=Integer.MAX_VALUE;
    int root;
    int num;
    int count;
    int maxHeight=Integer.MIN_VALUE;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        num=n;
        res=new LinkedList<>();
        adjs=new List[n];

        for(int i=0;i<n;i++){
            adjs[i]=new LinkedList<>();
        }
        for(int[] edge:edges){
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
        }
        for(int i=0;i<n;i++){
            visited=new boolean[n];
            root=i;
            count=0;
            maxHeight=Integer.MIN_VALUE;
            dfs(root,0);

        }
        return res;
    }

    private void dfs(int i,int height) {
        count++;
        visited[i]=true;
        height++;
        maxHeight=Math.max(height,maxHeight);
        if(maxHeight>minHeight){
            return;
        }else if(count==num){
            if(maxHeight<minHeight){
                minHeight=maxHeight;
                res.clear();
            }
            res.add(root);
            return;
        }
        for(int adj:adjs[i]){
            if(!visited[adj]){
                dfs(adj,height);
            }
        }

    }

    /**
     * ��ΧBFS
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees01(int n, int[][] edges) {
        //ͳ���������
        int count=0;
        //�洢�ڱ�
        List<Integer>[] adjs=new List[n];
        //���б���ڵ�
        List<Integer> queue =new LinkedList<>();
        //����ڵ�Ķ�
        int[] edgeCount=new int[n];
        for(int i=0;i<n;i++){
            adjs[i]=new LinkedList<>();
        }
        for(int[] edge:edges){
            //ͳ���ڱ�
            adjs[edge[0]].add(edge[1]);
            adjs[edge[1]].add(edge[0]);
            //ͳ�ƽڵ��
            edgeCount[edge[0]]++;
            edgeCount[edge[1]]++;
        }
        //��¼��Ϊ1��������
        for(int i=0;i<n;i++){
            //���ڶ�Ϊ0�Ľڵ�˵��ֻ��һ���ڵ�
            if(edgeCount[i]<=1){
                queue.add(i);
                count++;
            }
        }
        if(count==n){
            return queue;
        }
        int tail=queue.get(queue.size()-1);
        while(!queue.isEmpty()){
            int cur=queue.remove(0);
            //�ȼ�1
            for(int adj:adjs[cur]){
                if(--edgeCount[adj]==1) {
                    queue.add(adj);
                    //�����+1
                    count++;
                }
            }
            //ÿ�ִ�������Ҫ���ж������
            if(cur==tail){
                //���Ѿ�ȫ�����,��������
                if(count==n){
                    return queue;
                }
                //����tail
                tail=queue.get(queue.size()-1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        _310 test=new _310();
        System.out.println(test.findMinHeightTrees(6, _684.parseArray("[[3,0],[3,1],[3,2],[3,4],[5,4]]")));
    }
}
