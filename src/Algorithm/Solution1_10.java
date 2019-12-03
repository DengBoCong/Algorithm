package Algorithm;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * @program: LeeCode
 * @description: 题目1-10的解决方案，命名规则Test+题目编号+S+解决方案编号
 * @author: DBC
 * @create: 2019-12-01 22:46
 **/
public class Solution1_10 {

    /*
    * int nums[] = {2,20,3,4,7,11,15};//{3,3}
    * int target = 9;
    * int result[] = Solution1_10.Test1S1(nums, target);
    * System.out.println(result[0] + " , " + result[1]);
    * */
    public static int[] Test1S1(int[] nums, int target){
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

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){this.val = val;}
    }
    public static ListNode Test2S1(ListNode l1, ListNode l2){
        int flag = 0; //标志位，标志所在位数是否进1
        boolean isFirst = true; //标志位，标志是否第一次进入循环
        ListNode sumNode = new ListNode(0);
        ListNode resultNode = sumNode;

        while(l1.next != null || l2.next != null){
            int sum = l1.val + l2.val + flag;

            if(isFirst){
                sumNode.val = sum % 10;
                isFirst = false;
            }else{
                sumNode.next = new ListNode(sum % 10);
                sumNode = sumNode.next;
            }

            l1 = l1.next;
            l2 = l2.next;
            flag = sum / 10;

        }
        return resultNode;
    }
}
