import java.util.ArrayList;

public class AddBinary {
    public static String addBinary(String a, String b) {
        ArrayList<Integer> preResult = new ArrayList<Integer>();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int a_num;
            int b_num;
            if (i >= 0) {
                a_num = Integer.parseInt(String.valueOf(a.charAt(i--)));
            } else {
                a_num = 0;
            }
            if (j >= 0) {
                b_num = Integer.parseInt(String.valueOf(b.charAt(j--)));
            } else {
                b_num = 0;
            }
            preResult.add(a_num + b_num);
        }

        for (int k = 0; k < preResult.size(); k++) {
            switch (preResult.get(k)) {
                case 2:
                    preResult.set(k, 0);
                    if (k == preResult.size() - 1)
                        preResult.add(1);
                    else
                        preResult.set(k + 1, preResult.get(k + 1) + 1);
                    break;
                case 3:
                    preResult.set(k, 1);
                    if (k == preResult.size() - 1)
                        preResult.add(1);
                    else
                        preResult.set(k + 1, preResult.get(k + 1) + 1);
                    break;
                default:
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int k = preResult.size() - 1; k >= 0; k--) {
            result.append(preResult.get(k));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "1011";
        String b = "1010";
        // a + b = "10101";

        System.out.println(addBinary(a, b));
//        System.out.println(toDecimal("101"));
//        System.out.println(toBinary(5));
    }
}
