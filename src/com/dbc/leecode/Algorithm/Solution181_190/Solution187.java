package com.dbc.leecode.Algorithm.Solution181_190;

public class Solution187 {
<<<<<<< HEAD
//    DELETE p1 FROM Person p1,
//    Person p2
//    WHERE
//    p1.Email = p2.Email AND p1.Id > p2.Id;
=======
    public int rob(int[] nums){
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        for (int i = 2; i < length; i++){
            if (i == 2){
                nums[i] = nums[i] + nums[i - 2];
            }else {
                nums[i] = (nums[i] + nums[i - 2]) > (nums[i] + nums[i - 3]) ? (nums[i] + nums[i - 2]) : (nums[i] + nums[i - 3]);
            }
        }

        return nums[length - 1] > nums[length - 2] ? nums[length - 1] : nums[length - 2];
    }
>>>>>>> local
}
