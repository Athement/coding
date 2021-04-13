package recurse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17 {
    List<String> res = new ArrayList<>();
    Map<Character,String> hm = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
            return res;
        hm.put('2',"abc");
        hm.put('3',"def");
        hm.put('4',"ghi");
        hm.put('5',"jkl");
        hm.put('6',"mno");
        hm.put('7',"pqrs");
        hm.put('8',"tuv");
        hm.put('9',"wsyz");
        combine(digits,0,"");
        return res;
    }

    private void combine(String digits, int index,String str) {
        if(index==digits.length()){
            res.add(str);
            return;
        }
        String btn=hm.get(digits.charAt(index));
        for(int i=0;i<btn.length();i++){
            combine(digits, index+1, str+btn.substring(i,i+1));
        }
    }
}
