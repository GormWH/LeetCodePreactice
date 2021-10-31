import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<Integer> generateRow(List<Integer> prevRow) {
        int size = prevRow.size();
        List<Integer> currRow = new ArrayList<Integer>();
        currRow.add(1);
        for (int i = 0; i < size - 1; i++) {
            currRow.add(prevRow.get(i) + prevRow.get(i + 1));
        }
        currRow.add(1);
        return currRow;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> prevRow = new ArrayList<Integer>(); // firstRow
        prevRow.add(1);
        result.add(prevRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> currRow = generateRow(prevRow);
            result.add(currRow);
            prevRow = currRow;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = generate(5);
        for (List<Integer> list : result) {
            for (int integer : list) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
