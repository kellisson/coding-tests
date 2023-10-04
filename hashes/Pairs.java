package hashes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PairsSolution{
    Set<Integer> map = new HashSet<>();

    public void solution(int k, List<Integer> arr){
        int totalPairs = 0;
        for(Integer itemArray : arr){
            map.add(itemArray);
        }
        for(Integer itemArray : arr){
            if (map.contains(itemArray+k))
                totalPairs++;
            if(map.contains(itemArray-k))
                totalPairs++;
        }
        System.out.println(totalPairs/2);
    }
}

public class Pairs {

    public static void main(String[] args) {
        PairsSolution pairsSolution = new PairsSolution();
        List<Integer> listInputs = new ArrayList<>();
        listInputs.add(1);
        listInputs.add(2);
        listInputs.add(3);
        listInputs.add(4);
        int difference = 2;
        pairsSolution.solution(difference, listInputs);

        pairsSolution = new PairsSolution();
        listInputs = new ArrayList<>();
        difference = 0;
        pairsSolution.solution(difference, listInputs);

        listInputs = new ArrayList<>();
        listInputs.add(1);
        listInputs.add(5);
        listInputs.add(3);
        listInputs.add(4);
        listInputs.add(2);
        difference = 2;
        pairsSolution.solution(difference, listInputs);
    }
    
    
}
