
public abstract class Item {
	protected String creator;
	protected String itemName;
	protected String description;
	protected double rating;
	protected String genre;
	protected int yearPublished;
	protected double retail;
	protected int maxTime;
	protected int checkoutTime;
	protected boolean isNew;
	
	public Item()
	{
		
	}
	public Item(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew)
	{
		this.creator=creator;
		this.itemName=itemName;
		this.description=description;
		this.rating=rating;
		this.genre=genre;
		this.yearPublished=yearPublished;
		this.retail=retail;
		this.maxTime=maxTime;
		this.checkoutTime=checkoutTime;
		this.isNew=isNew;
	}
	
	public String toString()
	{
		return "\nCreator:"+creator+"\nItemName:"+itemName+"\nDescription:"+description
				+"\nRating:"+rating+"\nGenre:"+genre+"\nYearPublished:"+yearPublished
				+"\nRetail:"+retail+"\nMaxTime:"+maxTime+"\nCheckoutTime:"+checkoutTime
				+"\nisNew:"+isNew;
	}
	

}
