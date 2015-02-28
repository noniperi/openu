// object containing the nodes of the RB Tree, whos payload is the words of the text that need to be verified.
public class TreeNode 
{
	private char _color;
	private String _word;
	private TreeNode _left;
	private TreeNode _right;
	private TreeNode _parent;
	
	
	public TreeNode(String word)
	{
		_word = word;
		_left = null;
		_right = null;
		_parent = null;
	}
	
	public TreeNode (char color, String word, TreeNode left, TreeNode right, TreeNode parent)
	{
		_color = color;
		_word = word;
		_left = left;
		_right = right;
		_parent = parent;
	}
	
	public char getColor()
	{
		return _color;
	}
	
	public void setColor(char color)
	{
		_color = color;
	}
	
	public String getWord()
	{
		return _word;
	}
	
	public void setWord(String word)
	{
		_word = word;
	}
	
	public TreeNode getLeft()
	{
		return _left;
	}
	
	public void setLeft(TreeNode left)
	{
		_left = left;
	}
	
	public TreeNode getRight()
	{
		return _right;
	}
	
	public void setRight(TreeNode right)
	{
		_right = right;
	}
	
	public TreeNode getParent()
	{
		return _parent;
	}
	
	public void setParent(TreeNode parent)
	{
		_parent = parent;
	}
}


