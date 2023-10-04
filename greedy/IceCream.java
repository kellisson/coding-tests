package greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class IceResult {

    /*
     * Complete the 'whatFlavors' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. INTEGER money
     */

    public static void whatFlavors(List<Integer> cost, int money) {
    // Write your code here
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < cost.size(); i++){
            List<Integer> indexes = map.getOrDefault(cost.get(i), new ArrayList<>());
            indexes.add(i);
            map.put(cost.get(i), indexes);
        }
        int pos1 = 0;
        int pos2 = 0;
        for(int i : map.keySet()){
            if(i * 2 == money && map.get(i).size() > 1){
                pos1 = map.get(i).get(0);
                pos2 = map.get(i).get(1);
                break;
            } else if(map.containsKey(money - i)){
                pos1 = map.get(i).get(0);
                pos2 = map.get(money - i).get(0);
                break;
            }
        }
        System.out.println(pos1+" "+pos2);
    }

}

public class IceCream {
    public static void main(String[] args) throws IOException {
        IceResult.whatFlavors(Arrays.asList(new Integer[] {1,4,5,3,2}), 5);
    }
}
