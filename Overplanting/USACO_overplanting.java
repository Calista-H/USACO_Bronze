//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=113
import java.util.*;
public class USACO_overplanting {
  static int planted_rectangles = 0;
  static boolean area[][] = new boolean[20000][20000];
  
  // Mark the area for the give rectangle coordinates.
  static void mark_area(int upper_left_x, int upper_left_y, int lower_right_x, int lower_right_y) {
    int x_distance = lower_right_x - upper_left_x; // number of columns
    int y_distance = upper_left_y - lower_right_y; // number of rows
    for (int i = 0; i < y_distance; i++) { // iterate through rows
      for (int j = 0; j < x_distance; j++) { // iterate through columns
        // Add 10000 to convert negative cordinates into positive. Mark converted coordinates as planted.
        area[i - upper_left_y + 10000][j + upper_left_x + 10000] = true; 
      }
    }
  }
  
  // Count the marked area.
  static int count_area() {
    int counter = 0;
    for (int i = 0; i < 20000; i++) {
      for (int j = 0; j < 20000; j++) {
        if (area[i][j] == true) {
          counter++;
        }
      }
    }
    return counter;
  }
  public static void main(String[] args) {
    // Read in planted rectangles and mark the area.
    Scanner scan = new Scanner(System.in);
    planted_rectangles = scan.nextInt();
    for (int i = 0; i < planted_rectangles; i++) {
      int upper_left_x = scan.nextInt();
      int upper_left_y = scan.nextInt();
      int lower_right_x = scan.nextInt();
      int lower_right_y = scan.nextInt();
      mark_area(upper_left_x, upper_left_y, lower_right_x, lower_right_y);
    }
    
    // Count marked area.
    int planted_area = count_area();
    System.out.println(planted_area);
  }
}
/*
 2
 0 5 4 1
 2 4 6 2
 */