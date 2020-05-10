//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=85
import java.util.*;
public class USACO_awkward_digits {
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
    int[] bin_candidate = new int[(int)Math.pow(2, binary.length())];
    int[] tri_candidate = new int[(int)Math.pow(3, trinary.length())];
    
    // Find possible correct numbers from binary input.
    int index = 0;
    for (int i = 0; i < binary.length(); i++) {
      char c = binary.charAt(i);
      if (c == '0')
        c = '1';
      else
        c = '0';
      String modified = binary.substring(0, i) + c + binary.substring(i + 1, binary.length());
      bin_candidate[index++] = Base10(modified, 2);
      
    }
    int bin_size = index;
    
    // Find possible correct numbers from trinary input.
    index = 0;
    for (int i = 0; i < trinary.length(); i++) {
      char c = trinary.charAt(i);
      String modified;
      if (c == '0') {
        c = '1';
        modified = trinary.substring(0, i) + c + trinary.substring(i + 1, trinary.length());
        tri_candidate[index++] = Base10(modified, 3);
        c = '2';
        modified = trinary.substring(0, i) + c + trinary.substring(i + 1, trinary.length());
        tri_candidate[index++] = Base10(modified, 3);
      } 
      else if (c == '1') {
        c = '0';
        modified = trinary.substring(0, i) + c + trinary.substring(i + 1, trinary.length());
        tri_candidate[index++] = Base10(modified, 3);
        c = '2';
        modified = trinary.substring(0, i) + c + trinary.substring(i + 1, trinary.length());
        tri_candidate[index++] = Base10(modified, 3);
      }
      else {
        c = '0';
        modified = trinary.substring(0, i) + c + trinary.substring(i + 1, trinary.length());
        tri_candidate[index++] = Base10(modified, 3);
        c = '1';
        modified = trinary.substring(0, i) + c + trinary.substring(i + 1, trinary.length());
        tri_candidate[index++] = Base10(modified, 3);
      }
    }
    int tri_size = index;
    
    // Find the common number in both arrays.
    for (int i = 0; i < bin_size; i++) {
      for (int j = 0; j < tri_size; j++) {
        if (bin_candidate[i] == tri_candidate[j]) {
          System.out.println(bin_candidate[i]);
          break;
        }
      }
    }
  }
}