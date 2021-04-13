package unionFind;

import java.util.*;
import java.util.stream.Collectors;

public class _399 {
    Map<String, Integer> hm;
    List<Integer> parent;
    List<Double> weight;
    double[] values;


    public void init(List<List<String>> equations,double[] values) {
        this.values=values;
        hm = new HashMap<>();
        parent=new ArrayList<>();
        weight=new ArrayList<>();
        int count = 0;
        for (int i=0;i<values.length;i++) {
            List<String> strs=equations.get(i);
            String str0=strs.get(0);
            String str1=strs.get(1);
            if (!hm.containsKey(str0)) {
                parent.add(count);
                weight.add(1.0);
                hm.put(str0, count++);
            }
            if (!hm.containsKey(str1)) {
                parent.add(count);
                weight.add(1.0);
                hm.put(str1, count++);
            }
            union(hm.get(str0),hm.get(str1),values[i]);
        }
    }

    public int find(int leaf) {
        int root = leaf;
        double div=1;
        while (parent.get(root)!= root) {
            div*=weight.get(root);
            root = parent.get(root);
        }
//        没必要压缩并查树
//        while (parent.get(leaf) != leaf) {
//            int tmpP = parent.get(leaf);
//            double tmpW = weight.get(leaf);
//
//            parent.set(leaf,root);
//            weight.set(leaf, div);
//
//            div/=tmpW;
//            leaf=tmpP;
//        }
        return root;
    }

    public void union(int a,int b,double value){
        int ap=find(a);
        int bp=find(b);
        if (ap != bp) {
            parent.set(ap,bp);
            weight.set(ap,rootWeight(b)*value/rootWeight(a));
        }
    }

    public double rootWeight(int leaf){
        double w=1.0;
        while(leaf!=parent.get(leaf)){
            w*=weight.get(leaf);
            leaf=parent.get(leaf);
        }
        return w;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        init(equations,values);
        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String str0=queries.get(i).get(0);
            String str1=queries.get(i).get(1);
            Integer i0=hm.get(str0);
            Integer i1=hm.get(str1);
            if(i0==null||i1==null||find(i0)!=find(i1)){
                res[i]=-1;
            }else{
                res[i]=rootWeight(i0)/rootWeight(i1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _399 test=new _399();
        List<List<String>> equations=new ArrayList<>();
        equations.add(Arrays.stream(new String[]{"a","b"}).collect(Collectors.toList()));
        equations.add(Arrays.stream(new String[]{"c","d"}).collect(Collectors.toList()));
        equations.add(Arrays.stream(new String[]{"b","c"}).collect(Collectors.toList()));

        double[] values={1.5,2.5,5.0};

        List<List<String>> queries=new ArrayList<>();
        queries.add(Arrays.stream(new String[]{"a","d"}).collect(Collectors.toList()));
//        queries.add(Arrays.stream(new String[]{"c","b"}).collect(Collectors.toList()));
//        queries.add(Arrays.stream(new String[]{"bc","cd"}).collect(Collectors.toList()));
//        queries.add(Arrays.stream(new String[]{"cd","bc"}).collect(Collectors.toList()));

        double[] res = test.calcEquation(equations,values,queries);
        Arrays.stream(res).forEach(d-> System.out.println(d));
    }
}
