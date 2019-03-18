import java.util.*;

public class Merge {

  public static void mergesort(int[]data) {
    int[] temp = new int[data.length];
    for (int i = 0; i < data.length; i++) {
      temp[i] = data[i];
    }
    mergeQ(data, temp, 0, data.length-1);
  }

  private static void mergesort(int[] data, int lo, int hi) {
    if (lo >= hi) { // most likely equal, when there is only one element
      return;
    }
  //  System.out.println(Arrays.toString(data));
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
  }

  private static void mergeQ(int[] data, int[] temp, int lo, int hi) {
    if (lo >= hi) { // most likely equal, when there is only one element
      return;
    }
    int half = (hi + lo) / 2;
    mergeQ(temp, data, lo, half);
    mergeQ(temp, data, half + 1, hi);
    // merge right and left into data
    int index = lo; // index being replaced in data
    int indexL = lo; // 0
    int indexR = half+1; // 1
    while (index <= hi) {
      if (indexR > hi) {
        data[index] = temp[indexL];
        indexL++;
      } else if (indexL > half) {
        data[index] = temp[indexR];
        indexR++;
      } else if (temp[indexL] <= temp[indexR]) {
        data[index] = temp[indexL];
        indexL++;
      } else {
        data[index] = temp[indexR];
        indexR++;
      }
      index++;
    }
    //System.out.println(Arrays.toString(data)+" , " + Arrays.toString(temp));
  }

  public static void main(String[]args){
    int[] test = new int[] { 2, 5, 6, 1, 0, 7, 3, 8, 4 };
    int[] t = new int[] { 5, 2 };
    Merge.mergesort(test);
    System.out.println(Arrays.toString(test));
    /* System.out.println("Size\t\tMax Value\tmerge/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    } */
  }





/*  Pseudocode
    mergesort(data,lo,hi):
    if lo >= hi :
      return
    mergesort left side
    mergesort right side
    merge  */
}
