//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=85
import java.util.*;
public class USACO_awkward_digits_2 {
  static int Base10(String num, int base) {
    int result = 0;
    for (int i = 0; i < num.length(); i++) {
      int digit = num.charAt(i) - '0';
      result = result * base + digit;
    }
    return result;
  }
  public static void main(String[] args) {
    // Read in binary and trinary numbers.
    Scanner scan = new Scanner(System.in); 
    String binary = scan.next();
    String trinary = scan.next();
    
    // Find the common binary and trinaty candidate.
    for (int i = 0; i < binary.length(); i++) {
      // Generate binary candidate.
      char bin_char = binary.charAt(i);
      if (bin_char == '0')
        bin_char = '1';
      else
        bin_char = '0';
      String bin_modified = binary.substring(0, i) + bin_char + binary.substring(i + 1, binary.length());
      int bin_candidate = Base10(bin_modified, 2);
      
      // Generate trinary candidate.
      for (int j = 0; j < trinary.length(); j++) {
        char tri_char = trinary.charAt(j);
        for (int k = 0; k < 3; k++) { // Try possible changes (0, 1, 2) at j position.
          if (k == (tri_char - '0')) { // No change.
            continue;
          }
          
          tri_char = (char)(k + '0');
          String tri_modified = trinary.substring(0, j) + tri_char + trinary.substring(j + 1, trinary.length());
          int tri_candidate = Base10(tri_modified, 3);
          if (bin_candidate == tri_candidate) {
            System.out.println(bin_candidate);
            return;
          }
        }
      }
    }
  }
}