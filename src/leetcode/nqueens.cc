#include <vector>
using std::vector;

class Queens {

    public:
        int count;
        int size;
        int num_solutions;
        vector<int> cols;
        vector<int> rows;
        vector<int> upward;
        vector<int> downward;

        bool isSatisfied(int col) {
            if (this->cols[col] == 0 &&
                    this->upward[col + this->count] == 0 &&
                    this->downward[this->count - col + this->size - 1] == 0)
                return true;
            else return false;
        }

        void insertQueen(int col) { 
            this->cols[col] = 1;
            this->upward[this->count + col] = 1;
            this->downward[this->count - col + this->size - 1] = 1;
            this->rows[(this->count)++] = col;
        }

        void deleteQueen(int col) { 
            this->cols[col] = 0;
            --(this->count); // count现在指向下一层，一定要先减一
            this->upward[this->count + col] = 0;
            this->downward[this->count - col + this->size - 1] = 0;
            this->rows[this->count] = this->size;
        }

        void print() {
            for (int i = 0; i < this->size; i++) { // for every row
                for (int j = 0; j < this->rows[i]; j++) {
                    printf("0 ");
                }
                if (this->rows[i] < this->size) {
                    printf("1 ");
                    for (int k = this->rows[i] + 1; k < this->size; k++) { 
                        printf("0 ");
                    }
                }
                printf("\n");
            }
            printf("\n");
        }
};

void totalNQueensHelper(Queens &queens) {
    if (queens.count == queens.size) {
        printf("solution found:\n");
        queens.num_solutions++;
        queens.print();
    } else {
        for (int i = 0; i < queens.size; ++i) {
            if (queens.isSatisfied(i)) {
                queens.insertQueen(i);
                queens.print();
                totalNQueensHelper(queens);
                queens.deleteQueen(i);
            }
        }
    }

}

void totalNQueens(int n) {
    Queens queens;
    queens.count = 0;
    queens.size = n;
    queens.num_solutions = 0;
    for (int i = 0; i < n; ++i) {
        queens.cols.push_back(0); // if each column is guarded
        queens.rows.push_back(n); // queen position in each row
    }
    for (int i = 0; i < 2*n - 1; ++i) {
        queens.upward.push_back(0);
        queens.downward.push_back(0);
    }

    totalNQueensHelper(queens);
    printf("%d\n", queens.num_solutions);
}

int main(int argc, char const* argv[])
{
    totalNQueens(3);
    return 0;
}
