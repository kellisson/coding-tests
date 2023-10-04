package stacks;

import java.util.*;

class SolutionS{


    public static long largest = 0L;

    public static long largestRetangle(List<Integer> h){

        PriorityQueue<Integer> pilhaAlturas = new PriorityQueue<Integer>(
            Comparator.reverseOrder());
        for(Integer altura : h){
            if(pilhaAlturas.size() > 0) {
                int quantidadePool = 0;
                while(altura < pilhaAlturas.peek()){
                    int alturaAtual = pilhaAlturas.poll();
                    quantidadePool++;
                    if(largest < alturaAtual * quantidadePool)
                        largest = alturaAtual * quantidadePool;
                }
                
            }
            pilhaAlturas.add(altura);
        }
        while(pilhaAlturas.size() > 0) {
            pilhaAlturas.poll();
              //  if(largest < altura * quantidadePool)
                //    largest = altura * quantidadePool;
        }
        return largest;
    }

}

public class LargestRetangle {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Integer[] array = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.asList(array);
        System.out.println(SolutionS.largestRetangle(list));

    }
}