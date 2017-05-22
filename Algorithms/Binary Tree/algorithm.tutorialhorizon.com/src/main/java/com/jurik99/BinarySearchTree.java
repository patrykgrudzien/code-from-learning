package com.jurik99;

class BinarySearchTree
{
	static Node root;

	BinarySearchTree()
	{
		root = null;
	}

	void insert(final int number)
	{
		final Node newNode = new Node(number);

		// --- CHECK IF ROOT EXISTS ---
		if (root == null)
		{
			root = newNode;
			return;
		}

		Node current = root;
		Node parent = null;

		while (true)
		{
			parent = current;

			if (number < current.data)
			{
				current = current.left;
				if (current == null)
				{
					parent.left = newNode;
					return;
				}
			}
			else
			{
				current = current.right;
				if (current == null)
				{
					parent.right = newNode;
					return;
				}
			}
		}
	}

	boolean find(final int searchData)
	{
		Node current = root;

		while (current != null)
		{
			if (current.data == searchData)
			{
				return true;
			}
			else if (searchData < current.data)
			{
				current = current.left;
			}
			else
			{
				current = current.right;
			}
		}
		return false;
	}

	public Node getSuccessor(final Node nodeToBeDeleted)
	{
		Node successor = null;
		Node successorParent = null;
		Node current = nodeToBeDeleted.right;

		while (current != null)
		{
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		/*
		 * Check if successor has the right child, it cannot have left child for sure.
		 * If it does have the right child, add it to the left of "successorParent"
		 */
		if (successor != nodeToBeDeleted.right)
		{
			successorParent.left = successor.right;
			successor.right = nodeToBeDeleted.right;
		}
		return successor;
	}

	public boolean delete(final int id)
	{
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;

		while (current.data != id)
		{
			parent = current;
			if (id < current.data)
			{
				isLeftChild = true;
				current = current.left;
			}
			else
			{
				isLeftChild = false;
				current = current.right;
			}
			if (current == null)
			{
				return false;
			}
		}

		/*
		 * If I'm here it means we have found the node.
		 *
		 * Case 1: IF NODE TO BE DELETED HAS NO CHILDREN
		 */
		if (current.left == null && current.right == null)
		{
			if (current == root)
			{
				root = null;
			}
			if (isLeftChild)
			{
				parent.left = null;
			}
			else
			{
				parent.right = null;
			}
		}

		// --- Case 2: IF NODE TO BE DELETED HAS ONLY ONE CHILD ---
		else if (current.right == null)
		{
			if (current == root)
			{
				root = current.left;
			}
			else if (isLeftChild)
			{
				parent.left = current.left;
			}
			else
			{
				parent.right = current.left;
			}
		}
		else if (current.left == null)
		{
			if (current == root)
			{
				root = current.right;
			}
			else if (isLeftChild)
			{
				parent.left = current.right;
			}
			else
			{
				parent.right = current.right;
			}
		}

		// --- Case 3: IF NODE TO BE DELETED HAS 2 CHILDREN ---
		else if (current.left != null && current.right != null)
		{
			// --- now we have found the minimum element in the right sub tree ---
			final Node successor = getSuccessor(current);

			if (current == root)
			{
				root = successor;
			}
			else if (isLeftChild)
			{
				parent.left = successor;
			}
			else
			{
				parent.right = successor;
			}
			successor.left = current.left;
		}
		return true;
	}

	void display(final Node root)
	{
		if (root != null)
		{
			display(root.left);
			System.out.println(" " + root.data);
			display(root.right);
		}
	}
}
