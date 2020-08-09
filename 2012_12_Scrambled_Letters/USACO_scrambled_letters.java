// Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=206
import java.util.*;
public class USACO_scrambled_letters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Read input strings and store in an array.
        int num_cows = scan.nextInt();
        scan.nextLine();
        String[] input = new String[num_cows];
        String[] alphabetic = new String[num_cows];
        String[] reverse_alphabetic = new String[num_cows];
        for (int i = 0; i < num_cows; i++) {
            String input_name = scan.nextLine();
            input[i] = input_name;

            // ALphabeticalize input names
            char[] char_array = input_name.toCharArray();
            Arrays.sort(char_array);
            alphabetic[i] = new String(char_array);

            // Reverse alphabeticalize input names
            StringBuilder str_builder = new StringBuilder(
                    new String(char_array));
            reverse_alphabetic[i] = str_builder.reverse().toString();
        }

        // Alphabeticalize all names and sort them alphabetically.
        Arrays.sort(alphabetic);

        // Reverse alphabeticalize all names and sort them alphabetically.
        Arrays.sort(reverse_alphabetic);

        // For each name in the input array,
        //   a) alphabeticalize it and find the lowest position in the reverse
        //      alphabetical array.
        //   b) reverse alphabeticalize and find the highest position in the
        //      alphabetical array.
        for (int i = 0; i < num_cows; i++) {
            // Alphabeticalize current name.
            char[] char_array = input[i].toCharArray();
            Arrays.sort(char_array);
            String alphabetic_name = new String(char_array);
            // Use binarySearch to find the lowest insertion position
            // of the alphabeticalized name.
            int low_pos = Arrays.binarySearch(reverse_alphabetic,
                                              alphabetic_name);
            if (low_pos < 0) { // Name is not in the array.
                low_pos = -(low_pos + 1);
            }
            low_pos++; // Position starts with 1, not 0.

            // Reverse alphabeticalize current name.
            StringBuilder str_builder = new StringBuilder(
                    new String(char_array));
            String reverse_name = str_builder.reverse().toString();
            // Find the highest insertion position of
            // the reverse alphabeticalized name.
            int high_pos = Arrays.binarySearch(alphabetic, reverse_name);
            if (high_pos < 0) { // Name is not in the array.
                // The reverse alphabetic always appears after
                // the current alphabetic name.
                high_pos = -(high_pos + 1);
            } else {
                high_pos++; // Position starts with 1, not 0.
            }

            // Print result
            System.out.println(low_pos + " " + high_pos);
        }
    }
}
/*
4
essieb
a
xzy
elsie

*/