

/*Given a string that consists of only 0s, 1s and 2s, count the number of substrings that have an equal number of 0s, 1s, and 2s.
Examples: 
Input: str = “0102010”
Output:  2
Explanation: Substring str[2, 4] = “102” and substring str[4, 6] = “201” has equal number of 0, 1 and 2
Input: str = “102100211”
Output: 5*/

public class Main {
    public static void main(String[] args) {
        String a1 = "0102010";
        String a2 = "102100211";
      
        int res1 = helper(a1);
        int res2 = helper(a2);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(helper("0123021"));
        
       

    }
    public static int helper(String s){
               
        int res = 0;

        for(int i = 0; i < s.length(); i++){
            int count0 = 0;int count1 = 0; int count2 = 0;
            
            for(int j = i; j < s.length(); j++){
                char c = s.charAt(j);
                if(c =='0') {
                    count0++;
                } else if (c == '1') {
                    count1++;
                } else if (c == '2') {
                    count2++;
                }
                if(count0 != 0 && count1 != 0 && count2!=0 && count0==count1 && count0 ==count2){
                    res++;
                    System.out.println(s.substring(i, j+1));
                }
            }
        }
        return res;
        

    }
}




