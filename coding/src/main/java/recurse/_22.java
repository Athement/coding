package recurse;

import java.util.ArrayList;
import java.util.List;

public class _22 {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0){
            return res;
        }
        parenthesis(n,n,"");
        return res;
    }

    private void parenthesis(int left, int right, String s) {
        if(left==0&&right==0){
            res.add(s);
        }else if(left<=right&&left>=0&&right>=0){
            parenthesis(left-1,right,s+"(");
            parenthesis(left,right-1,s+")");
        }
    }
}
