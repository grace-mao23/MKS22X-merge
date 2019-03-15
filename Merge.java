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
    
  }



/*  Pseudocode
    mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge  */
}
