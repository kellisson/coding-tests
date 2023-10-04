package hashes;
import java.io.*;
import java.util.*;

class Dunno {

    /*
     * Complete the 'sherlockAndAnagrams' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */
    private static int hashing(String input){
        int hash = 0;
        for(int i = 0; i < input.length(); i++){
            Character a = input.charAt(i);
            hash += a.hashCode();
        }
        return hash;
    }

    public static int sherlockAndAnagrams(String anagram) {
    // Write your code here
        int anagrams = 0;
        Hashtable<Integer, Integer> set = new Hashtable<>();
        for(int i = 0; i < anagram.length(); i++){
            for(int j = i; j < anagram.length(); j++){
                String substring = anagram.substring(i, j+1);
                int hashedSubstring = hashing(substring);
                System.out.println(i+" "+j+" "+substring+" "+hashedSubstring);
                //System.out.println(substring+" "+hashedSubstring);
                if(set.get(hashedSubstring) != null){
                    Integer anagramas = set.get(hashedSubstring);
                    anagrams += anagramas;
                    anagramas++;
                    set.put(hashedSubstring, anagramas);
                    System.out.println("OPAAAA "+substring);
                } else {
                    set.put(hashedSubstring, 1);
                }
            }
        }
        return anagrams;

    }

}

public class Anagram {
    public static void main(String[] args) throws IOException {
   
        int result = Dunno.sherlockAndAnagrams("cdcd");
        System.out.println(result);
       // result = Dunno.sherlockAndAnagrams("onnud");
       // System.out.println(result);

    }
}
