//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=105
import java.util.*;
public class USACO_grazing_patterns {
  static int[][] barren_area = new int[5][5];
  static int num_barren_patches = 0;
  
  static int count(int i, int j) {
    // base case (out of bounds or barren)
    if (i < 0 || i > 4 || j < 0 || j > 4 || barren_area[i][j] == 1){
      return 0;
    }
    // base case (reached the end and covered all patches)
    if (i == 4 && j == 4 && num_barren_patches == 24) {
      return 1;
    }
    // recursive case
    barren_area[i][j] = 1;  // Set the current patch to barren.
    num_barren_patches++; // Incriment number of barren patches.
    // Keep counting the number of paths from adjacent patches.
    int num_paths = count(i - 1, j) + count(i + 1, j) + count(i, j - 1) + count(i, j + 1);
    barren_area[i][j] = 0; // Restore the previous patch to non-barren.
    num_barren_patches--; // Decriment the number of barren patches.
    
    return num_paths;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Get input
    num_barren_patches = scan.nextInt();
    for(int i = 0; i < num_barren_patches; i++) {
      // Read in coordinates of barren patches.
      int row = scan.nextInt();
      int column = scan.nextInt();
      barren_area[row - 1][column - 1] = 1; 
    }
    
    // Count number of paths to get from (0, 0) to (4, 4)
    int num_paths = count(0, 0);
    System.out.println(num_paths);
  }
}
/*
 4 
 3 2
 3 3
 3 4 
 3 1
 */