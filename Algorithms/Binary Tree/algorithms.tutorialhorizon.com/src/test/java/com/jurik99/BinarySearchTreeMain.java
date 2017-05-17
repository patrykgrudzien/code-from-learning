package com.jurik99;

public class BinarySearchTreeMain
{
	public static void main(final String[] args)
	{
		final BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20);
		tree.insert(30);
		tree.insert(10);
		tree.insert(14);
		tree.insert(19);
		tree.insert(1);
		tree.insert(100);

		tree.display(BinarySearchTree.root);

		System.out.println("Check whether Node with value 4 exists: " + tree.find(4));
		System.out.println("Check whether Node with value 19 exists: " + tree.find(19));
	}
}
