package algorithm;

public class _28KMP {
    public int strStr(String haystack, String needle) {
        int[] next = getNext(needle);
        int i = 0, j = 0;
        while (i < haystack.length()) {
            if (j < 0 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    private int[] getNext(String str) {
        int len = str.length();
        int[] next = new int[len];
        next[0] = -1;
        for (int i = 1; i < len; i++) {
            for (int j = i-1; j >=1; j--) {
                // find max(j) where str[0,j]=str[i-j,i], if haystack[n] doesn't match str[j], it'll try to match str[next[j]]
                if (str.substring(0, j).equals(str.substring(i-j, i))) {
                    next[i] = j;
                    break;
                }
            }
        }
        return next;
    }

    public static void main(String[] args) {
        _28KMP test=new _28KMP();
        System.out.println(test.strStr("ababcaababcaabc",
                "aaaaaa"));
    }
}
