package quick_selection;

// lc 215.数组中的第 K 个最大元素
public class FindKthLargest {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(find(nums, 4));
    }

    public static int find(int[] nums, int k) {
        int ans = 0;
        for (int l = 0, r = nums.length - 1; l <= r;) {
            int random = nums[l + (int) (Math.random() * (r - l))];
            int i = l, left = l, right = r;
            while (i <= right) {
                if (nums[i] > random) {
                    swap(nums, i++, left++);
                } else if (nums[i] < random) {
                    swap(nums, i, right--);
                } else {
                    i++;
                }
            }
            if (k - 1 < left) {
                r = left - 1;
            } else if (k - 1 > right) {
                l = right + 1;
            } else {
                ans = nums[left];
                break;
            }
        }
        return ans;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
