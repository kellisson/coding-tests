package arrays;

import java.util.Stack;

public class BracketsProblem {

    /**
     *
     */

    

    public static String isBalancedV1(String s) {
        String resposta = "YES";
        if(s == null || s.length() == 0){
            return resposta;
        }
        int index_left = (s.length() / 2) - 1;
        int index_right = s.length() / 2;
        while(index_right < s.length()){
            if(isNotBalanced(s.charAt(index_left), s.charAt(index_right))){
                resposta = "NO";
                break;
            }
            index_left--;
            index_right++;
        }
        return resposta;
    }
    
    private static final char LEFT_BRACKET = '{';
    private static final char RIGHT_BRACKET = '}';
    private static final char LEFT_PARENTHESIS = '(';
    private static final char RIGHT_PARENTHESIS = ')';
    private static final char LEFT_KEYS = '[';
    private static final char RIGHT_KEYS = ']';

    public static boolean isLeftBalance(char c){
        return c == LEFT_BRACKET || c == LEFT_PARENTHESIS || c == LEFT_KEYS;
    }

    public static boolean isRightBalance(char c){
        return c == RIGHT_BRACKET || c == RIGHT_PARENTHESIS || c == RIGHT_KEYS;
    }

    public static boolean isNotBalanced(char left, char right) {
        boolean brackets = left == LEFT_BRACKET && right == RIGHT_BRACKET;
        boolean parenthesis = left == LEFT_PARENTHESIS && right == RIGHT_PARENTHESIS;
        boolean keys = left == LEFT_KEYS && right == RIGHT_KEYS;
        return !(brackets || parenthesis || keys);
    }

    public static String isBalanced(String s) {
        String resposta = "YES";
        Stack<Character> pilha = new Stack();
        if(s == null || s.length() == 0){
            return resposta;
        }
        for(char item: s.toCharArray()){
            if(isLeftBalance(item)){
                pilha.push(item); 
            } else if(isRightBalance(item)){
                if(pilha.size() == 0 || isNotBalanced(pilha.pop(), item)){
                    resposta = "NO";
                    break;
                }
            } else {
                resposta = "NO";
                break;
            }
        }
        if(pilha.size() > 0){
            resposta = "NO";
        }
        return resposta;
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("null"));
        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }
}
