//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=95
import java.util.*;
import java.lang.*;

public class USACO_cow_photography {
  public static class MyComparator implements Comparator<Integer> {
    public int compare(Integer cow1, Integer cow2) {
      // Count number of times cow1 is in front of cow2.
      int cow1_before_cow2_count = 0;
      for (int i = 0; i < 5; i++) {
        if (cow2pos[i].get(cow1) < cow2pos[i].get(cow2)) {
          cow1_before_cow2_count++;
        }
      }
      if (cow1_before_cow2_count >= 3)
        return -1;
      else
        return 1;
    }
  }
  
  public static void ReadPatterns(int size, Scanner scan) {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < size; j++) {
        int cow = scan.nextInt();
        cow2pos[i].put(cow, j);
        photo[j] = cow;
      }
    }
  }
  
  public static void main(String[] args) {
    // Test Test Test
    Scanner scan = new Scanner(System.in);
    int size = scan.nextInt();
    // Read in 5 patterns.
    ReadPatterns(size, scan);
    
    // Sort last pattern.
    Arrays.sort(photo, new MyComparator());
    
    // Print sorted (original) pattern.
    for (int i = 0; i < size; i++) {
      System.out.println(photo[i]);
    }
  }
  
  static HashMap<Integer, Integer>[] cow2pos = new HashMap[5];
  static Integer[] photo = new Integer[1000];
}
/* 5 
 1 2 3 4 5 
 2 1 3 4 5 
 3 1 2 4 5
 4 1 2 3 5 
 5 1 2 3 4 
 */
 
 