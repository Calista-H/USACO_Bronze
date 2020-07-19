import java.util.*;
public class USACO_typo {
    static boolean is_balanced(String typo) {
        int open = 0; // # open parentheses
        int close = 0; // # closed parenthesis
        int depth = 0; // # open parentheses - closed parentheses
        for (int i = 0; i < typo.length(); i++) {
            if (typo.charAt(i) == '(') {
                open++;
                depth++;
            }
            else {
                close++;
                depth--;
            }
            if (depth < 0) {
                return false;
            }
        }
        return depth == 0;
    }

    // O(n^2) solution
    static int solution_1(String typo_string) {
        int solution = 0;
        for (int i = 0; i < typo_string.length(); i++) {
            // Change 1 character at a time.
            String new_string = typo_string.substring(0, i);
            if (typo_string.charAt(i) == '(') {
                new_string += ')';
            }
            else {
                new_string += '(';
            }
            new_string += typo_string.substring(i + 1, typo_string.length());

            // Call is_balanced to check if new_string is balanced.
            // Count the number of possible solutions.
            if (is_balanced(new_string)) {
                solution++;
            }
        }
        return solution;
    }

    // O(n) solution
    static int solution_2(String typo_string) {
        int open = 0; // # open parentheses
        int close = 0; // # closed parenthesis
        int depth = 0; // # open parentheses - closed parentheses
        for (int i = 0; i < typo_string.length(); i++) {
            if (typo_string.charAt(i) == '(') {
                open++;
                depth++;
            }
            else {
                close++;
                depth--;
            }
        }

        if (depth > 0) {
            // If depth is positive, there are more open than closed.
            // Every open except one can be switched to closed.
            return open - 1;
        }
        else {
            // If depth is negative, there are more closed than open.
            // Every closed except one can be switched to open.
            return close - 1;
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String typo_string = scan.nextLine();
        //System.out.println(solution_1(typo_string));
        System.out.println(solution_2(typo_string));
    }
}
// ()(())))