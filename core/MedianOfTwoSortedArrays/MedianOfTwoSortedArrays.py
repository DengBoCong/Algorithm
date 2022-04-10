from typing import List


def findMedianSortedArrays(nums1: List[int], nums2: List[int]) -> float:
    m, n = len(nums1), len(nums2)

    def get_k_element(k):
        index1, index2 = 0, 0
        while True:
            if index1 == m:
                return nums2[index2 + k - 1]
            if index2 == n:
                return nums1[index1 + k - 1]
            if k == 1:
                return min(nums1[index1], nums2[index2])

            new_index1 = min(index1 + k // 2 - 1, m - 1)
            new_index2 = min(index2 + k // 2 - 1, n - 1)
            pivot1, pivot2 = nums1[new_index1], nums2[new_index2]
            if pivot1 <= pivot2:
                k -= new_index1 - index1 + 1
                index1 = new_index1 + 1
            else:
                k -= new_index2 - index2 + 1
                index2 = new_index2 + 1

    total_length = m + n
    if total_length % 2 == 1:
        return get_k_element((total_length + 1) // 2)
    else:
        return (get_k_element(total_length // 2) + get_k_element(total_length // 2 + 1)) / 2


if __name__ == '__main__':
    print(findMedianSortedArrays(nums1=[1, 3], nums2=[2]))
