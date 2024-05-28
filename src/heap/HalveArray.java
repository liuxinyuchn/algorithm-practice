package heap;

// lc 2208.将数组和减半的最少操作次数
public class HalveArray {

    public int halveArray(int[] nums) {
        double[] heap = new double[nums.length];
        double sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            heap[i] = nums[i];
            heapify(heap, i);
            sum += nums[i];
        }
        int ans = 0;
        for (double target = sum / 2, cur, minus = 0; minus < target; ans++, minus += cur) {
            cur = heap[0] / 2;
            heap[0] = cur;
            heapify(heap, 0);
        }
        return ans;
    }

    private void heapify(double[] heap, int i) {
        int maxChild = i * 2 + 1;
        while (maxChild < heap.length) {
            if (maxChild + 1 < heap.length && heap[maxChild + 1] > heap[maxChild]) {
                maxChild = maxChild + 1;
            }
            if (heap[i] >= heap[maxChild]) {
                break;
            }
            double tmp = heap[i];
            heap[i] = heap[maxChild];
            heap[maxChild] = tmp;
            i = maxChild;
            maxChild = i * 2 + 1;
        }
    }
}
