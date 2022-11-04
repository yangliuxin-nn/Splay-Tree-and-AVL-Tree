package dsa.impl;

import dsa.example.AVLTreeStructureTest;
import dsa.iface.IBinarySearchTree;
import dsa.util.TreePrinter;

public class AVLTest1 {
    /*
    This class uses four kinds of traversals (preorder, inorder, postorder, layer) to compare shape to test the tree structure
    This class tests the avlTree1 of type Integer, which is prepared in the PrepareTestTrees class.
     */

    public static void main(String[] args) {
        AVLTree avlTree1 = PrepareTestTrees.avlTree1();
        Traversal traversal = new Traversal();

        Integer[] preorder1 = new Integer[] {5, 3, -1, 4, 7, 6, 8};
        Integer[] inorder1 = new Integer[] {-1, 3, 4, 5, 6, 7, 8};
        Integer[] postorder1 = new Integer[] {-1, 4, 3, 6, 8, 7, 5};
        Integer[] layer1 = new Integer[] {5, 3, 7, -1, 4, 6, 8};

        System.out.println("Test AVL Tree1:");

        // use preorder traversal to test the tree structure
        System.out.println("Is the AVL Tree1 in the expected shape using the preorder traversal: " + traversal.testPreorderStructure(avlTree1, preorder1));

        // use inorder traversal to test the tree structure
        System.out.println("Is the AVL Tree1 in the expected shape using the inorder traversal: " + traversal.testInorderStructure(avlTree1, inorder1));

        // use postorder traversal to test the tree structure
        System.out.println("Is the AVL Tree1 in the expected shape using the postorder traversal: " + traversal.testPostorderStructure(avlTree1, postorder1));

        // use layer traversal to test the tree structure
        System.out.println("Is the AVL Tree1 in the expected shape using the layer traversal: " + traversal.testLayerStructure(avlTree1, layer1));

        // use the provided areEqual function to test the tree structure
        IBinarySearchTree<Integer> t2 = new BinarySearchTree<>();
        for ( int v : layer1 )
            t2.insert( v );
        System.out.println( "Is the AVL Tree1 in the expected shape using the provided areEqual function to test the tree structure? " + (AVLTreeStructureTest.areEqual(avlTree1, avlTree1.root(), t2, t2.root()) ? "YES! :-D" : "No! :-(" ) );

        System.out.println();
        System.out.println("Shape of AVL Tree1:");
        TreePrinter.printTree(avlTree1);
    }
}
