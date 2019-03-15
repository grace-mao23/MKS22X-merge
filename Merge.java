public class Merge {

  public static void mergesort(int[]data) {
    mergesort(data, 0, data.length-1);
  }

  private static void mergesort(int[] data, int lo, int hi) {
    if (lo >= hi) { // most likely equal, when there is only one element
      return;
    }
    int mid = (hi - lo) / 2;
    // mergesort left
    mergesort(data, lo, mid);
    // mergesort right
    mergesort(data, mid+1, hi);
    // merge into data
  }



/*  Pseudocode
    mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge  */
}
