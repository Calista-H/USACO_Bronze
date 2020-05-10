//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=112
import java.util.*;
public class USACO_rope_folding{
  static int num_knots;
  static int rope_length;
  static int[] knot_locations;
  static boolean Foldable(int i, int j) {
    // Given two points, find the location of the fold (midpoint). Can be on knot or between knots.
    int folding_location = (knot_locations[i] + knot_locations[j]) / 2; 
    boolean done = false;
    while (!done) {
      // Keep checking if there's an equal distance from folding_location to other points 
      if (folding_location - knot_locations[i] != knot_locations[j] - folding_location) {
        return false;
      }
      // Check with next knot from each side
      i--;
      j++;
      // Check if there are no more knots left.
      if (i < 0 || j >= num_knots) {
        done = true;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Scan input of number of knots, rope lenghth, and the location of knots.
    num_knots = scan.nextInt();
    rope_length = scan.nextInt();
    knot_locations = new int[num_knots];
    for (int i = 0; i < num_knots; i++) {
      knot_locations[i] = scan.nextInt();
    }
    // Sort the knot locations from least to greatest.
    Arrays.sort(knot_locations);
    
    // Scan through all knots (besides endpoints) and check if folding is possible.
    int num_folds = 0;
    for (int i = 1;i < num_knots - 2; i++) {
      if (Foldable(i, i)) {
        num_folds++;
      }
    }
    // Check if folding between knots is possible.
    for (int i = 0; i < num_knots - 1; i++) {
      if (Foldable(i, i + 1)) {
        num_folds++;
      }
    }   
    // Print the total number of possible folds.
    System.out.println(num_folds);
  }
}
/*
 5 10
 0 10 6 2 4
 */