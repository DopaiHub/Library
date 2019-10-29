
public class Audiobook extends Item{
	public Audiobook()
	{
		
	}
	public Audiobook(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew)
	{
		super(creator, itemName, description, rating, genre, yearPublished, retail, maxTime, checkoutTime, isNew);
	}
	public String toString()
	{
		return super.toString();
	}
}