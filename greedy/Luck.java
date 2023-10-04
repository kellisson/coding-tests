package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LuckResult {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY precoSorvete
     */
    public static List<List<Integer>> knapsack = new ArrayList<>();

    public static List<List<Integer>> luckBalance(int capacity, List<Integer> precoSorvete) {
    // Write your code here
        iniciarMochila(precoSorvete.size());
        int result = knapsackDynamic(precoSorvete.size(), capacity, precoSorvete);
        System.out.println(result);
        return knapsack;
    }

    private static int knapsackDynamic(int index, int capacity,  List<Integer> precoSorvete) {
        int result = 0;
        if(index <= 0 || capacity <= 0)
            return 0;
        if(knapsack.get(index).get(capacity) > -1){
            return knapsack.get(index).get(capacity);
        }else if(1 > capacity){
            result = knapsackDynamic(index-1, capacity, precoSorvete);
        } else {
            int mochilaAddNovoItem = knapsackDynamic(index-1, capacity, precoSorvete);
            int mochilaSubsNovoItem = precoSorvete.get(index-1) + knapsackDynamic(index-1, capacity - precoSorvete.get(index-1) , precoSorvete);
            result = mochilaAddNovoItem > mochilaSubsNovoItem ? mochilaAddNovoItem : mochilaSubsNovoItem;
        }
        knapsack.get(index).add(index, result);
        return result;
    }

    private static void iniciarMochila(int k) {
        for(int i = 0; i <= k; i++){
            knapsack.add(new ArrayList());
            for(int j = 0; j <= k; j++){
                knapsack.get(i).add(-1);
            }
        }
    }

}

public class Luck {
    public static void main(String[] args) {

        List<List<Integer>> precoSorvete = new ArrayList<>();

        precoSorvete.add(Arrays.asList(new Integer[] {5,1}));
        precoSorvete.add(Arrays.asList(new Integer[] {2,1}));
        precoSorvete.add(Arrays.asList(new Integer[] {1,1}));
        precoSorvete.add(Arrays.asList(new Integer[] {8,1}));
        precoSorvete.add(Arrays.asList(new Integer[] {10,0}));
        precoSorvete.add(Arrays.asList(new Integer[] {5,0}));
        

        List<List<Integer>> knapsack = LuckResult.luckBalance(5, Arrays.asList(new Integer[] {1,4,5,3,2}));

        for(List<Integer> sack : knapsack){
            for(Integer result : sack){
                System.out.print(result+", ");
            }
            System.out.println();
            System.out.println("========");
        }
    }
}
