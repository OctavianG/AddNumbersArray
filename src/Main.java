public class Main {


    public static int[] sum(int[] op1, int[] op2) {
        int maxIndexArray = Math.max(op1.length, op2.length);
        int[] result = new int[maxIndexArray + 1]; // Include extra slot for potential carry

        int op1Index = op1.length - 1;
        int op2Index = op2.length - 1;
        int resultIndex = result.length - 1;
        int carry = 0;

        while (op1Index >= 0 || op2Index >= 0 || carry > 0) {
            int sum = carry;

            if (op1Index >= 0) {
                sum += op1[op1Index];
                op1Index--;
            }

            if (op2Index >= 0) {
                sum += op2[op2Index];
                op2Index--;
            }

            result[resultIndex] = sum % 10;
            carry = sum / 10;
            resultIndex--;
        }

        // Trim leading zeros if any
        int startIndex = resultIndex + 1;
        if (startIndex > 0) {
            int[] trimmedResult = new int[result.length - startIndex];
            System.arraycopy(result, startIndex, trimmedResult, 0, trimmedResult.length);
            return trimmedResult;
        } else {
            return result;
        }
    }


    public static void main(String[] args) {

        int[] op1 = {9, 9, 9};

        int[] op2 = {1, 1};


        int[] rez = sum(op1, op2);

        System.out.println(arrayToString(rez));
    }

    private static String arrayToString(int[] no) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < no.length; i++) {
            sb.append(no[i]);
        }

        return sb.toString();
    }
}
