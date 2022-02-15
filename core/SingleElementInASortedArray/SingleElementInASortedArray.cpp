#include <vector>

int singleNonDuplicate(std::vector<int> &nums) {
    int left = 0, right = nums.size() - 1;
    while (left < right) {
        int mid = (right - left) / 2 + left;
        if (nums[mid] == nums[mid ^ 1]) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return nums[left];
}

int singleNonDuplicate1(std::vector<int> &nums) {
    int res = nums[0];
    for (int i = 1; i < nums.size(); ++i) {
        res ^= nums[i];
    }
    return res;
}