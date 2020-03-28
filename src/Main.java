

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.next();
            Map<Character, Integer> map = new HashMap<>();
            int length = s.length();
            for (int i = 0; i < length; i++){
                if (map.containsKey(s.charAt(i))){
                    int count = map.get(s.charAt(i)) + 1;
                    map.put(s.charAt(i), count);
                }else {
                    map.put(s.charAt(i), 1);
                }
            }

            String res = "";
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                char mapKey = entry.getKey();
                int mapValue = entry.getValue();
                res = res + mapKey + mapValue;
            }

            System.out.println(res);
        }
    }
}
