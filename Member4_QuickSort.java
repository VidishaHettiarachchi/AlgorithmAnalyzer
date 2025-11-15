// Member4_QuickSort.java
import java.util.Random;


public class Member4_QuickSort {
public static int[] generateArray(int size, long seed) {
Random rand = new Random(seed);
int[] arr = new int[size];
for (int i = 0; i < size; i++) arr[i] = rand.nextInt(10000);
return arr;
}


public static void quickSort(int[] arr, int low, int high) {
if (low < high) {
int p = partition(arr, low, high);
quickSort(arr, low, p - 1);
quickSort(arr, p + 1, high);
}
}


private static int partition(int[] arr, int low, int high) {
int pivot = arr[high];
int i = low - 1;
for (int j = low; j < high; j++) {
if (arr[j] <= pivot) {
i++;
int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
}
}
int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
return i + 1;
}


public static long measureTime(int[] arr) {
long start = System.nanoTime();
quickSort(arr, 0, arr.length - 1);
return System.nanoTime() - start;
}


public static void main(String[] args) {
int[] sizes = {100, 500, 1000};
long seed = 12345L;
System.out.println("Algorithm: Quick Sort\nInput Size | Time (ns)\n--------------------");
for (int s : sizes) {
int[] arr = generateArray(s, seed);
System.out.printf("%d | %d\n", s, measureTime(arr));
}
}
}
