


public class test {
    
    public static void main(String[] args) {
        
        String a = reverseString("i love programming very much");
        System.out.println(a);
    }

    public static int panlindrom(String s){
        if(s.isEmpty()){
            return 0;
        }
        
        int n = s.length();
    
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        
        for (int i = n-2; i >=0; i--) {
            for(int j = i + 1; j <n;j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j-1])+1;
                }
            }
        }
        
        
        return dp[0][n-1];
       
    }

    public static String reverseString(String s) {
        
        String[] str = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = str.length-1; i >= 0; i--) {
            sb.append(str[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }
    
}
