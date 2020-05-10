//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=807
import java.util.*;
public class USACO_teleportation {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt(); //start
    int b = scan.nextInt(); //end
    int x = scan.nextInt(); //teleporter x
    int y = scan.nextInt(); //teleporter y
    
    // Find the distance from the start to x and y.
    int distance = Math.abs(b-a); 
    int distance_ax = Math.abs(x-a); 
    int distance_ay = Math.abs(y-a);
    
    // Take the smallest distance from a to x or y.
    int distance_a = Math.min(distance_ay, distance_ax);
    // Find the distance from the end to x and y.
    int distance_bx = Math.abs(x-b);
    int distance_by = Math.abs(y-b);
    
    // Take the smallest distance from b to x or y.
    int distance_b = Math.min(distance_bx, distance_by); 
    // Find the smallest total distance if using the teleporter.
    int distance_teleporter = distance_b + distance_a; 
    
    // Compare smallest teleporter distance to distance from start to end.
    if (distance_teleporter < distance) {
      System.out.println(distance_teleporter);
    } 
    else {
      System.out.println(distance);
    }
  }
}
                          