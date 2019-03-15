public class Merge {

  public static void mergesort(int[]data) {
    mergesort(data, 0, data.length-1);
  }

  private static void mergesort(int[] data, int lo, int hi) {
    if (lo >= hi) { // most likely equal, when there is only one element
      return;
    }
    int half = data.length / 2;
    // mergesort left --> making left array
    int[] left = new int[half];
    for (int i = 0; i <= left.length; i++) {
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
    for (int i = 0; i < left.length; i++) {
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
    }
  }



/*  Pseudocode
    mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge  */
}
