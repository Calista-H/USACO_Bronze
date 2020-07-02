//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=122
import java.util.*;
public class USACO_connect_the_cows {
  static int num_cows;
  static int x[];
  static int y[]; 
  static int num_valid_patterns = 0;
  static int[] placed_pattern;
  
  // Check if pattern of cows is a valid pattern.
  static boolean is_valid_pattern() { 
    for (int i = 0 ; i < num_cows + 1; i++) {
      // If current cow and next cow are diagonal, it's an invalid pattern.
      if (x[placed_pattern[i]] != x[placed_pattern[i + 1]] &&
          y[placed_pattern[i]] != y[placed_pattern[i + 1]]) {
        return false;
      }
    }
    // If reached here, the pattern is valid.
    for (int i = 0; i < num_cows + 2; i++) {
      System.out.print(placed_pattern[i] + " ");
    }
    System.out.println();
    return true;
  }
  
  // Generate all possible cow visiting patterns and check if they're valid.
  static void generate_permutations(int placed_so_far) {
    // base case
    if (placed_so_far == num_cows) { // We are done placing all the cows.
      placed_pattern[num_cows + 1] = 0; // Add an imaginary cow to the end.
      if (is_valid_pattern()) {
        num_valid_patterns++;
      }
    }
    // recursive case
    for (int i = placed_so_far + 1; i <= num_cows; i++) { // Try each remaining cow.
      // Swap cow at position i with cow at position placed_so_far + 1.
      int temp = placed_pattern[placed_so_far + 1];
      placed_pattern[placed_so_far + 1] = placed_pattern[i];
      placed_pattern[i] = temp;
      
      // Recursively generate the next permutation.
      generate_permutations(placed_so_far + 1);
      
      // Swap back cow at position i with cows at position placed_so_far + 1.
      placed_pattern[i] = placed_pattern[placed_so_far + 1];
      placed_pattern[placed_so_far + 1] = temp;
    }
  }
  
  public static void main(String[] args) {
    // Scan input data.
    Scanner scan = new Scanner(System.in);
    num_cows = scan.nextInt();
    x = new int[num_cows + 1];
    y = new int[num_cows + 1];
    for (int i = 1; i <= num_cows; i++) {
      x[i] = scan.nextInt();
      y[i] = scan.nextInt();  
    }
    
    // Imaginary cow 0 is positioned at origin.
    x[0] = 0;
    y[0] = 0;
    // Create placed_pattern array with two extra positions
    // for the beginning and end imaginary cow.
    placed_pattern = new int[num_cows + 2];
    placed_pattern[0] = 0; // Place the imaginary cow at the beginning.
    // Initialize all the cow positions.
    for (int i = 1; i <= num_cows; i++) {
      placed_pattern[i] = i;
    }
    
    // Generate all cow visiting permutations and count how many are valid.
    generate_permutations(0);
    
    // Print the number of valid patterns.
    System.out.println(num_valid_patterns);
  }
}
  /* 
   4
   0 1 2 1 2 0 2 -5
   */