package minimax;

import java.util.Arrays;

public class Minimax {

    public int calculateLevel(int n) {
        // Want to know how many levels are there
        // Return the depth of recursive calls
        return n == 1 ? 0 : 1 + calculateLevel(n / 2);
    }

    public int minimax(int currDepth, boolean isMax, int values[], int currNodeIndex, int depth) {
        System.out.println(Arrays.toString(values));
        if (values.length == 1) {
            return values[0];
        }
        int[] newValues = new int[(int)Math.round(values.length / 2.0)];

        if (isMax) {
            for (int i = 0; i < newValues.length; i++) {
                try {
                    newValues[i] = Math.max(values[i * 2], values[i*2 + 1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    newValues[i] = values[i*2];
                }
            }
        } else {
            for (int i = 0; i < newValues.length; i++) {
                try {
                    newValues[i] = Math.min(values[i * 2], values[i*2 + 1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    newValues[i] = values[i*2];
                }
            }
        }
        return minimax(currDepth + 1, !isMax, newValues, currNodeIndex, depth);
    }

    public int minimaxEg(int currDepth, boolean isMax, int values[], int currNodeIndex, int depth) {
        // break out of the recursive function, return the final result
        System.out.println(currNodeIndex);
        if (currDepth == depth) {
            return values[currNodeIndex];
        }

        if (isMax) {
            return Math.max(minimaxEg(currDepth+1, !isMax, values, currNodeIndex*2, depth), 
                minimaxEg(currDepth+1, !isMax, values, currNodeIndex*2 + 1, depth));
        } else {
            return Math.min(minimaxEg(currDepth+1, !isMax, values, currNodeIndex*2, depth), 
                minimaxEg(currDepth+1, !isMax, values, currNodeIndex*2 + 1, depth));
        }
    }
    
    public static void main(String[] args) {
        Minimax m = new Minimax();
        int[] values = {2, 5, 18, 34, 92, 21, 15,3};
        System.out.println(m.calculateLevel(values.length));
        System.out.println(m.minimax(0, true, values, 0, m.calculateLevel(values.length)));
    }
}