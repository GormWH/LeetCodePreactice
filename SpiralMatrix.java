import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0, bottom = matrix.length;
        int left = 0, right = matrix[0].length;
        int i = 0, j = 0; // index of matrix: matrix[i][j]
        List<Integer> result = new ArrayList<Integer>();
        while (top < bottom && left < right) {
            // traverse to the right
            while (j < right) {
                result.add(matrix[i][j++]);
            }
            i++;
            j--;
            top++;
            if (top >= bottom) break;

            //traverse to the bottom
            while (i < bottom) {
                result.add(matrix[i++][j]);
            }
            i--;
            j--;
            right--;
            if (left >= right) break;

            //traverse to the left
            while (j >= left) {
                result.add(matrix[i][j--]);
            }
            i--;
            j++;
            bottom--;
            if (top >= bottom) break;

            //traverse to the top
            while (i >= top) {
                result.add(matrix[i--][j]);
            }
            i++;
            j++;
            left++;
            //if (left >= right) break;
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
        List<Integer> a_traverse = spiralOrder(a);
        for (int integer : a_traverse) {
            System.out.println(integer);
        }
    }
}
