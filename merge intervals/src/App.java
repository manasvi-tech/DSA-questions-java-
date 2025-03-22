import java.util.Arrays;
import java.util.LinkedList;

public class App {
    public static int[][] mergeIntervals(int[][] intervals){
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }
            else{
                merged.getLast()[1] = Math.max(merged.getLast()[1],interval[1]);
            }
        }
        return merged.toArray( new int[merged.size()][]);
    }
    public static void main(String[] args) throws Exception {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = mergeIntervals(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
