// Member2_BinarySearch.java
import java.util.Arrays;
import java.util.Random;


public class Member2_BinarySearch {
public static int[] generateArray(int size, long seed) {
Random rand = new Random(seed);
int[] arr = new int[size];
for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
return arr;
}


public static int binarySearch(int[] arr, int target) {
int l = 0, r = arr.length - 1;
while (l <= r) {
int m = l + (r - l) / 2;
if (arr[m] == target) return m;
if (arr[m] < target) l = m + 1; else r = m - 1;
}
return -1;
}


public static long measureTime(int[] arr, int target) {
long start = System.nanoTime();
binarySearch(arr, target);
return System.nanoTime() - start;
}


public static void main(String[] args) {
int[] sizes = {100, 500, 1000};
long seed = 12345L;
System.out.println("Algorithm: Binary Search\nInput Size | Time (ns)\n--------------------");
for (int s : sizes) {
int[] arr = generateArray(s, seed);
Arrays.sort(arr);
int target = arr[s - 1];
System.out.printf("%d | %d\n", s, measureTime(arr, target));
}
}
}