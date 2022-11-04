package dsa.impl;

import dsa.example.AVLTreeStructureTest;
import dsa.iface.IBinarySearchTree;
import dsa.util.TreePrinter;

public class AVLTest2 {
    /*
    This class uses four kinds of traversals (preorder, inorder, postorder, layer) to compare shape to test the tree structure
    This class tests the avlTree2 of type Character, which is prepared in the PrepareTestTrees class.
     */

    public static void main(String[] args) {
        AVLTree avlTree2 = PrepareTestTrees.avlTree2();
        Traversal traversal = new Traversal();

        Character[] preorder = new Character[] {'a', 'E', 'C', 'B', 'Y', 'G', 'Z', 'f', 'd', 'b', 'h', 'n'};
        Character[] inorder = new Character[] {'B', 'C', 'E', 'G', 'Y', 'Z', 'a', 'b', 'd', 'f', 'h', 'n'};
        Character[] postorder = new Character[] {'B', 'C', 'G', 'Z', 'Y', 'E', 'b', 'd', 'n', 'h', 'f', 'a'};
        Character[] layer = new Character[] {'a', 'E', 'f', 'C', 'Y', 'd', 'h', 'B', 'G', 'Z', 'b', 'n'};

        System.out.println("Test AVL Tree2:");

        // use preorder traversal to test the tree structure
        System.out.println("Is the AVL Tree2 in the expected shape using the preorder traversal: " + traversal.testPreorderStructure(avlTree2, preorder));

        // use inorder traversal to test the tree structure
        System.out.println("Is the AVL Tree2 in the expected shape using the inorder traversal: " + traversal.testInorderStructure(avlTree2, inorder));

        // use postorder traversal to test the tree structure
        System.out.println("Is the AVL Tree2 in the expected shape using the postorder traversal: " + traversal.testPostorderStructure(avlTree2, postorder));

        // use layer traversal to test the tree structure
        System.out.println("Is the AVL Tree2 in the expected shape using the layer traversal: " + traversal.testLayerStructure(avlTree2, layer));

        // use the provided areEqual function to test the tree structure
        IBinarySearchTree<Character> t2 = new BinarySearchTree<>();
        for ( Character v : layer )
            t2.insert( v );
        System.out.println( "Is the AVL Tree2 in the expected shape using the provided areEqual function to test the tree structure? " + (AVLTreeStructureTest.areEqual(avlTree2, avlTree2.root(), t2, t2.root()) ? "YES! :-D" : "No! :-(" ) );

        System.out.println();
        System.out.println("Shape of AVL Tree2:");
        TreePrinter.printTree(avlTree2);
    }

}
