import java.util.ArrayList;

// Allows for manipulation and data processing of genes
class GeneManager {
    // Compute a possible edit distance of 1 alignment as directly specified
    // this determines the similarity between literal sequences of genes
    public static int computeEditDistance(GeneSequence current, GeneSequence other) {
        int[][] matrix = new int[current.length()][other.length()];
        for (int i = 0; i < current.length(); i++) {
            for (int j = 0; j < other.length(); j++) {
                matrix[i][j] = recursiveHelper(current, other, i, j);
            }
        }
        // Final edit distance is the last element in the last row and column
        // Add 1 because we start at index 0
        return matrix[current.length() - 1][other.length() - 1] + 1;
    }

    // This utilizes the Levenshtein formula
    // We use this separated helper function to make the recursive calls
    // the `current` and `other` sequences are injected in
    private static int recursiveHelper(GeneSequence current, GeneSequence other, int i, int j) {
        int[] minList = new int[3];
        // Avoid out of bounds errors by returning the maximum of the two indices if any
        // are -1
        if (i == -1 || j == -1) {
            return (i < j) ? j : i;
        }

        minList[0] = recursiveHelper(current, other, i - 1, j) + 1;
        minList[1] = recursiveHelper(current, other, i, j - 1) + 1;
        minList[2] = recursiveHelper(current, other, i - 1, j - 1);
        if (current.charAt(i) != other.charAt(j)) {
            minList[2] += 1;
        }

        // Find the minimum value in the list
        int min = minList[0];
        for (int h = 1; h < minList.length; h++) {
            if (minList[h] < min) {
                min = minList[h];
            }
        }

        return min;
    }
}
