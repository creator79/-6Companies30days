class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(res, temp, nums, 0);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (temp.size() == 0 || nums[i] >= temp.get(temp.size() - 1)) {
                temp.add(nums[i]);
                set.add(nums[i]);
                helper(res, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
