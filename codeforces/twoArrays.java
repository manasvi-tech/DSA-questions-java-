import java.util.*;

public class twoArrays {

    private static void swap(int i, int[] a, int[] b){

    }

    private static int uniqueArrays(int size, int[] a, int[] b){

        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a,b) -> b[1] - a[1]); // to get the maximum freq element at any point
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b) -> b[1] - a[1]); 

        for(int i=0;i<size;i++){
            map1.put(a[i],map1.getOrDefault(a[i],0)+1);
            map2.put(a[i],map2.getOrDefault(b[i],0)+1);
        }

        for(int key : map1.keySet()){
            int val = map1.get(key);
            pq1.offer(new int[]{key,val});
        }

        for(int key : map2.keySet()){
            int val = map2.get(key);
            pq2.offer(new int[]{key,val});
        }

        while(){
            
        }
        
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int size = sc.nextInt();
            int[] a = new int[size];
            int[] b = new int[size];

            System.out.println(uniqueArrays(size, a, b));

            for(int x=0;x<size;x++){
                System.out.println(a[x]+" ");
            }

            for(int x=0;x<size;x++){
                System.out.println(b[x]+" ");
            }
        }
        
    }      
}
