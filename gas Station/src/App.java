// sum of gas array has to be equal or greater than cost array
// if the total ever becomes 0 we move to new position
// the first positive value in the diff array is gonna work for us because we know 
// for a fact that there exists a solution. and we are able to reach the end due to the first positive value
// which means that is our answer right there. No need to loop through again

import java.util.Scanner;

public class App {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sumGas = 0;
        int sumCost = 0;
        for(int i=0;i<n;i++){
            sumGas+=gas[i];
            sumCost+=cost[i];
        }
        if(sumGas<sumCost) return -1;

        int total = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            total += (gas[i]-cost[i]);

            if(total<0){
                total = 0;
                ans = i+1;
            }
        }

        return ans;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of stations");
        int n = sc.nextInt();

        int[] gas = new int[n];
        int[] cost = new int[n];

        System.out.println("Enter the gas filled on each station");
        for(int i=0;i<n;i++){
            gas[i] = sc.nextInt();
        }

        System.out.println("Enter the cost of reaching each station");
        for(int i=0;i<n;i++){
            cost[i] = sc.nextInt();
        }

        System.out.println(canCompleteCircuit(gas, cost));
    }
}
