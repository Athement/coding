package recurse;

public class _10 {
    public boolean isMatch(String s, String p) {
        return match(s, 0, p, 0);
    }

    public boolean match(String s, int si, String p, int pi) {
        //两个字符串同时到达终点，则匹配
        if (s.length() == si && p.length() == pi) {
            return true;
        }
        //无*
        if (pi < p.length() && si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
            if (match(s, si + 1, p, pi + 1)) {
                return true;
            }
        }
        //有*
        if (pi < p.length() - 1 && p.charAt(pi + 1) == '*') {//*匹配
            //*匹配0个
            if (match(s, si, p, pi + 2)) {
                return true;
            }
            //*匹配1个（与*匹配0个搭配，可实现*匹配n个）
            if (si < s.length() && (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.')) {
                if (match(s, si + 1, p, pi)) {
                    return true;
                }
            }
        }


        return false;
    }
}
