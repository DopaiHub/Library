
public class Magazine extends Item{
	public Magazine()
	{
		
	}
	public Magazine(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew,int numCopies,String type,int id,String [] waitList)
	{
		super(creator, itemName, description, rating, genre, yearPublished, retail, maxTime, checkoutTime, isNew,numCopies,type,id,waitList);
	}	
	public String toString()
	{
		return super.toString();
	}
}