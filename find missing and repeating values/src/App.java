import java.util.Scanner;

public class App {
    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        long sum = 0;
        long sqrSum = 0;
        long total = n * n;

        // calculate sum and square sum
        for (int row = 0; row < n; ++row) {
            for (int col = 0; col < n; ++col) {
                sum += grid[row][col];
                sqrSum += (long) grid[row][col] * grid[row][col];
            }

        }
        // refer to formulaes in notebook
        // Expected sum: n(n+1)/2, Expected square sum: n(n+1)(2n+1)/6
        long sumDiff = sum - (total * (total + 1)) / 2;
        long sqrDiff = sqrSum - (total * (total + 1) * (2 * total + 1)) / 6;

        // Using math: If x is repeated and y is missing
        // sumDiff = x - y
        // sqrDiff = x² - y²
        int repeat = (int) (sqrDiff / sumDiff + sumDiff) / 2;
        int missing = (int) (sqrDiff / sumDiff - sumDiff) / 2;
        
        return new int[] { repeat, missing };
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the grid (n): ");
        int n = scanner.nextInt();
        int[][] grid = new int[n][n];

        System.out.println("Enter the elements of the grid: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int[] result = findMissingAndRepeatedValues(grid);
        System.out.println("Repeated value: " + result[0]);
        System.out.println("Missing value: " + result[1]);

        scanner.close();
    }
}
