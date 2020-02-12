
public class Bag<AnyType extends Comparable<AnyType>> 
{
private int size;
private int distictsize;
private int i=0;// used for equals() method
private Node<AnyType> root;
public Bag() {
size=0;
distictsize=0;
root=null;	
}
public void add(AnyType item) {
	
	size++;
	root= add(item,root);//A1
}
private Node<AnyType> add(AnyType Item,Node<AnyType> temp){
	if(temp==null)//A2
	{
	distictsize++;
	return new Node<AnyType>(Item);	
	}
	else //A3
	{
		if(Item.compareTo(temp.getItem()) <0)
		{
			
			temp.setLeft(add(Item,temp.getLeft()));
		}
		else if(Item.compareTo(temp.getItem())>0)
		{
			temp.setRight(add(Item,temp.getRight()));
			
		}
		else if(Item.compareTo(temp.getItem())==0)//A4
		temp.increaseQuantity();
		return temp;
	}
}
public boolean remove(AnyType item) {
if(!Contains(item)) 
{
	System.out.println("The ["+item+"] item is not contained in the bag");
	return false;
}
else 
{
	size--;
	root = remove(item,root);
	return true;
}
}

private Node<AnyType> remove(AnyType item,Node<AnyType> temp){
	
	if(item.compareTo(temp.getItem())<0)//B1 
		temp.setLeft(remove(item,temp.getLeft()));
	else if(item.compareTo(temp.getItem())>0)//B2
		temp.setRight(remove(item,temp.getRight()));
	else //B3
	{
	     if(temp.getQuantity()>1) //B4
	    {
		  temp.decreaseQuantity();
		  return temp;
	    }
	     else //B5
	    { 
	    	 distictsize--;
	    	 if(temp.getLeft()==null && temp.getRight()==null)//B6
	        {
	    	 temp=null;
	        }
	    	 else if(temp.getLeft()==null) //B7
	    		return temp.getRight();
	    	 else if(temp.getRight()==null) //B8
	    		 return temp.getLeft();
	    	 else //B9
	    	 {
	    		 Node<AnyType> minfromright=findMinFromRight(temp.getRight());
	    		 temp.setItem(minfromright.getItem());
	    		 temp.setRight(remove(minfromright.getItem(),temp.getRight()));
	    	 }
	    }
 }
return temp;	
}

private Node<AnyType> findMinFromRight(Node<AnyType> node) {//B10
	while(node.getLeft()!=null)
	{
		node=node.getLeft();
	}
	return node;
}
public int Size() {
	return size;
}
public int DistictSize() {
	return distictsize;
}
public boolean Contains(AnyType item){
	if(root==null)//E1
		return false;
Node<AnyType> current=root;
boolean exist=false;
while(!exist)//E2
{
 if(item.compareTo(current.getItem())<0)//E3
 {
	 if(current.getLeft()!=null)
	 current=current.getLeft();
	 else 
	 break;
 }
 else if(item.compareTo(current.getItem())>0)//E4
 {
	 if(current.getRight()!=null)
		 current=current.getRight();
		 else 
		 break;
 }
 else if(item.compareTo(current.getItem())==0)//E5
 {
	 exist=true;
 }
}
return exist;	
}
@Override
public boolean equals(Object obj) {
	Bag bag=(Bag) obj;//F1
	equals(bag,root);
	if(bag.DistictSize()!=DistictSize()|| bag.Size()!=Size())//F2
		return false;
	else if(i>0)//F3
		return false;
	 else 
		 return true;
}
private void equals(Bag bag,Node<AnyType>root) {
	if(!bag.Contains(root.getItem()))//F4
		i++;
	 if(root.hasLeft()) 
	{
		equals(bag,root.getLeft());//F5
	
	}
	 if(root.hasRight()) //F6
	{
		equals(bag,root.getRight());
	}
}
public int ElementSize(AnyType item) {
	Node<AnyType> current = root;
	boolean found=false;
	if(!Contains(item))//G1
		return 0;
	else 
 {
	while(!found) 
	{
		if(item.compareTo(current.getItem())<0) //G2
		{
		current=current.getLeft();	
		}
		else if(item.compareTo(current.getItem())>0) //G3
		{
		current=current.getRight();	
		}
		else if(item.compareTo(current.getItem())==0) //G4
		{
			found=true;
		}
	}
	return current.getQuantity();//G5
 }
}
public boolean isEmpty() {
	if(root==null)
		return true;
	else
		return false;
}
public void clear() {
	size=0;
	distictsize=0;
	root=null;
}
@Override
public String toString() {
return toString(root);//H1
}
private String toString(Node<AnyType> root) {
if(isEmpty()) //H2
{
return "Bag is empty";	
}
else {//H3
    Node<AnyType> current = root;
    String result = "";
    if (current == null)//H4 
    {
        return "";
    }
    result += "[" + current.getItem().toString() + "" + "("+current.getQuantity()+ ")"+ "]";
    result += toString(current.getLeft());
    result += toString(current.getRight());
    return result;
    }
}
}
