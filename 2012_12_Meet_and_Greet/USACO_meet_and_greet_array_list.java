//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=205
import java.util.*;
public class USACO_meet_and_greet_array_list {
    // Update cow_location array per units, directions, and starting times.
    static void update_location(int time_units, int direction, int starting_time,
                                ArrayList<Integer> cow_location) {
        for (int i = 0; i < time_units; i++) {
            if (direction == 'R') {
                cow_location.add(cow_location.get(cow_location.size() - 1) + 1);
            } else {
                cow_location.add(cow_location.get(cow_location.size() - 1) - 1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num_bessie_moves = scan.nextInt();
        int num_elsie_moves = scan.nextInt();
        int time = 0;
        ArrayList<Integer> bessie_location = new ArrayList<Integer>();
        ArrayList<Integer> elsie_location = new ArrayList<Integer>();
        int moo_counter = 0;

        // Scan in Bessie's moves and update her location array.
        bessie_location.add(0);
        for (int i = 0; i < num_bessie_moves; i++){
            int bessie_unit = scan.nextInt();
            String move = scan.nextLine();
            char bessie_direction = move.charAt(1);
            update_location(bessie_unit, bessie_direction, time, bessie_location);
            time += bessie_unit;
        }

        // Scan in Elsie's moves and update her location array.
        time = 0;
        elsie_location.add(0);
        for (int i = 0; i < num_elsie_moves; i++){
            int elsie_unit = scan.nextInt();
            String move = scan.nextLine();
            char elsie_direction = move.charAt(1);
            update_location(elsie_unit, elsie_direction, time, elsie_location);
            time += elsie_unit;
        }

        // Fill in extra locations to reflect any cow standing still.
        int max_size = Math.max(bessie_location.size(), elsie_location.size());
        for (int i = bessie_location.size(); i < max_size; i++) {
            bessie_location.add(bessie_location.get(bessie_location.size() - 1));
        }
        for (int i = elsie_location.size(); i < max_size; i++) {
            elsie_location.add(elsie_location.get(elsie_location.size() - 1));
        }

        // Check if Elsie and Bessie meet and count the number of interactions.
        for (int i = 1; i < max_size + 1; i++) {
            if (bessie_location.get(i) == elsie_location.get(i) &&
                bessie_location.get(i - 1) != elsie_location.get(i - 1) ) {
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