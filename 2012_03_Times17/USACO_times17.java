//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=121
import java.util.*;
public class USACO_times17 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Get the number.
    String number = scan.next();

    // Get 16 times of the number in string format.
    String number16 = number + "0000";
    
    // Add 16 times of the number with the original number.
    String result = "";
    number = "0000" + number;
    int length = number.length();
    int carry_over = 0;
    for (int i = length - 1; i >= 0; i--) {
      int digit1 = number.charAt(i) - '0';
      int digit2 = number16.charAt(i) - '0';
      
      int sum = digit1 + digit2 + carry_over;
      if (sum < 2) {
        carry_over = 0;
        result = (char)(sum + '0') + result;
      }
      else {
        carry_over = 1;
        sum -= 2;
        result = (char)(sum + '0') + result;        
      }
    }
    if (carry_over > 0) {
      result = '1' + result;
    }
    
    // Print the result.
    System.out.println(result);
    
  }
}
//10110111