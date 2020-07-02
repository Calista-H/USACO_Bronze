//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=94
import java.util.*;
public class USACO_hay_bales {
  // Find the equal height each bale should have (the average).
  static int Equal_Height(int size, int[] hay_bales) {
    int sum = 0;
    for (int i = 0; i < size; i++) {
      sum = hay_bales[i] + sum;
    }
    return sum / size;
  }
  
  // Determine the minimum moved.
  static int Number_Moved(int size, int[] hay_bales, int average_height) {
    int moved = 0;
    for (int i = 0; i < size; i++) {
      if (hay_bales[i] > average_height) {
        moved = moved + (hay_bales[i] - average_height);
      }
    }
    return moved;
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int size = scan.nextInt();
    int[] hay_bales = new int[size];
    // Scan input into array.
    for (int i = 0; i < size; i++) {
      hay_bales[i] = scan.nextInt();
    }
    // Output the number moved.
    int average_height = Equal_Height(size, hay_bales);
    System.out.println(Number_Moved(size, hay_bales, average_height));
  }
}