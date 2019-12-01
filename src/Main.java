import Algorithm.Solution1_10;

public class Main {

    public static void main(String[] args) {
        int nums[] = {2,20,3,4,7,11,15};
        int target = 9;
        int result[] = Solution1_10.Test1(nums, target);
        System.out.println(result[0] + " , " + result[1]);
    }
}
