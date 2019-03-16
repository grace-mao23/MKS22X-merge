import java.util.*;

public class Merge {

  public static void mergesort(int[]data) {
    mergesort(data, 0, data.length-1);
  }

  private static void mergesort(int[] data, int lo, int hi) {
    if (lo >= hi) { // most likely equal, when there is only one element
      return;
    }
    System.out.println(Arrays.toString(data));
    int half = data.length / 2;
    // mergesort left --> making left array
    int[] left = new int[half];
    for (int i = 0; i < left.length; i++) {
      left[i] = data[i];
    }
    mergesort(left, 0, left.length-1);
    // mergesort right --> making right array
    int[] right = new int[data.length - half];
    for (int i = 0; i < right.length; i++) {
      right[i] = data[i+half];
    }
    mergesort(right, 0, right.length-1);
    // merge right and left into data
    int index = 0; // index being replaced in data
    int indexL = 0;
    int indexR = 0;
    while (index < data.length) {
      if (indexL >= left.length) {
        data[index] = right[indexR];
        indexR++;
        index++;
      } else if (indexR >= right.length) {
        data[index] = left[indexL];
        indexL++;
        index++;
      } else if (left[indexL] <= right[indexR]) {
        data[index] = left[indexL];
        indexL++;
        index++;
      } else {
        data[index] = right[indexR];
        indexR++;
        index++;
      }
    }
    /*for (int i = 0; i < left.length; i++) {
      // checking which to put first
      if (left[i] <= right[i]) {
        data[index] = left[i];
        data[index+1] = right[i];
        index += 2;
      } else {
        data[index] = right[i];
        data[index+1] = left[i];
        index += 2;
      }
      // taking care of extra element
      if (i == left.length - 1 && right.length > left.length) {
        data[index] = right[right.length-1];
      }
    } */
    System.out.println("M: "+Arrays.toString(data));
  }

  public static void main(String[] args) {
    int[] t = new int[] { 2, 5, 3, 8, 1, 9, 0, 4, 7 };
    Merge.mergesort(t);
    System.out.println(Arrays.toString(t));
  }


/*  Pseudocode
    mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge  */
}
