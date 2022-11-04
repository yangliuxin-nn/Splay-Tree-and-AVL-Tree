package dsa.impl;


public class AVLTest5 {
    /*
    This class tests if the children have the same height when detecting restructure, we choose the one that will cause a single rotation.
    This class tests the height of each node and the contains() method.
    This class checks the size of the tree and height of each node to test the tree structure
    This class tests the avlTree4 of type String, which is prepared in the PrepareTestTrees class.
    This class optimizes the printTree method in the TreePrinter class by printing the height of each node and the size of the tree.
    Inside the parentheses is the height of each node.
     */

    public static void main(String[] args) {
        AVLTree avlTree = PrepareTestTrees.avlTree4();

        System.out.println("Is the avlTree contains \"32\": " + avlTree.contains("32"));

        // If the children could have the same height, we choose the one that will cause a single rotation.
        avlTree.remove("32");

        System.out.println("Is the avlTree contains \"32\" after calling remove(\"32\"): " + avlTree.contains("32"));

        System.out.println();
        System.out.println("Shape of the tree with height:");
        TreePrinterHeight.printTree(avlTree);

        Integer[] heightArr = new Integer[]{4, 3, 1, 0, 0, 2, 1, 0, 0, 1, 0, 0, 2, 0, 1, 0, 0};
        LinkedQueue<Integer> heightQue = new TreePrinterHeight<>(avlTree).getHeights();

        boolean flagHeight = true;
        boolean flagSize = heightArr.length == heightQue.size();

        for (int i = 0; i < heightArr.length && flagHeight; i++){
            if ( !heightArr[i].equals(heightQue.dequeue()))
                flagHeight = false;
        }

        System.out.println( "Is the height of each node correct? " + (flagHeight ? "YES! :-D" : "No! :-(" ));
        System.out.println( "Is the size of each tree correct? " + (flagSize ? "YES! :-D" : "No! :-(" ));
    }
}
