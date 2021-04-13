package graph.sssp;

import java.util.*;

public class _743 {
    public int networkDelayTime(int[][] times, int n, int k) {
//        Map<Integer,TreeMap<Integer,Integer>> dst=new HashMap<>();
//        for(int[] time:times){
//            if(!dst.containsKey(time[0])){
//                dst.put(time[0],new TreeMap<>());
//            }
//            dst.get(time[0]).put(time[1],time[2]);
//            if(!dst.containsKey(time[1])){
//                dst.put(time[1],new TreeMap<>());
//            }
//            dst.get(time[1]).put(time[0],time[2]);
//        }
//        dijkstra(dst,n,k);
//        for(Map.Entry entry:dst.get(k).entrySet()){
//            System.out.println(entry.getValue());
//        }

        int[] dst = bellman_ford(times, n, k);
        for (int i : dst) {
            System.out.println(i);
        }
        return 0;
    }

    public Map<Integer, Integer> dijkstra(Map<Integer, TreeMap<Integer, Integer>> edges, int len, int start) {
        boolean[] visited = new boolean[len + 1];
        visited[start] = true;
        TreeMap<Integer, Integer> startMap = edges.get(start);
        //执行n-1次
        for (int i = 1; i < len; i++) {
            int minIdx = 0;
            int min = Integer.MAX_VALUE;
            for (Integer k : edges.get(start).keySet()) {
                if (!visited[k] && startMap.get(k) < min) {
                    minIdx = k;
                    min = startMap.get(k);
                    visited[k] = true;
                }
            }
            //节点是1-n
            for (int j = 1; j <= len; j++) {
                if (!visited[j] && edges.containsKey(minIdx) && edges.get(minIdx).containsKey(j)) {
                    if (!startMap.containsKey(j)) {
                        startMap.put(j, startMap.get(minIdx) + edges.get(minIdx).get(j));
                    } else {

                    }
                    startMap.put(j, Math.min(startMap.get(minIdx) + edges.get(minIdx).get(j), startMap.get(j)));
                }
            }

        }
        return startMap;
    }

    public int[] bellman_ford(int[][] edges, int len, int start) {
        int[] dst = new int[len + 1];
        Arrays.fill(dst, Integer.MAX_VALUE / 2);
        dst[start] = 0;
        for (int i = 0; i < len; i++) {
            for (int[] edge : edges) {
                if (dst[edge[1]] > dst[edge[0]] + edge[2]) {
                    if (i == len - 1) {
                        return null;
                    } else {
                        dst[edge[1]] = dst[edge[0]] + edge[2];
                    }
                }
                if (dst[edge[0]] > dst[edge[1]] + edge[2]) {
                    if (i == len - 1) {
                        return null;
                    } else {
                        dst[edge[0]] = dst[edge[1]] + edge[2];
                    }
                }
            }
        }
        return dst;
    }

    public int[] spfa(Map<Integer, TreeMap<Integer, Integer>> edges, int len, int start) {
        int[] dst = new int[len + 1];
        Arrays.fill(dst, Integer.MAX_VALUE / 2);
        int[] count = new int[len + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= len; i++) {
            queue.offer(i);
            count[i]++;
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Map.Entry<Integer, Integer> entry : edges.get(node).entrySet()) {
                if (dst[entry.getKey()] > dst[node] + entry.getValue()) {
                    dst[entry.getKey()] = dst[node] + entry.getValue();
                    if (!queue.contains(entry.getKey())) {
                        queue.offer(entry.getKey());
                        count[entry.getKey()]++;
                        if (count[entry.getKey()] > len) {
                            return null;
                        }
                    }
                }

            }
        }
        return dst;
    }

    public int[] floyd(int[][] edges, int len, int start) {
        for (int k = 1; k <= len; k++) {
            for (int i = 1; i <= len; i++) {
                for (int j = 1; j <= len; j++) {
                    edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                }
            }
        }
        return edges[start];
    }

    int[] dist;
    boolean[] visited;
    int[][] g;//邻接矩阵

    void dfs(int v, int now, int n) {
        if (now >= dist[v]) return;
        dist[v] = now;
        for (int i = 1; i <= n; i++) {
            if (g[v][i] != Integer.MAX_VALUE / 2 && !visited[i]) {
                visited[i] = true;
                dfs(i, now + g[v][i], n);
                //回溯标志
                visited[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) {
        _743 test = new _743();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        test.networkDelayTime(times, 4, 2);
    }
}
