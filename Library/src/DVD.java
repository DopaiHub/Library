
public class DVD extends Item{
	public DVD()
	{
		
	}
	public DVD(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew,int numCopies,String type,int id,String [] waitList,String[] reviews)
	{
		super(creator, itemName, description, rating, genre, yearPublished, retail, maxTime, checkoutTime, isNew,numCopies,type,id,waitList,reviews);
		this.maxTime=10;
	}
	public String toString()
	{
		return super.toString();
	}
}