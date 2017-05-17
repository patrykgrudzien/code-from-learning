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
