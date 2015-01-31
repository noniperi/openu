
public class RBTree 
{
	private TreeNode _root;
	private TreeNode _null;
	
	public RBTree()
	{
		_null = new TreeNode('B',null,null,null,null);
		_root = _null;
		_root.setParent(_null);
	}
	
	public TreeNode getRoot()
	{
		return _root;
	}
	
	public TreeNode getNull()
	{
		return _null;
	}
	
	public void RBInsert (TreeNode node)
	{
		TreeNode y = _null;
		TreeNode x = _root;
		while (x != _null)
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
		if (y == _null)
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
		node.setLeft(_null);
		node.setRight(_null);
		node.setColor('R');
		RBInsertFixup(node);
	}
	
	private void RBInsertFixup(TreeNode node)
	{
		TreeNode y;
		while (node.getParent() != _null && node.getParent().getColor() == 'R')
		{
			if (node.getParent().getParent() != _null)
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
					else 
					{
						if (node == node.getParent().getRight())
						{
							node = node.getParent();
							LeftRotate(node);
						}
						node.getParent().setColor('B');
						node.getParent().getParent().setColor('R');
						RightRotate(node.getParent().getParent());
					}
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
					else 
					{
						if (node == node.getParent().getLeft())
						{
							node = node.getParent();
							RightRotate(node);
						}
						node.getParent().setColor('B');
						node.getParent().getParent().setColor('R');
						LeftRotate(node.getParent().getParent());
					}
				}
			}
		}
	_root.setColor('B');
	}
	
	
	private void LeftRotate (TreeNode node)
	{
		TreeNode rNode = node.getRight();
		node.setRight(rNode.getLeft());
		if (rNode.getLeft() != _null) //should we replace the null with a null node?
		{
			rNode.getLeft().setParent(node);
		}
		rNode.setParent(node.getParent());
		if (node.getParent() == _null)
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
		if (lNode.getRight() != _null) //should we replace the null with a null node?
		{
			lNode.getRight().setParent(node);
		}
		lNode.setParent(node.getParent());
		if (node.getParent() == _null)
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
	
	public TreeNode TreeSuccessor (TreeNode x)
	{
		TreeNode y;
		if (x.getRight() != _null)
		{
			return TreeMinimum(x.getRight());
		}
		y = x.getParent();
		while (y != _null && x == y.getRight())
		{
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	public TreeNode TreeMinimum (TreeNode x)
	{
		while (x.getLeft() != _null)
		{
			x = x.getLeft();
		}
		return x;
	}
	
	public TreeNode TreeSearch (TreeNode x,String key)
	{
		if (x == _null || key.compareTo(x.getWord()) == 0 )
		{
			return x;
		}
		if (key.compareTo(x.getWord()) < 0 )
		{
			return TreeSearch (x.getLeft(),key);
		}
		else
		{
			return TreeSearch (x.getRight(),key);
		}
	}
	
	public void InorderTreeWalk (TreeNode x)
	{
		if (x != _null)
		{
			InorderTreeWalk(x.getLeft());
			System.out.println(x.getWord());
			InorderTreeWalk(x.getRight());
		}
	}
	
	public TreeNode RBDelete (TreeNode z)
	{
		TreeNode y;
		TreeNode x;
		if (z.getLeft() == _null || z.getRight() == _null)
		{
			y = z;
		}
		else
		{
			y = TreeSuccessor(z);
		}
		if (y.getLeft() != _null)
		{
			x = y.getLeft();
		}
		else
		{
			x = y.getRight();
		}
		x.setParent(y.getParent());
		if (y.getParent() == _null)
		{
			_root = x;
		}
		else 
		{
			if (y == y.getParent().getLeft())
			{
				y.getParent().setLeft(x);
			}
			else
			{
				y.getParent().setRight(x);
			}
		}
		if (y != z)
		{
			z.setWord(y.getWord());
		}
		if (y.getColor() == 'B')
		{
			RBDeleteFixup(x);
		}
		return y;
	}
	
	private void RBDeleteFixup(TreeNode x)
	{
		TreeNode w;
		while (x != _root && x.getColor() == 'B')
		{
			if (x == x.getParent().getLeft())
			{
				w = x.getParent().getRight();
				if (w.getColor() == 'R')
				{
					w.setColor('B');
					x.getParent().setColor('R');
					LeftRotate(x.getParent());
					w = x.getParent().getRight();
				}
				if (w.getLeft().getColor() == 'B' && w.getRight().getColor() == 'B')
				{
					w.setColor('R');
					x = x.getParent();
				}
				else
				{
					if (w.getRight().getColor() == 'B')
					{
						w.getLeft().setColor('B');
						w.setColor('R');
						RightRotate(w);
						w = x.getParent().getRight();
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor('B');
					w.getRight().setColor('B');
					LeftRotate(x.getParent());
					x = _root;
				}
			}
			else
			{
				w = x.getParent().getLeft();
				if (w.getColor() == 'R')
				{
					w.setColor('B');
					x.getParent().setColor('R');
					RightRotate(x.getParent());
					w = x.getParent().getLeft();
				}
				if (w.getLeft().getColor() == 'B' && w.getRight().getColor() == 'B')
				{
					w.setColor('R');
					x = x.getParent();
				}
				else
				{
					if (w.getLeft().getColor() == 'B')
					{
						w.getRight().setColor('B');
						w.setColor('R');
						LeftRotate(w);
						w = x.getParent().getLeft();
					}
					w.setColor(x.getParent().getColor());
					x.getParent().setColor('B');
					w.getLeft().setColor('B');
					RightRotate(x.getParent());
					x = _root;
				}
			}
		}
		x.setColor('B');
	}
}

