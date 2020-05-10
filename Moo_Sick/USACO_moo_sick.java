//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=86
import java.util.*;
public class USACO_moo_sick {
  static boolean transposable(int[] candidate, int[] ruminant, int ruminant_size) {
    Arrays.sort(candidate);
    Arrays.sort(ruminant);
    int first_diff = candidate[0] - ruminant[0];
    for (int i = 1; i < ruminant_size; i++) {
      int difference = candidate[i] - ruminant[i];
      if (difference != first_diff) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    // Read in the number of notes.
    int num_notes = scan.nextInt();
    
    // Read in the notes and ruminant chord.
    int[] notes = new int[num_notes];
    for (int i = 0; i < num_notes; i++) {
      notes[i] = scan.nextInt();
    }
    int ruminant_size = scan.nextInt();
    int ruminant[] = new int[ruminant_size];
    for (int i = 0; i < ruminant_size; i++) {
      ruminant[i] = scan.nextInt();
    }
    
    // Find each candidate and check if transposable.
    int[] index = new int[num_notes];
    int counter = 0;
    for (int i = 0; i < num_notes - ruminant_size + 1; i++) {
      // Create candidate array.
      int[] candidate = new int[ruminant_size];
      for (int j = 0; j < ruminant_size; j++) {
        candidate[j] = notes[i + j];
      }
      // Call transposable method.
      if (transposable(candidate, ruminant, ruminant_size)) {
        index[counter] = i + 1;
        counter++;
      }
    }
    
    // Print counter and index.
    System.out.println(counter);
    for (int i = 0; i < counter; i++) {
      System.out.println(index[i]);
    }
  }
}