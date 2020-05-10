//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=114
import java.util.*;
public class USACO_moo {
  static int n;
  
  // Find the length of the k-th sequence.
  static int length(int k) {
    // base case
    if (k <= 0) {
      return 0;
    }
    
    // recursive case
    return 2 * length(k - 1) + k + 3; // length = 2(k-1) + k + 3
  }
  
  // Find the n-th character in k-th sequence
  static char find_character(int n, int k) {
    // recursive case
    if (n > length(k)) { // if n > length of current sequence, check the next sequence
      return find_character(n, k + 1);
    }
    // current sequence consists of 1) previous sequence, 2) m and k + 2 o's, and 3) previous sequence
    int prev_length = length(k - 1);
    if (n <= prev_length) { // 1) part
      return find_character(n, k - 1);
    }
    if (n > prev_length + k + 3) { // 3) part
      return find_character(n - prev_length - k - 3, k - 1);
    }
    return n - prev_length == 1 ? 'm' : 'o'; // 2)part
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    System.out.println(find_character(n, 0));
  }
}