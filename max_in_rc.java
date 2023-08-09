import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    static class NumberWithAddress {
        int num;
        int i;
        int j;

        public NumberWithAddress(int num, int i, int j) {
            this.num = num;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int Q = scanner.nextInt();

            int[][] matrix = new int[N][M];

            // Input matrix elements
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int hap = 0; // result
            List<NumberWithAddress> safeNumbers = getSafeNumbers(matrix, N, M);
            int r, c, x;

            for (int i = 0; i < Q; i++) {
                r = scanner.nextInt();
                c = scanner.nextInt();
                x = scanner.nextInt();
                matrix[r - 1][c - 1] = x;

                

                // Check and remove smaller numbers in the same row or column
                for (int a = safeNumbers.size() - 1; a >= 0; a--) {
                    NumberWithAddress number = safeNumbers.get(a);
                    if (number.i == r - 1 || number.j == c - 1) {
                        if (number.num < x) {
                            safeNumbers.remove(a);
                        }
                    }
                }

                // Check if matrix[r - 1][c - 1] is the maximum in its row or column
                boolean isMaxInRow = true;
                for (int j = 0; j < M; j++) {
                    if (matrix[r - 1][j] > x) {
                        isMaxInRow = false;
                        break;
                    }
                }

                boolean isMaxInColumn = true;
                for (int j = 0; j < N; j++) {
                    if (matrix[j][c - 1] > x) {
                        isMaxInColumn = false;
                        break;
                    }
                }

                // Add matrix[r - 1][c - 1] to safeNumbers if it is the maximum in its row or column
                if (isMaxInRow && isMaxInColumn) {
                    safeNumbers.add(new NumberWithAddress(x, r - 1, c - 1));
                }

                hap += safeNumbers.size();
            }

            System.out.println("#" + test_case + " " + hap);
        }
    }

    public static List<NumberWithAddress> getSafeNumbers(int[][] matrix, int N, int M) {
        List<NumberWithAddress> safeNumbers = new ArrayList<>();

        // Iterate over each element of the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num = matrix[i][j];
                boolean isSafe = true;

                // Check if num is the largest in its row
                for (int k = 0; k < M; k++) {
                    if (matrix[i][k] > num) {
                        isSafe = false;
                        break;
                    }
                }

                // Check if num is the largest in its column
                for (int k = 0; k < N; k++) {
                    if (matrix[k][j] > num) {
                        isSafe = false;
                        break;
                    }
                }

                // Add the number to the list if it is safe
                if (isSafe) {
                    safeNumbers.add(new NumberWithAddress(num, i, j));
                }
            }
        }

        return safeNumbers;
    }
}
