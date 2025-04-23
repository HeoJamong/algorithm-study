import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 참가자를 map에 넣고 동명이인일 경우 값을 1 증가
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        // 이름을 key로 해서 탐색하여 값을 1씩 줄임
        // 값이 0이 되면 remove?
        
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }
        
        for (String s : participant) {
            if (map.get(s) != 0) {
                return s;
            }
        }
        
        return null;
    }
}