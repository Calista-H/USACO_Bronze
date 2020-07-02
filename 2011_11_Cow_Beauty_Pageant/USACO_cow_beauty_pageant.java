//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=87
import java.util.*;
public class USACO_cow_beauty_pageant {
  static boolean connected(int[] x_array, int[] y_array, int size, int x, int y) {
    if (size == 0)
      return true;
    for (int i = 0; i < size; i++) {
      if (x_array[i] == x && (y_array[i] + 1 == y || y_array[i] - 1 == y))
        return true;
    }
    for (int i = 0; i < size; i++) {
      if (y_array[i] == y && (x_array[i] + 1 == x || x_array[i] - 1 == x))
        return true;
    }
    return false;
  }  
  static int distance(int[] spot1_x, int[] spot1_y, int spot1_size, int[] spot2_x, int[] spot2_y, int spot2_size, int col_size) {
    // Find minimun and maximum column posistions for spot 1.
    int spot1_min_y = col_size;
    int spot1_max_y = 0;
    int spot1_min_index = 0;
    int spot1_max_index = 0;
    for (int i = 0; i < spot1_size; i++) {
      if (spot1_y[i] < spot1_min_y) {
        spot1_min_y = spot1_y[i];
        spot1_min_index = i;
      }
      if (spot1_y[i] > spot1_max_y) {
        spot1_max_y = spot1_y[i];
        spot1_max_index = i;
      }
    } 
    
    // Find minimun and maximum column posistions for spot 2.
    int spot2_min_y = col_size;
    int spot2_max_y = 0;
    int spot2_min_index = 0;
    int spot2_max_index = 0;   
    for (int i = 0; i < spot2_size; i++) {
      if (spot2_y[i] < spot2_min_y) {
        spot2_min_y = spot2_y[i];
        spot2_min_index = i;
      }
      if (spot2_y[i] > spot2_max_y) {
        spot2_max_y = spot2_y[i];
        spot2_max_index = i;
      }
    }
    // Return the distance between two spots.
    if (spot1_min_y > spot2_max_y) {
      return spot1_min_y - spot2_max_y + Math.abs(spot1_x[spot1_min_index] - spot2_x[spot2_max_index]) - 1;
    }
    else {
      return spot2_min_y - spot1_max_y + Math.abs(spot1_x[spot1_max_index] - spot2_x[spot2_min_index]) - 1;
    }
  }
  public static void main(String[] args) {
    // Read in pattern.
    Scanner scan = new Scanner(System.in);
    int row_size = scan.nextInt();
    int col_size = scan.nextInt();
    char[][] pattern = new char[row_size][col_size];
    for (int i = 0; i < row_size; i++) {
      String string = scan.next();
      for (int j = 0; j < col_size; j++) {
        pattern[i][j] = string.charAt(j);
      }
    }
    
    // Find spot 1 and spot 2.
    int spot1_size = 0;
    int spot2_size = 0;
    int[] spot1_x = new int[row_size * col_size];
    int[] spot1_y = new int[row_size * col_size];
    int[] spot2_x = new int[row_size * col_size];
    int[] spot2_y = new int[row_size * col_size];
    // From left to right and top to bottom scan the X's.
    for (int i = 0; i < row_size; i++) {
      for (int j = 0; j < col_size; j++) {
        if (pattern[i][j] == '.')
          continue;
        if (connected(spot1_x, spot1_y, spot1_size, i, j)) {
          spot1_x[spot1_size] = i;
          spot1_y[spot1_size] = j;
          spot1_size++; 
        }
      }
    }
    // From right to left and bottom to top scan the X's.
    for (int i = row_size - 1; i >= 0; i--) {
      for (int j = col_size - 1; j >= 0; j--) {
        if (pattern[i][j] == '.')
          continue;
        if (connected(spot1_x, spot1_y, spot1_size, i, j)) {
          spot1_x[spot1_size] = i;
          spot1_y[spot1_size] = j;
          spot1_size++; 
        }
        else {
          spot2_x[spot2_size] = i;
          spot2_y[spot2_size] = j;
          spot2_size++;
        }
      }
    }

    // Find shortest distance between two spots.
    System.out.println(distance(spot1_x, spot1_y, spot1_size, spot2_x, spot2_y, spot2_size, col_size));  
  }
}
/*
 6 16
 ................
 ..XXXX....XXX...
 ...XXXX....XX...
 .XXXX......XXX..
 ........XXXXX...
 .........XXX....
 */