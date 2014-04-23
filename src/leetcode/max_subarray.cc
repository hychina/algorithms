#include <vector>
#include <limits>

class Solution {
    private:
        std::vector<int> A;

    public:
        Solution(std::vector<int> a) : A(a) {};

        // make sure that high > mid >= low
        std::vector<int> maxCrossingSubarray(int low, int high, int mid) {
            int left_sum = std::numeric_limits<int>::min();
            int sum = 0;
            int start = mid;
            int end = mid + 1;

            // i from mid to low 
            for (int i = mid; i >= low; i--) {
                sum += A[i];
                if (sum > left_sum) {
                    left_sum = sum;
                    start = i;
                }
            }

            int right_sum = std::numeric_limits<int>::min();
            sum = 0;
            // i from mid + 1 to high
            for (int i = mid + 1; i <= high; i++) {
                sum += A[i];
                if (sum > right_sum) {
                    right_sum = sum;
                    end = i;
                }
            }

            std::vector<int> ret;
            ret.push_back(right_sum + left_sum);
            ret.push_back(start);
            ret.push_back(end);
            return ret;
        }

        std::vector<int> maxSubarray(int low, int high) {
            if (low == high) {
                std::vector<int> max;
                max.push_back(A[low]);
                max.push_back(low);
                max.push_back(high);
                return max;
            }

            // high is bigger than low, mid is bigger than or equal with low
            int mid = (low + high) / 2;

            // max subarray containing mid and mid + 1
            // high >= mid + 1 > mid >= low
            std::vector<int> crossing = maxCrossingSubarray(low, high, mid);

            std::vector<int> left = maxSubarray(low, mid);
            std::vector<int> right = maxSubarray(mid + 1, high);

            // will influence the range
            // consider {1, 2, 3, -1, -2, -3, 6}
            std::vector<int> max = right;
            if (crossing[0] > max[0]) max = crossing;
            if (left[0] > max[0]) max = left;

            return max;
        }

};

int main(int argc, char const* argv[])
{   
    /* int arr[] = {1, 2, 3, 4, -5, -6, -7, -8}; */
    int arr[] = {1, 2, 3, -1, -2, -3, 6};
    std::vector<int> A(std::begin(arr), std::end(arr));

    int low = 0;
    int high = A.size() - 1;

    Solution solution(A);

    std::vector<int> result = solution.maxSubarray(low, high);

    for (std::vector<int>::iterator it = result.begin(); it != result.end(); it++) {
        printf("%d\n", *it);
    }
    return 0;
}
