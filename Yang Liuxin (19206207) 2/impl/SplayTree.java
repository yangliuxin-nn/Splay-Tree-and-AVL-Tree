package dsa.impl;

import dsa.iface.IPosition;

public class SplayTree<T extends Comparable<T>> extends BinarySearchTree<T> {

   public void insert(T value ) {
      // TODO: Implement the insert(...) method.
      IPosition<T> x = super.find(root, value);
      // x should be an external node because BST does not allow duplicate entries
      // if x is already in the tree, then we should do nothing for insertion
      if (isExternal(x)) {
         expandExternal(x, value);
         splay(x);
      }
   }

   public boolean contains( T value ) {
      // TODO: Implement the contains(...) method.
      BTPosition btPosition = (BTPosition) find(root, value);
      // if value is not found in the splay tree, the parent of that external node should be splayed
      if (isExternal(btPosition)){
         splay(btPosition.parent);
         return false;
      }
      // if value is found is the splay tree, the exact found node should be splayed
      else {
         splay(btPosition);
         return true;
      }
   }

   public void remove( T value ) {
      // TODO: Implement the remove(...) method.
      BTPosition x = (BTPosition) find(root, value);
      if (!isExternal(x)) {
         if (isExternal(x.left) || isExternal(x.right)) {
            remove(x);
            // the parent of the exact removed node should be splayed
            splay(x.parent);
         }
         else {
            // find the next largest node than x: nextLarge
            BTPosition nextLarge = x.right;
            while (!isExternal(nextLarge.left)) {
               nextLarge = nextLarge.left;
            }
            // replace the x node with the element of the nextLarge
            replace(x, nextLarge.element);
            remove(nextLarge);
            // the parent of the exact removed node should be splayed
            splay(nextLarge.parent);
         }
      }
   }

   private void splay( IPosition<T> n ) {
      // TODO: Implement the splay(...) method.
      BTPosition x = (BTPosition) n;
      // x should be splayed until it is the root node
      while (!isRoot(x)){
         BTPosition parent = x.parent;
         // if x is the child of the root node, call zig function
         if (isRoot(parent)){
            zig(x, parent);
         }
         // if x is not the child of the root node
         else {
            BTPosition grandparent = parent.parent;
            // if x, its parent, and its grandparent are in the same direction, call zig-zig function
            if (singleDirection(x, parent, grandparent)){
               zig_zig(x, parent, grandparent);
            }
            // if x, its parent, and its grandparent are in the different directions, call zig-zag function
            else{
               zig_zag(x, parent, grandparent);
            }
         }
      }
   }

   // return whether x, is parent, and its grandparent are in the same direction or not
   private boolean singleDirection(BTPosition x, BTPosition y, BTPosition z){
      if ((z.right == y && y.right == x) || (z.left == y && y.left == x))
         return true;
      return false;
   }

   private void zig(BTPosition x, BTPosition y){
      // alter the subtree
      if (y.right == x) {
         y.right = x.left;
         x.left.parent = y;
         x.left = y;
      }
      else{
         y.left = x.right;
         x.right.parent = y;
         x.right = y;
      }
      // alter the root node reference
      y.parent = x;
      x.parent = null;
      root = x;
   }

   private void zig_zig(BTPosition x, BTPosition y, BTPosition z){
      // alter the root reference
      alterSubRoot(x, z);
      // alter subtree
      if (z.right == y && y.right == x){
         z.right = y.left;
         y.left.parent = z;
         y.left = z;
         z.parent = y;
         y.right = x.left;
         x.left.parent = y;
         x.left = y;
      }
      else{
         z.left = y.right;
         y.right.parent = z;
         y.right = z;
         z.parent = y;
         y.left = x.right;
         x.right.parent = y;
         x.right = y;
      }
      y.parent = x;
   }

   private void alterSubRoot(BTPosition p, BTPosition z){
      if (isRoot(z)){
         root = p;
         p.parent = null;
      }
      else {
         if (z.parent.left == z)
            z.parent.left = p;
         else
            z.parent.right = p;
         p.parent = z.parent;
      }
   }

   private void zig_zag(BTPosition x, BTPosition y, BTPosition z){
      alterSubRoot(x, z);
      if (z.right == y && y.left == x){
         alterSubTree(x, y, z);
      }
      else {
         alterSubTree(x, z, y);
      }
      z.parent = x;
      y.parent = x;
   }

   private void alterSubTree(BTPosition x, BTPosition y, BTPosition z){
      z.right = x.left;
      x.left.parent = z;
      y.left = x.right;
      x.right.parent = y;
      x.right = y;
      x.left = z;
   }


}
