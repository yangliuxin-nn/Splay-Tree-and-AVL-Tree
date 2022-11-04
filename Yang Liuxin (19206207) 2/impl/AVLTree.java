package dsa.impl;

import dsa.iface.IPosition;


public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

   @Override
   public void insert( T element ) {
      // TODO: Implement the insert(...) method.
      AVLPosition x = (AVLPosition) super.find(root, element);
      // x should be an external node because BST does not allow duplicate entries
      // if x is already in the tree, then we should do nothing for insertion
      if (isExternal(x)) {
         expandExternal(x, element);
         x.height = 1;
         // the root node does not need restructure
         if (x.parent != null){
            detectRestructure(x, true);

         }
      }
   }

   @Override
   public boolean contains( T element ) {
      // TODO: Implement the contains(...) method.
      return super.contains(element);
   }


   @Override
   public void remove( T element ) {
      // TODO: Implement the remove(...) method.
      AVLPosition x = (AVLPosition) find(root, element);
      // if x is found, then it should be removed; otherwise, we do nothing about it.
      if (!isExternal(x)) {
         // if x is an internal node with at least one external child
         if (isExternal(x.left) || isExternal(x.right)) {
            remove(x);
            // detect whether a restructure is needed after this removal
            detectRestructure(x, false);
         }
         // if x is an internal node with two external children, a swap is needed.
         else {
            // find the next largest node than x: nextLarge
            BTPosition nextLarge = x.right;
            while (!isExternal(nextLarge.left)) {
               nextLarge = nextLarge.left;
            }
            // replace the x node with the element of the nextLarge
            replace(x, nextLarge.element);
            remove(nextLarge);
            // detect whether a restructure is needed after this removal
            detectRestructure((AVLPosition) nextLarge.parent, false);
         }
      }
   }

   private void detectRestructure(AVLPosition p, boolean isInsert){
      while (p != null) {
         int heightDiff =  Math.abs(((AVLPosition)p.left).height - ((AVLPosition)p.right).height);
         // if the height difference is bigger than 1, we should decide which grand-node to be passed into the restructure function
         if ( heightDiff > 1) {
            // choose the child with the largest height
            AVLPosition child = ((AVLPosition)p.left).height - ((AVLPosition)p.right).height > 0 ? (AVLPosition) p.left : (AVLPosition) p.right;
            int cmp = ((AVLPosition)child.left).height - ((AVLPosition)child.right).height;
            // choose the grandchild with the largest height
            AVLPosition grandChild;
            if (cmp > 0)
               grandChild = (AVLPosition) child.left;
            else if (cmp < 0)
               grandChild = (AVLPosition) child.right;
            else
               // If the children could have the same height, choose the one that will cause a single rotation.
               grandChild = p.right == child ? (AVLPosition) child.right: (AVLPosition) child.left;
            restructure(grandChild);
            // for insertion, one restructure is enough if necessary
            if (isInsert)
               break;
         }
         // if the height difference is not bigger than 1, we should continue searching upwards
         else {
            p = (AVLPosition) p.parent;
            if (p != null)
               p.height = Math.max(((AVLPosition)p.left).height,((AVLPosition)p.right).height) + 1;
         }
      }
   }

   private void restructure( IPosition<T> iPosition ) {
      // Implement the restructure(...) method.

      // x: node
      // y: parent of the node
      // z: grandparent of the node

      AVLPosition x = (AVLPosition) iPosition;
      AVLPosition y = (AVLPosition) x.parent;
      AVLPosition z = (AVLPosition) y.parent;

      // Single rotation Left
      if (z.right == y && y.right == x){
         alterSubRoot(y, z);
         leftRotate(y, z);
         // in this case, the height of y and z need to be recalculated while x does not
         recalculateHeight(null, y, z);
      }

      // Single rotation Right
      else if (z.left == y && y.left == x){
         alterSubRoot(y, z);
         rightRotate(y, z);
         // in this case, the height of y and z need to be recalculated while x does not
         recalculateHeight(null, y, z);
      }

      // Double rotation Left Right
      else if (z.right == y && y.left == x){
         alterSubRoot(x, z);
         leftRotate(x, z);
         rightRotate(x, y);
         // in this case, the height of x, y, and z need to be recalculated
         recalculateHeight(x, y, z);
      }

      // Single rotation Right Left
      else if (z.left == y && y.right == x){
         alterSubRoot(x, z);
         leftRotate(x, y);
         rightRotate(x, z);
         // in this case, the height of x, y, and z need to be recalculated
         recalculateHeight(x, y, z);
      }

   }

   private void leftRotate(AVLPosition y, AVLPosition z){
      z.right = y.left;
      y.left.parent = z;
      y.left = z;
      z.parent = y;

   }

   private void rightRotate(AVLPosition y, AVLPosition z){
      z.left = y.right;
      y.right.parent = z;
      y.right = z;
      z.parent = y;
   }

   private void alterSubRoot(AVLPosition p, AVLPosition z){
      // A special situation when node's grandparent: z is root
      if (z == root) {
         p.parent = null;
         root = p;
      }
      else {
         if (z.parent.left == z) {
            z.parent.left = p;
         } else if (z.parent.right == z) {
            z.parent.right = p;
         }
         p.parent = z.parent;
      }
   }

   private void recalculateHeight(AVLPosition x, AVLPosition y, AVLPosition z){
      z.height = Math.max(((AVLPosition)z.left).height,((AVLPosition)z.right).height) + 1;
      y.height = Math.max(((AVLPosition)y.left).height,((AVLPosition)y.right).height) + 1;
      if (x != null)
         x.height = Math.max(((AVLPosition)x.left).height,((AVLPosition)x.right).height) + 1;
   }

   @Override
   protected BTPosition newPosition( T element, BTPosition parent ) {
      return new AVLPosition( element, parent );
   }

   public class AVLPosition extends BTPosition {
      int height = 0;

      public AVLPosition( T element, BTPosition parent ) {
         super( element, parent );
      }
   }
}
