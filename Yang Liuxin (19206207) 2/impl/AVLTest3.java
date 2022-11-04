package dsa.impl;

import dsa.example.AVLTreeStructureTest;
import dsa.iface.IBinarySearchTree;
import dsa.util.TreePrinter;

public class AVLTest3 {
    /*
    This class uses four kinds of traversals (preorder, inorder, postorder, layer) to compare shape to test the tree structure
    This class tests the tree operation using reading file.
     */

    public static void main(String[] args) {
        AVLTree avlTree3 = new AVLTree();
        ReadFile.readFile(avlTree3, "textAVL");

        Traversal traversal = new Traversal();

        Integer[] preorder1 = new Integer[] {50, 42, 14, 12, 33, 48, 65, 61, 54, 73, 75};
        Integer[] inorder1 = new Integer[] {12, 14, 33, 42, 48, 50, 54, 61, 65, 73, 75};
        Integer[] postorder1 = new Integer[] {12, 33, 14, 48, 42, 54, 61, 75, 73, 65, 50};
        Integer[] layer1 = new Integer[] {50, 42, 65, 14, 48, 61, 73, 12, 33, 54, 75};

        System.out.println("Test AVL Tree3:");

        // use preorder traversal to test the tree structure
        System.out.println("Is the AVL Tree3 in the expected shape using the preorder traversal: " + traversal.testPreorderStructure(avlTree3, preorder1));

        // use inorder traversal to test the tree structure
        System.out.println("Is the AVL Tree3 in the expected shape using the inorder traversal: " + traversal.testInorderStructure(avlTree3, inorder1));

        // use postorder traversal to test the tree structure
        System.out.println("Is the AVL Tree3 in the expected shape using the postorder traversal: " + traversal.testPostorderStructure(avlTree3, postorder1));

        // use layer traversal to test the tree structure
        System.out.println("Is the AVL Tree3 in the expected shape using the layer traversal: " + traversal.testLayerStructure(avlTree3, layer1));

        // use the provided areEqual function to test the tree structure
        IBinarySearchTree<Integer> t2 = new BinarySearchTree<>();
        for ( int v : layer1 )
            t2.insert( v );
        System.out.println( "Is the AVL Tree3 in the expected shape using the provided areEqual function to test the tree structure? " + (AVLTreeStructureTest.areEqual(avlTree3, avlTree3.root(), t2, t2.root()) ? "YES! :-D" : "No! :-(" ) );

        System.out.println();
        System.out.println("Shape of the AVL Tree3:");
        TreePrinter.printTree(avlTree3);
    }
}
