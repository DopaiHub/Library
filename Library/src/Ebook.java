/**
 * Ebook extends Item and calls its constructor
 * @author Uncrustables (Josh,Adam,Steven)
 *
 */
public class Ebook extends Item{
	/**
	 * Empty default constructor
	 */
	public Ebook(){}
	/**
	 * Parameterized constructor calls its super
	 * @param creator
	 * @param itemName
	 * @param description
	 * @param rating
	 * @param genre
	 * @param yearPublished
	 * @param retail
	 * @param maxTime
	 * @param checkoutTime
	 * @param isNew
	 * @param numCopies
	 * @param type
	 * @param id
	 * @param waitList
	 * @param reviews
	 */
	public Ebook(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew,int numCopies,String type,int id,String [] waitList,String[] reviews)
	{
		super(creator, itemName, description, rating, genre, yearPublished, retail, maxTime, checkoutTime, isNew,numCopies,type,id,waitList,reviews);
	}	
	/**
	 * toString calls super
	 */
	public String toString()
	{
		return super.toString();
	}
}