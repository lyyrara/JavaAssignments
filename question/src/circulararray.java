

public class circulararray {
    
    public static void main(String[] args) {
        int[] endNote = new int[]{1,5,10,5};
        int n = 10;
        int max_value = circularArray(n,endNote);
        System.out.println(max_value);

    }
    public static int circularArray(int n, int[] endNode){
        int m = endNode.length;
        int[] count = new int[n+1];
        for (int i = 0; i < m-1; i++) {
            int start = endNode[i];
            int end = endNode[i+1];
            if(start <= end){
                for (int j = start; j <= end; j++) {
                    count[j]++;
                }
            }
            else{
                for (int j = start; j <= n; j++) {
                    count[j]++;
                }
                for (int j = 1; j <= end; j++) {
                    count[j]++;
                }
            }
            
        }
        int max_value = 0;
        int max_number = 0;
        for (int i = 1; i <= n; i++) {
            if (max_value < count[i]) {
                max_value = count[i];
                max_number = i;
            }
        }
        return max_number;
    }
}

