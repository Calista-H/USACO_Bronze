//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=103
import java.util.*;
public class USACO_Gifts{
  static int[] price;
  static int[] shipping;
  static int cows;
  
  // Sort sum of price and shipping from least to greatest.
  static void sort_by_price_and_shipping(){
    for (int i = 0; i < cows; i++) {
      for (int j = i + 1; j < cows; j++) {
        if (price[i] + shipping[i] > price[j] + shipping[j]) {
          int temp_price = price[i];
          int temp_shipping = shipping[i];
          price[i] = price[j];
          shipping[i] = shipping[j];
          price[j] = temp_price;
          shipping[j] = temp_shipping;
        }
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    cows = scan.nextInt();
    int budget = scan.nextInt();
    price = new int[cows];
    shipping = new int[cows];
    
    // Read in data for price and shipping.
    for (int i = 0; i < cows; i++) {
      price[i] = scan.nextInt();
      shipping[i] = scan.nextInt();
    }
    
    // Sort price and shipping arrays by sum of price and shipping.
    sort_by_price_and_shipping();
    
    // Iterate each cow and apply the coupon to the cow and satisfy the 
    // max number of remaining cows using the remaining budget. Keep a 
    // counter for the global max_gifted_cows.
    int max_gifted_cows = 0;
    for (int i = 0; i < cows; i++) {
      int remaining_money = budget;
      int gifted_cows = 0;
      // Apply the coupon to i-th cow.
      if (budget > price[i] / 2 + shipping[i]) {
        remaining_money = budget - price[i] / 2 - shipping[i];
        gifted_cows = 1;
      } else {
        break;
      }
      // Use the remaining money to satisfy the remaining cows.
      for (int j = 0; j < cows; j++) {
        if (j == i) {
          continue;
        }
        if (remaining_money > price[j] + shipping[j]) {
          remaining_money -= price[j] + shipping[j];
          gifted_cows++;
        } else {
          break;
        }
      }
      
      // Update the gloal max_gifted_cow if needed.
      if (gifted_cows > max_gifted_cows) {
        max_gifted_cows = gifted_cows;
      }
    }
    System.out.println(max_gifted_cows);
  }
}