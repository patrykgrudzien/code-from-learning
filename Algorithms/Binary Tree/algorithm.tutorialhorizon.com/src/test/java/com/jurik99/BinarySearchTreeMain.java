package com.jurik99;

import static com.jurik99.BinarySearchTree.root;

public class BinarySearchTreeMain
{
	public static void main(final String[] args)
	{
		final BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20);
		tree.insert(15);
		tree.insert(25);
		tree.insert(10);
		tree.insert(18);
		tree.insert(12);
		tree.insert(17);
		tree.insert(19);
		tree.insert(16);

		System.out.println("Original Tree: ");
		tree.display(root);

		System.out.println("--------------------------------------------");

		System.out.println("Check whether Node with value 19 exists: " + tree.find(19));

		System.out.println("--------------------------------------------");

		System.out.println("Delete Node with NO children (17): " + tree.delete(17));
		tree.display(root);

		System.out.println("--------------------------------------------");

		System.out.println("Delete Node with ONE child (10): " + tree.delete(10));
		tree.display(root);

		System.out.println("--------------------------------------------");

		System.out.println("Delete Node with TWO children (15): " + tree.delete(15));
		tree.display(root);
	}
}
