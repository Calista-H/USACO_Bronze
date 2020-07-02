//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=615
import java.util.*;
public class USACO_Milk_pails {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    int y = scan.nextInt();
    int m = scan.nextInt();
    int max_total = 0;
    // Go through all possibilities of multiples of x and y and find the maximum milk less than m.
    for (int b = 0 ; y * b <= m; b++){ // b is number of y's
      for (int a = 0; y * b + x * a <= m; a++){ // a is number of x's
        if (a * x + b * y > max_total)
          max_total = a * x + b * y;
      }
    }  
    System.out.println(max_total); 
  }
}