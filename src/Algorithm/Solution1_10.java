package Algorithm;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * @program: LeeCode
 * @description: 题目1-10的解决方案
 * @author: DBC
 * @create: 2019-12-01 22:46
 **/
public class Solution1_10 {
    public static int[] Test1(int[] nums, int target){
        int a = 0;
        int b = nums.length - 1;
        int result[] = new int[2];

        Map<Integer, Integer> resetNums = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            resetNums.put(i, nums[i]);

        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(resetNums.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        while(a != b){
            int sum = list.get(a).getValue() + list.get(b).getValue();
            if(sum < target) a++;
            else if(sum > target) b--;
            else break;
        }
        result[0] = list.get(a).getKey();
        result[1] = list.get(b).getKey();
        return result;
    }
}
