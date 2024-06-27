import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class pra {
    public static void main(String[] args) {
   /*      Consumer<Integer> amount = year-> {
            if(year < 5){
                System.out.println(year);
            }
            else{
                System.out.println(year*2);
            }
            
        }

        yamount.accept(9);*/
        
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
        };
    }
}
