public class App {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.min(v1.length,v2.length);
        
        for(int i=0;i<len;i++){
            int s1 = Integer.parseInt(v1[i]);
            int s2 = Integer.parseInt(v2[i]);
         
            if(s1<s2) return -1;
            else if (s2<s1) return 1;
        }

        // they have been both equal till the end of the smaller array
        if(len<v1.length){      
            int i = len;
            while(i<v1.length){
                if(Integer.parseInt(v1[i++])!=0) return 1;
            }
        }

        if(len<v2.length){
            int i = len;
            while(i<v2.length){
                if(Integer.parseInt(v2[i++])!=0) return -1;
            }
        }

        return 0;
    }
    public static void main(String[] args) throws Exception {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.print("Enter first version: ");
        String version1 = sc.nextLine();
        System.out.print("Enter second version: ");
        String version2 = sc.nextLine();
        App app = new App();
        int result = app.compareVersion(version1, version2);
        System.out.println("Comparison result: " + result);
        sc.close();
    }
}
