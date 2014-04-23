#include <vector>
using std::vector;

void swap(vector<int> &A, int i, int j) {
    int t = A[j];
    A[j] = A[i];
    A[i] = t;
}

void reverse(vector<int> &A, int i, int j) {
    int mid = (j - i) / 2;
    for (int k = 0; k <= mid; ++k) {
        swap(A, i + k, j - k);
    }
}

int main(int argc, char const* argv[])
{
    vector<int> A;
    A.push_back(2);
    A.push_back(3);
    A.push_back(1);
    /* A.push_back(4); */
    /* A.push_back(5); */

    for (int i : A) {
        printf("%d\n", i);
    }

    printf("\n");

    reverse(A, 1, A.size() - 1);

    for (int i : A) {
        printf("%d\n", i);
    }
    return 0;
}
