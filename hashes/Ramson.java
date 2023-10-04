package hashes;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Process {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
    // Write your code here
        Hashtable<String, Integer> hash = new Hashtable<String, Integer>();
        magazine.forEach(
            word -> {
                Integer ocorrencias = hash.get(word);
                if(ocorrencias == null){
                    hash.put(word, 1);
                } else {
                    hash.put(word, ocorrencias + 1);
                }

            }
        );
        
        boolean possible = true;
        for(String word : note){  
            Integer ocorrencias = hash.get(word);
            if(ocorrencias == null || ocorrencias <= 0){
                possible = false;
            } else if(ocorrencias > 0){
                hash.put(word, ocorrencias - 1);
            }
        }

        if(possible)
            System.out.println("Yes");
        else
            System.out.println("No"); 
    }

}

public class Ramson {
    public static void main(String[] args) throws IOException {
        String magazineString = "ive got a lovely bunch of coconuts";
        String noteString = "ive got a coconuts";

        List<String> magazine = Stream.of(magazineString.replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        List<String> note = Stream.of(noteString.replaceAll("\\s+$", "").split(" "))
            .collect(toList());

        Process.checkMagazine(magazine, note);

    }
}
