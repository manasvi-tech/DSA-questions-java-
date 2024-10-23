public class App {
    private static int[] productOfArrayExceptSelf(int[] arr){

        int n = arr.length;

        // to store the output
        int[] output = new int[n]; 
        

        //there is no prefix of the first element
        output[0] = 1;

        // calculating prefix and suffix respectively
        for(int i=1;i<n;i++){
            output[i] = output[i-1]*arr[i-1];
        }

        int rightProduct = 1;

        // taking the products of suffixes now
        for(int i=n-1;i>=0;i--){
            output[i] = rightProduct*output[i];
            rightProduct = rightProduct*arr[i];
        }

        return output;
    }
    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{1,2,3,4};

        int[] ans = productOfArrayExceptSelf(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
}
