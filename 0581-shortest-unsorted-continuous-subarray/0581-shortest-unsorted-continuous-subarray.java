class Solution {

    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int start = 0, end = nums.length - 1;
        while (start < end && nums[start] == temp[start]) start++;
        while (start < end && nums[end] == temp[end]) end--;
        if (start == end) return 0;
        return end - start + 1;
    }
}
