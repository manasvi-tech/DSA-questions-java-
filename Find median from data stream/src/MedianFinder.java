import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {

    // we want to make sure either both have same number of elements or maxHeap has one more element than minHeap
    // if total elements is even we can return average of smallest of minHeap (larger elements) and largest of maxHeap (smaller elements)
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;


    public MedianFinder() {
        minHeap = new PriorityQueue<>(); // used for storing larger elements than the median
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // used for storing smaller elements than the median
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num<= maxHeap.peek()){
            maxHeap.add(num);
        }
        else{
            minHeap.add(num);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            int n = maxHeap.poll();
            minHeap.add(n);
        }

        else if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        // they have same number of elements thus average
        if(maxHeap.size() == minHeap.size()){
            return maxHeap.peek()/2.0 + minHeap.peek()/2.0;
        }
        // because maxHeap has one element extra in case of odd
        else{
            return maxHeap.peek();
        }
    }
}
