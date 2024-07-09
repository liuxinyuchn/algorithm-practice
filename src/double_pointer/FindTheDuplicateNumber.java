package double_pointer;

// lc 287.寻找重复数
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        if (nums.length == 2) {
            return 1;
        }
        int slow = nums[0], fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
