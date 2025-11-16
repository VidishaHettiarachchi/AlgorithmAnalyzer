// Member1_LinearSearch.java
import java.util.Random;


public class Member1_LinearSearch {
public static int[] generateArray(int size, long seed) {
Random rand = new Random(seed);
int[] arr = new int[size];
for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
return arr;
}


public static void linearSearch(int[] arr, int target) {
for (int v : arr) if (v == target) return;
}


public static long measureTime(int[] arr, int target) {
long start = System.nanoTime();
linearSearch(arr, target);
return System.nanoTime() - start;
}


public static void main(String[] args) {
int[] sizes = {100, 500, 1000};
long seed = 12345L; // same seed across members to use same arrays
System.out.println("Algorithm: Linear Search\nInput Size | Time (ns)\n--------------------");
for (int s : sizes) {
int[] arr = generateArray(s, seed);
int target = arr[s - 1];
System.out.printf("%d | %d\n", s, measureTime(arr, target));
}
}
}

