// Member3_BubbleSort.java
import java.util.Random;


public class Member3_BubbleSort {
public static int[] generateArray(int size, long seed) {
Random rand = new Random(seed);
int[] arr = new int[size];
for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
return arr;
}


public static void bubbleSort(int[] arr) {
int n = arr.length;
boolean swapped;
for (int i = 0; i < n - 1; i++) {
swapped = false;
for (int j = 0; j < n - 1 - i; j++) {
if (arr[j] > arr[j + 1]) {
int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
swapped = true;
}
}
if (!swapped) break;
}
}


public static long measureTime(int[] arr) {
long start = System.nanoTime();
bubbleSort(arr);
return System.nanoTime() - start;
}


public static void main(String[] args) {
int[] sizes = {100, 500, 1000};
long seed = 12345L;
System.out.println("Algorithm: Bubble Sort\nInput Size | Time (ns)\n--------------------");
for (int s : sizes) {
int[] arr = generateArray(s, seed);
System.out.printf("%d | %d\n", s, measureTime(arr));
}
}
}
