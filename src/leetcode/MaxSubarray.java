package recursive;

public class MaxSubarray {

	public static void main(String[] args) {
		int[] A = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		divideAndConquer(A);
	}
	
	public static void bruteForce(int[] A) {
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for (int i = 0; i < A.length; i++) {
			sum = 0;
			for (int j = i; j < A.length; j++) { // 注意单个元素也算子数组
				sum += A[j];
				if (sum > maxSum) { 
					maxSum = sum;
					start = i;
					end = j;
				}
				System.out.println(sum + " " + maxSum + " " + i + " " + j);
			}
		}
		System.out.println(start + " " + end);
	}

	public static void divideAndConquer(int[] A) {
		int[] max = divideAndConquer(A, 0, A.length - 1);
		System.out.println(max[0] + " " + max[1] + " " + max[2]);
	}

	private static int[] divideAndConquer(int[] A, int lo, int hi) { 
		if (hi == lo) { // hi 不可能小于 lo
			int[] ret = new int[3];
			ret[0] = A[lo];
			ret[1] = lo;
			ret[2] = hi;
			return ret;
		}
		int mid = (hi + lo) / 2; // floor

		int[] cross = maxCrossingSubarray(A, lo, mid, hi);
		int[] left = divideAndConquer(A, lo, mid);
		int[] right = divideAndConquer(A, mid + 1, hi);
		int[] ret = cross;
		if (left[0] > cross[0]) ret = left;
		if (right[0] > ret[0]) ret = right;
		return ret;
	}

	private static int[] maxCrossingSubarray(int[] A, int lo, int mid, int hi) {
		int max_left = Integer.MIN_VALUE;
		int max_right = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		int sum = 0;
		for (int left = mid; left >= lo; left--) {
			sum += A[left];
			if (sum > max_left) {
                max_left = sum;
                start = left;
			}
		}
		sum = 0;
        for (int right = mid + 1; right <= hi; right++) {
        	sum += A[right];
        	if (sum >= max_right) {
        		max_right = sum;
        		end = right;
        	}
        }
        int max = max_left + max_right;
        int[] ret = new int[3];
        ret[0] = max;
        ret[1] = start;
        ret[2] = end;
        return ret; 
	}

}
