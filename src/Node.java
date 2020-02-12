
public class Node<AnyType> 
{
	private int quantity;
	private AnyType item;
	private Node<AnyType> left;
	private Node<AnyType> right;
	public Node(AnyType stuff) 
	{
	item=stuff;
	setLeft(null);
	setRight(null);
	quantity=1;
	}
	public Node<AnyType> getLeft() 
	{
		return left;
	}
	public void setLeft(Node<AnyType> left) 
	{
		this.left = left;
	}
	public Node<AnyType> getRight() 
	{
		return right;
	}
	public void setRight(Node<AnyType> right) 
	{
		this.right = right;
	}
	public int getQuantity() 
	{
	return quantity;	
	}
	public AnyType getItem() 
	{
		return item;
	}
	public void setItem(AnyType item) 
	{
		this.item = item;
	}
	public void decreaseQuantity() 
	{
	quantity--;	
	}
	public void increaseQuantity()
	{
	quantity++;
	}
	
	public boolean hasLeft() 
	{
		if(left!=null)
			return true;
		else 
			return false;
	}
	public boolean hasRight() 
	{
		if(right!=null)
			return true;
		else 
			return false;
	}
}
