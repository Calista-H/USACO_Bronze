//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=205
import java.util.*;
public class USACO_meet_and_greet {
    // Update cow_location array per units, directions, and starting times.
    static void update_location(int time_units, int direction, int starting_time, int[] cow_location) {
        for (int i = 0; i < time_units; i++) {
            if (direction == 'R') {
                cow_location[i + starting_time + 1] = cow_location[i + starting_time] + 1;
            } else {
                cow_location[i + starting_time + 1] = cow_location[i + starting_time] - 1;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_bessie_moves = scan.nextInt();
        int num_elsie_moves = scan.nextInt();
        int time = 0;
        int[] bessie_location = new int[1000000];
        int[] elsie_location = new int[1000000];
        int moo_counter = 0;
        int bessie_time = 0;
        int elsie_time = 0;

        // Scan in Bessie's moves and update her location array.
        for (int i = 0; i < num_bessie_moves; i++){
            int bessie_unit = scan.nextInt();
            String move = scan.nextLine();
            char bessie_direction = move.charAt(1);
            update_location(bessie_unit, bessie_direction, time, bessie_location);
            time += bessie_unit;
        }
        bessie_time = time;

        // Scan in Elsie's moves and update her location array.
        time = 0;
        for (int i = 0; i < num_elsie_moves; i++){
            int elsie_unit = scan.nextInt();
            String move = scan.nextLine();
            char elsie_direction = move.charAt(1);
            update_location(elsie_unit, elsie_direction, time, elsie_location);
            time += elsie_unit;
        }
        elsie_time = time;

        // Fill in extra locations to reflect any cow standing still.
        for (int i = bessie_time + 1; i < Math.max(bessie_time, elsie_time) + 1; i++) {
            bessie_location[i] = bessie_location[i - 1];
        }
        for (int i = elsie_time + 1; i < Math.max(bessie_time, elsie_time) + 1; i++) {
            elsie_location[i] = elsie_location[i - 1];
        }

        // Check if Elsie and Bessie meet and count the number of interactions.
        for (int i = 1; i < Math.max(bessie_time, elsie_time) + 1; i++) {
            if (bessie_location[i] == elsie_location[i] &&
                bessie_location[i - 1] != elsie_location[i - 1] ) {
                moo_counter ++;
            }
        }

        System.out.println(moo_counter);
    }
}
/*
4 5
3 L
5 R
1 L
2 R
4 R
1 L
3 L
4 R
2 L
 */