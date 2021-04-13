package recurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _842 {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res=new ArrayList<>();
        for(int i=1;i<S.length();i++){
            String fstStr=S.substring(0,i);
            if(fstStr.charAt(0)=='0'&&fstStr.length()>1){
                break;
            }

            int fstInt=Integer.parseInt(fstStr);
            for(int j=i+1;j<S.length();j++){
                res.add(fstInt);
                String secStr=S.substring(i,j);
                if(secStr.charAt(0)=='0'&&secStr.length()>1){
                    break;
                }
                int secInt=Integer.parseInt(secStr);
                res.add(secInt);

                int fstTmp=fstInt;
                int secTmp=secInt;
                int index=j;
                while(index!=S.length()){
                    int trdTmp=fstTmp+secTmp;
                    String trdStr = String.valueOf(trdTmp);
                    if(S.substring(index).startsWith(trdStr)){
                        fstTmp=secTmp;
                        secTmp=trdTmp;
                        index+=trdStr.length();
                        res.add(trdTmp);
                    }else{
                        res=new ArrayList<>();
                        break;
                    }
                }
                if(index==S.length()){
                    if(res.size()>2){
                        return res;
                    }
                    return new ArrayList<>();
                }
            }

        }
        return new ArrayList<>();
    }
}
