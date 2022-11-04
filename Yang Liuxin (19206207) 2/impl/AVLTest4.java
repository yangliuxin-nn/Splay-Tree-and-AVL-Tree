package dsa.impl;


public class AVLTest4 {
    /*
    This class checks the size of the tree and height of each node to test the tree structure
    This class tests the avlTree3 of type Integer, which is prepared in the PrepareTestTrees class.
    This class optimizes the printTree method in the TreePrinter class by printing the height of each node and the size of the tree.
    Inside the parentheses is the height of each node.
     */

    public static void main(String[] args) {
        AVLTree avlTree = PrepareTestTrees.avlTree3();
        System.out.println("Shape of the tree and height of each node:");
        TreePrinterHeight.printTree(avlTree);

        Integer[] heightArr = new Integer[]{3, 2, 1, 0, 0, 1, 0, 0, 2, 1, 0, 0, 1, 0, 0};
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
