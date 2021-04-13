package graph.uf;


public class _685 {
    int[] parent;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int len = edges.length;
        parent = new int[len+1];
        int[][] conflict=new int[3][2];
        boolean cycle=false;
        boolean cflt=false;
        for (int i = 0; i < len+1; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            if(parent[edge[1]]==edge[1]){
                if (find(edge[0]) != find(edge[1])){
                    union(edge[0],edge[1]);
                }else{
                    cycle=true;
                    conflict[2]=edge;
                }
            }else{
                conflict[0]=new int[]{parent[edge[1]],edge[1]};
                conflict[1]=edge;
                cflt=true;
            }
        }
        if(cycle&&cflt){
            return conflict[0];
        }else if(!cycle&&cflt){
            return conflict[1];
        }else{
            return conflict[2];
        }

    }

    private void union(int i, int j) {
        parent[j]=i;
    }

    private int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }
}
