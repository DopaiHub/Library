
public class Book extends Item {
	public Book()
	{
		
	}
	public Book(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew,int numCopies,String type,int id)
	{
		super(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type,id);
	}
	public String toString()
	{
		return super.toString();
	}
}