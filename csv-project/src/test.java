import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
       
        List<Integer> buildingcount = new ArrayList<>();
        buildingcount.add(1);
        buildingcount.add(2);
        buildingcount.add(1);
        buildingcount.add(2);
        buildingcount.add(2);
        List<Integer> routerlocation = new ArrayList<>();
        routerlocation.add(3);
        routerlocation.add(1);
        List<Integer> routeranger = new ArrayList<>();
        routeranger.add(1);
        routeranger.add(2);
        
        int res = getServerBuildings(buildingcount, routerlocation, routeranger);
        System.out.println(res);
       

    }
    public static int getServerBuildings(List<Integer> buildingcount, List<Integer> routerlocation, List<Integer> routeranger){
        int[] arr = new int[buildingcount.size()];
        int res =0;
        
        for(int i=0; i < routerlocation.size();i++){
            int range = routeranger.get(i);
            int start = Math.max(0,routerlocation.get(i)-1-range);
            int end = Math.min(routerlocation.get(i)-1+range, arr.length-1);
            
            for(int j = start; j < end;j++){
                arr[j] += 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= buildingcount.get(i)){
                res++;
            }
        }      
        
        return res;
        

    }

}