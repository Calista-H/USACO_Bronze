//Problem: http://www.usaco.org/index.php?page=viewproblem2&cpid=187
import java.util.*;
public class USACO_find_the_cow {
    static String grass_pattern;

    // Find the number of cows in N^2 time.
    static int find_cow() {
        int length = grass_pattern.length();
        int cow_counter = 0;
        for (int i = 1; i < length; i++) {
            if (grass_pattern.charAt(i - 1) == '(' &&
                grass_pattern.charAt(i) == '(') {
                // Found hind legs.
                for (int j = i + 2; j < length; j++) {
                    if (grass_pattern.charAt(j - 1) == ')' &&
                        grass_pattern.charAt(j) == ')') {
                        // Found matching front legs; increment cow counter.
                        cow_counter++;
                    }
                }
            }
        }
        return cow_counter;
    }

    // Find the number of cows in N time.
    static int find_cow_2() {
        int cow_counter = 0;
        int hind_legs_counter = 0;
        for (int i = 1; i < grass_pattern.length(); i++) {
            if (grass_pattern.charAt(i - 1) == '(' &&
                grass_pattern.charAt(i) == '(') {
                // Found hind legs; track number of hind legs found.
                hind_legs_counter++;
            }
            else if (grass_pattern.charAt(i - 1) == ')' &&
                     grass_pattern.charAt(i) == ')') {
                // Found front legs. This pair of front legs can be combined
                // with any other pair of hind legs to form a complete cow.
                // Add number of hind legs cow counter for every pair of front
                // legs found so far.
                cow_counter += hind_legs_counter;
            }
        }
        return cow_counter;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        grass_pattern = scan.nextLine();
        System.out.println(find_cow_2());
    }
}
//)((()())())