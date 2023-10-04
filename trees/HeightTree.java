package trees;

public class HeightTree {

    static int maxLevel;

    public static void levelOrderTraversal(Node root, int lvl){
        System.out.println(root.value+", lvl:"+lvl);
        if (lvl > maxLevel){
            maxLevel = lvl;
        }
        if(root.left != null){
            levelOrderTraversal(root.left, lvl+1);
        }
        if(root.right != null){
            levelOrderTraversal(root.right, lvl+1);
        }
    }

    public static void init(Node root){
        maxLevel = 0;
        levelOrderTraversal(root, 0);
    }

    public static void main(String[] args) {
        init(criarArvore());
        System.out.println(maxLevel);
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
