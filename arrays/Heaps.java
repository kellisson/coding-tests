package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


class Node{

    Node leftNode = null;
    Node rightNode = null;
    int value;
    

    public Node(int value){
        this.value = value;
    }

    public void setValue(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
    public Node getLeftNode(){
        return leftNode;
    }
    public Node getRightNode(){
        return rightNode;
    }
    public void setLeftNode(Node node){
        this.leftNode = node;
    }
    public void setRightNode(Node node){
        this.rightNode = node;
    }
        
}

public class Heaps {

    public static List<Double> runningMedianr(List<Integer> a) {
        Queue<Integer> heap = new PriorityQueue<Integer>();
        int i = 1;
        double total = 0;
        for(Integer item : a){
            total += item;
            heap.add(item);
            if(i % 2 == 0){
                System.out.println(total/i);
            } else {
                System.out.println(heap.peek());
            }
            i++;
        }
        // Write your code here
        return null;
    }


    public static Node insertBT(Node node, int value){
        if (node == null)
            return new Node(value);
        if (value > node.getValue()) {
            node.setRightNode(insertBT(node.getRightNode(), value));
        } else if(value < node.getValue()) {
            node.setLeftNode(insertBT(node.getLeftNode(), value));
        }
        return node;
    }


    public static List<Double> runningMedianV2(List<Integer> a) {
        Node node = null;
        for(Integer item : a){
            node = insertBT(node, item);
            System.out.println(node.getValue());
        }
        // Write your code here
        return null;
    }

    private static List<Integer> insertBinarySearch(List<Integer> list, Integer item){
        if(list.size() == 0){
            list.add(item);
            return list;
        }
        int left = 0;
        int right = list.size() - 1;
        int index = left;
        while(left <= right){
            index = (left + right) / 2;
            if(item < list.get(index)){
                right = index - 1;
            } else if (item > list.get(index)) {
                left = index + 1;
            } else {
                break;
            }
        }
        if(list.get(index) <= item){
            if(index == list.size() - 1)
                list.add(item);
            else 
                list.add(index+1, item);
        } else {
            list.add(index, item);
        }
        return list;
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Integer> list = new ArrayList<>();
        List<Double> medians = new ArrayList<>();
        for(Integer item : a){
            double median = 0f;
            list = insertBinarySearch(list, item);
            if(list.size() % 2 == 0){
                int half = list.size() / 2;
                median = (list.get(half - 1) + list.get(half)) / 2.0f;
            } else {
                median = list.get(list.size()/2);
            }
            medians.add(median);

            System.out.print(median+": [");
            for(int index: list){
                System.out.print(index+", ");
            }
            System.out.println("]");
        }
        // Write your code here
        return medians;
    }

    public static void main(String[] args) {
        Integer[] lista = new Integer[]{12, 4, 5, 3, 8, 7};
        runningMedian(Arrays.asList(lista));
        lista = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        runningMedian(Arrays.asList(lista));
        //for(Double a : result){
        //    System.out.println(a);
       //}
    }
}
