// Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=189
import java.util.*;
public class USACO_horseshoes{
    static int grid_size;
    static char[][] grid;
    static int longest_balanced_length = 0;

    static void calc_balanced_path(int row, int column, int num_open,
                                   int num_closed, boolean is_open_half) {
        // Check for out of bounds rows and columns.
        if (row < 0 || row >= grid_size || column < 0 || column >= grid_size) {
            return;
        }
        // Found the a balanced string. Update longest_balanced_length if needed.
        if (num_open == num_closed) {
            longest_balanced_length = Math.max(longest_balanced_length,
                    num_open + num_closed);
            return;
        }

        // recursive case
        char old_horseshoe = grid[row][column];
        grid[row][column] = '0';
        int[] delta_row = {-1, 1, 0, 0};
        int[] delta_column = {0, 0, -1, 1};
        // Go through all four directions; call recursively.
        for (int i = 0; i < 4; i++) {
            int new_row = row + delta_row[i];
            int new_column = column + delta_column[i];
            if (is_open_half) {
                if (old_horseshoe =='(') {
                    calc_balanced_path(new_row, new_column, num_open + 1, num_closed, true);
                }
                else if (old_horseshoe == ')') {
                    calc_balanced_path(new_row, new_column, num_open,num_closed  + 1, false);
                }
            }
            else {
                if (old_horseshoe == ')') {
                    calc_balanced_path(new_row, new_column, num_open, num_closed + 1, false);
                }
            }
        }
        grid[row][column] = old_horseshoe;
    }

    public static void main(String[] args) {
        // Get input grid.
        Scanner scan = new Scanner(System.in);
        grid_size = scan.nextInt();
        scan.nextLine();
        grid = new char[grid_size][grid_size];
        for (int i = 0; i < grid_size; i++) {
            String row = scan.nextLine();
            for (int j = 0; j < grid_size; j++) {
                grid[i][j] = row.charAt(j);
            }
        }
        // Call recursive method.
        calc_balanced_path(0,0, 0, 0, true);

        // Print result.
        System.out.println(longest_balanced_length);
    }
}
/*
4
(())
()((
(()(
))))


 */