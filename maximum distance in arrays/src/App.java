import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static int maxDistance(List<List<Integer>> arrays) {
        if(arrays == null || arrays.size()<2){
            return 0;
        }
        int globalMin = arrays.get(0).get(0);
        int globalMax = arrays.get(0).get(arrays.get(0).size()-1);
        int dist = 0;

        for(int i=1;i<arrays.size();i++){
            int min = arrays.get(i).get(0);
            int max = arrays.get(i).get(arrays.get(i).size()-1);

            int localDist = Math.max(Math.abs(globalMin - max), Math.abs(globalMax-min));
            dist = Math.max(localDist,dist);

            globalMin = Math.min(globalMin,min);
            globalMax = Math.max(globalMax,max);
        }
        return dist;    
    }
    public static void main(String[] args) throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> arrays = new ArrayList<>();

        System.out.println("Enter the number of sublists:");
        int n = scanner.nextInt(); // Number of sublists
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("Enter elements of sublist " + (i + 1) + " separated by spaces:");
            String line = scanner.nextLine(); // Read the entire line
            String[] elements = line.split(" "); // Split the line by spaces
            
            List<Integer> sublist = new ArrayList<>();
            for (String element : elements) {
                sublist.add(Integer.parseInt(element)); // Convert to Integer and add to sublist
            }
            arrays.add(sublist); // Add sublist to the main list
        }

        System.out.println(maxDistance(arrays));
        
    }
}
