
public class RBTree 
{
	private TreeNode _root;
	
	public RBTree()
	{
		_root = null;
	}
	
	public void RBInsert (TreeNode node)
	{
		TreeNode y = null;
		TreeNode x = _root;
		while (x != null)
		{
			y = x;
			if (node.getWord().compareTo(x.getWord()) < 0)
			{
				x = x.getLeft();
			}
			else
			{
				x = x.getRight();
			}
		}
		node.setParent(y);
		if (y==null)
		{
			_root = node;
		}
		else if (node.getWord().compareTo(y.getWord()) < 0)
		{
			y.setLeft(node);
		}
		else
		{
			y.setRight(node);
		}
		node.setLeft(null);
		node.setRight(null);
		node.setColor('R');
		RBInsertFixup(node);
	}
	
	private void RBInsertFixup(TreeNode node)
	{
		TreeNode y;
		if (node == _root || node.getParent() == _root)
		{
			return;
		}
		while (node.getParent().getColor() == 'R')
		{
			if (node.getParent() == node.getParent().getParent().getLeft())
			{
				y = node.getParent().getParent().getRight();
				if (y.getColor() == 'R')
				{
					node.getParent().setColor('B');
					y.setColor('B');
					node.getParent().getParent().setColor('R');
					node = node.getParent().getParent();
				}
				else if (node == node.getParent().getRight())
				{
					node = node.getParent();
					LeftRotate(node);
				}
				node.getParent().setColor('B');
				node.getParent().getParent().setColor('R');
				RightRotate(node.getParent().getParent());
			}
			else
			{
				y = node.getParent().getParent().getLeft();
				if (y.getColor() == 'R')
				{
					node.getParent().setColor('B');
					y.setColor('B');
					node.getParent().getParent().setColor('R');
					node = node.getParent().getParent();
				}
				else if (node == node.getParent().getLeft())
				{
					node = node.getParent();
					RightRotate(node);
				}
				node.getParent().setColor('B');
				node.getParent().getParent().setColor('R');
				LeftRotate(node.getParent().getParent());
			}
		}
	_root.setColor('B');
	}
	
	
	private void LeftRotate (TreeNode node)
	{
		TreeNode rNode = node.getRight();
		node.setRight(rNode.getLeft());
		if (rNode.getLeft() != null) //should we replace the null with a null node?
		{
			rNode.getLeft().setParent(node);
		}
		rNode.setParent(node.getParent());
		if (node.getParent() == null)
		{
			_root = rNode;
		}
		else if (node == node.getParent().getLeft())
		{
			node.getParent().setLeft(rNode);
		}
		else
		{
			node.getParent().setRight(rNode);
		}
		rNode.setLeft(node);
		node.setParent(rNode);
	}
	
	private void RightRotate (TreeNode node)
	{
		TreeNode lNode = node.getLeft();
		node.setLeft(lNode.getRight());
		if (lNode.getRight() != null) //should we replace the null with a null node?
		{
			lNode.getRight().setParent(node);
		}
		lNode.setParent(node.getParent());
		if (node.getParent() == null)
		{
			_root = lNode;
		}
		else if (node == node.getParent().getRight())
		{
			node.getParent().setRight(lNode);
		}
		else
		{
			node.getParent().setLeft(lNode);
		}
		lNode.setRight(node);
		node.setParent(lNode);
	}
	
}
