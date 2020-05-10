//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=96
import java.util.*;
public class USACO_escaping_the_farm {
  static int num_cows;
  static int[] cow_weights;
  // maximum number of cow weights added without carrying
  static int max_no_carry = 0;
  
  // Check if two numbers can be added without carrying.
  static boolean has_carries(int x, int y) {
    while (x > 0 || y > 0) {
      if (x % 10 + y % 10 > 9) {
        return true;
      }
      else {
        x = x / 10;
        y = y / 10;
      }
    }
    return false;
  }
  
  static void calculate_max_no_carry(int cow_id, int sum_so_far, int size_so_far) {
    // base case
    if (cow_id >= num_cows) {
      return;
    }
    
    // recursive case 
    if (has_carries(cow_weights[cow_id], sum_so_far) == false){ // no carry over
      if (size_so_far + 1 > max_no_carry) {
        max_no_carry = size_so_far + 1;
      }
      // Add the current cow to the cow subset.
      calculate_max_no_carry(cow_id + 1, sum_so_far + cow_weights[cow_id],
                             size_so_far + 1); 
    }
    
    // Don't add the current cow to the cow subset.
    calculate_max_no_carry(cow_id + 1, sum_so_far, size_so_far);
  }
  
  public static void main(String[] args) {
    // Scan through all cow cow_weights.
    Scanner scan = new Scanner(System.in);
    num_cows = scan.nextInt();
    cow_weights = new int[num_cows];
    for (int i = 0; i < num_cows; i++) {
      cow_weights[i] = scan.nextInt();
    }
    
    // Check maximum number of cow cow_weights that add up without carrying.
    calculate_max_no_carry(/*cow_id*/0, /*sum_so_far*/0, /*size_so_far*/0);
    System.out.println(max_no_carry);
  }
}

/*  5 9 2 7 811 6 
 3
 5 522 6 84 7311 19
 3
 6 2 5 899 61 312 101
 4
*/
 