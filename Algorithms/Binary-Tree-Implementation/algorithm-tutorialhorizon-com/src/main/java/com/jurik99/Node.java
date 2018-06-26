package com.jurik99;

/*
 * Binary Tree: A data structure in which we have nodes containing data and two references to other nodes, one on the
 * left and one on the right.
 *
 * Binary Tree consist of Nodes.
 * 1) Nodes are nothing but objects of a class and each node has data and a link to the left node and right node.
 * 2) Usually we call the starting node of a tree as "ROOT".
 * 3) Left and right node of a "Leaf" node points to NULL so you will know that you have reached to the end of the tree.
 */
public class Node {

	int data;
	Node left;
	Node right;

	public Node(final int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
