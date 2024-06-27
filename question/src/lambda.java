import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;



public class lambda {
    public static void main(String[] args) {
   /*      Consumer<Integer> amount = year-> {
            if(year < 5){
                System.out.println(year);
            }
            else{
                System.out.println(year*2);
            }
            
        }

        yamount.accept(9);
        
        ArrayList<String> names = new ArrayList<>();
        names.add("e");
        names.add("abc");
        names.add("edfgc");
        Supplier<ArrayList<Integer>> s = ()->{
            ArrayList<Integer> res = new ArrayList<>();
            for(String name: names){
                res.add(name.length());
            }
            return res;

        };
        System.out.println(s.get());

        Predicate<Integer> checkeven = num ->{
            if(num %2 == 0){
                return true;
            }
            else return false;
        };*/
        
        // 1. Write a Java program to implement a lambda expression to find the sum of two integers.
        BiFunction<Integer, Integer, Integer> sum = (x,y)->{
            return x+y;
        };
        System.out.println(sum.apply(1,5));
        


        //2. Write a Java program to implement a lambda expression to check if a given string is empty.
        Predicate<String> checkempty = s ->{
            return s.isEmpty();
        };
        String s1 = "efc";
        String s2 = "";
        System.out.println(checkempty.test(s1));
        System.out.println(checkempty.test(s2));


        //3. Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
        Function<List<String>, List<String>> upper = slist -> {
            List<String> res = new ArrayList<>();
            for(String s :slist){
                res.add(s.toUpperCase());
            }
            return res;
        };

        Function<List<String>, List<String>> lower = slist -> {
            List<String> res = new ArrayList<>();
            for(String s :slist){
                res.add(s.toLowerCase());
            }
            return res;
        };

        List<String> strs = List.of("EDS"," SDCscc", "dvfg");
        System.out.println(upper.apply(strs));
        System.out.println(lower.apply(strs));




        //4. Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
        Function<List<Integer>, List<Integer>> even = nums-> {
            List<Integer> res = new ArrayList<>();
            for(int n :nums){
                if(n%2 == 0){
                    res.add(n);
                }
            }
            return res;
        };

        Function<List<Integer>, List<Integer>> odd = nums-> {
            List<Integer> res = new ArrayList<>();
            for(int n :nums){
                if(n%2 != 0){
                    res.add(n);
                }
            }
            return res;
        };

        List<Integer> nums = Arrays.asList(12, 4, 2, 5, 7, 845, 677, 453, 66);
        System.out.println("Even numbers: " + even.apply(nums));
        System.out.println("Odd numbers: " + odd.apply(nums));
        
        //5. Write a Java program to implement a lambda expression to sort a list of strings in alphabetical order.
        Function<List<String>, List<String>> order = strlist-> {
            List<String> res = new ArrayList<>(strlist);
            Collections.sort(res, (a, b) -> a.compareTo(b));
            return res;
        };
        List<String> str = List.of("banana", "apple", "blueberry", "mango");
        System.out.println(order.apply(str));
           

        //6. Write a Java program to implement a lambda expression to find the average of a list of doubles.
        Function<List<Integer>, Double> avg = numbers -> {
            int total =0;
            for(int n :numbers){
                total += n;
            }
            return (double) total/numbers.size();
        };
        List<Integer> num = List.of(1,4,56,86,854);
        System.out.println(avg.apply(num));

        //7. Write a Java program to implement a lambda expression to remove duplicates from a list of integers.
        Function<List<Integer>, List<Integer> > removeduplicate = numbers -> {
            Set<Integer> set = new HashSet<>();
            List<Integer> res  = new ArrayList<>();
            for(int n : numbers){
                if(!set.contains(n)){
                    res.add(n);    
                }
                set.add(n);
            }
            return res;
            
        };
        List<Integer> nums1 = List.of(1,56,56,86,854,1);
        System.out.println(removeduplicate.apply(nums1));


        //8. Write a lambda expression to implement a lambda expression to calculate the factorial of a given number.
        Function<Integer, Integer> factorial = n -> {
            if(n <= 1) return 1;
            int res = 1;
            for(int i =2; i <= n; i++){
                res = res*i;
            }
            return res;    
        };
        System.out.println(factorial.apply(8));



    }
}