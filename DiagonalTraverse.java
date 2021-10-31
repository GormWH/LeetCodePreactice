public class DiagonalTraverse {
    public static int[] findDiagonalOrder(int[][] mat) {
        int n_row = mat.length;
        int n_col = mat[0].length;
        int[] result = new int[n_row * n_col];
        int index = 0;

        // sum = i + j, i is for row and j is for column
        boolean flag = true; // flag = true: right-upward, flag = false: left-downward
        int i = 0, j = 0;
        for (int sum = 0; sum < n_row + n_col - 1; sum++) {
            if (flag) {
                while (i >= 0 && j < n_col) {
                    result[index++] = mat[i--][j++];
                }
                i++;
                j--;
                if (j + 1 < n_col) j++;
                else i++;
                flag = false;
            } else {
                while (j >= 0 && i < n_row) {
                    result[index++] = mat[i++][j--];
                }
                i--;
                j++;
                if (i + 1 < n_row) i++;
                else j++;
                flag = true;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] a = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                a[i][j] = i * 5 + j;
            }
        }
        int[] a_traverse = findDiagonalOrder(a);
        for (int integer : a_traverse) {
            System.out.println(integer);
        }
    }
}
