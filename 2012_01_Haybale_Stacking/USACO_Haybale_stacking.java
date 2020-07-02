import java.util.*;
import java.util.Arrays;
public class USACO_Haybale_stacking {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Scan in number of haystacks and instructions.
    int num_stacks = scan.nextInt();
    int[] haybales = new int[num_stacks];
    int num_instructions = scan.nextInt();
 
    // Scan start and end of instructions.
    for (int i = 0; i < num_instructions; i++) {
      int start = scan.nextInt();
      int end = scan.nextInt();
      // Update haybale values.
      for(int j = start; j <= end; j++) {
        haybales[j]++;
      }
    }
    // Sort array and find median(the middle one).
    Arrays.sort(haybales);
    System.out.println(haybales[num_stacks / 2]);
  }
}
/* 7 4
 5 5 2 4 4 6 3 5 */