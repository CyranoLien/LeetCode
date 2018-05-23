package leetcode.local;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Method1 is brute force and Method2 is using a one-way sliding window */

public class Num3_LengthOfLongestSubstring {
    public boolean checkUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<Character>();
        for (int i = start; i < end; i++) {
            Character ch = s.charAt(i);
            if (set.contains(ch))
                return false;
            else
                set.add(ch);
        }
        return true;
    }

    public int method1(String s) {
        int n = s.length();
        int answ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (checkUnique(s, i, j))
                    answ = Math.max(answ, j - i);
            }
        }
        return answ;
    }

    public int method2(String s) {
        int n = s.length();
        int answ = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0, j = i; j < n; j++) {
            Character ch = s.charAt(j);
            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch) + 1, i);
            }
            map.put(ch, j);
            answ = Math.max(answ, j - i + 1);
        }
        return answ;
    }

    public static void main(String args[]) {
        Num3_LengthOfLongestSubstring x = new Num3_LengthOfLongestSubstring();
        System.out.print(x.method2("helloworldddd"));
    }
}
