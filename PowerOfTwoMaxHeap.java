import java.util.*;

public class PowerOfTwoMaxHeap {


 private int x;

 private List<Integer> data;

 public PowerOfTwoMaxHeap(int x) {

   if (x <= 0) {

     throw new IllegalArgumentException("x must be greater than 0");

   }

   this.x = x;

   this.data = new ArrayList<Integer>();

 }

 public void insert(int value) {

   data.add(value);

   int index = data.size() - 1;

   int parentIndex = (index - 1) / 2;

   while (parentIndex >= 0 && data.get(parentIndex) < value) {

     Collections.swap(data, parentIndex, index);

     index = parentIndex;

     parentIndex = (index - 1) / 2;

   }

 }

 public int popMax() {

   if (data.size() == 0) {

     throw new NoSuchElementException("heap is empty");

   }

   int max = data.get(0);

   Collections.swap(data, 0, data.size() - 1);

   data.remove(data.size() - 1);

   int index = 0;

   while (index < data.size()) {

     int leftChildIndex = 2 * index + 1;

     int rightChildIndex = 2 * index + 2;

     int leftChild = Integer.MIN_VALUE;

     int rightChild = Integer.MIN_VALUE;

     if (leftChildIndex < data.size()) {

       leftChild = data.get(leftChildIndex);

     }

     if (rightChildIndex < data.size()) {

       rightChild = data.get(rightChildIndex);

     }

     if (Math.max(leftChild, rightChild) <= data.get(index)) {

       break;

     } else if (leftChild >= rightChild) {

       Collections.swap(data, index, leftChildIndex);

       index = leftChildIndex;

     } else {

       Collections.swap(data, index, rightChildIndex);

       index = rightChildIndex;

     }

   }

   return max;

 }

}
