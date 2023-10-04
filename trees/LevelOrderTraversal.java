package trees;

import java.util.LinkedList;
import java.util.Queue;


class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}

public class LevelOrderTraversal {

    private static Queue<Node> filaDeNos;

    public static void levelOrderTraversal(Node root){
        System.out.println(root.value);
        if(root.left != null){
            filaDeNos.add(root.left);
        }
        if(root.right != null){
            filaDeNos.add(root.right);
        }
    }

    public static void init(Node root){
        filaDeNos.add(root);
        while(filaDeNos.peek() != null){
            levelOrderTraversal(filaDeNos.poll());
        }
    }

    public static void main(String[] args) {
        filaDeNos = new LinkedList<>();
        init(criarArvore());
        init(null);
    }

    private static Node criarArvore() {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.right.left.left = new Node(9);

        return root;
    }
    
}
