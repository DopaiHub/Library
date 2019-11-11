/**
 * Item is an abstract class that is a template for item subclasses
 * @author Uncrustables (Joshua,Adam,Steven)
 *
 */
public abstract class Item {
	/**
	 * These are all instance variables that an item will have
	 */
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
	protected int numCopies;
	protected String type;
	protected int id;
	protected String[] waitList;
	protected String[] reviews;
	
	/**
	 * Empty default constructor
	 */
	public Item(){}
	
	/**
	 * Getter method for reviews
	 * @return reviews
	 */
	/**
	 * Parameterized constructor that creates a new item with parameters
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
	public Item(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew,
			int numCopies,String type,int id,String[] waitList, String[] reviews)
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
		this.numCopies=numCopies;
		this.type=type;
		this.id=id;
		this.waitList=waitList;
		this.reviews=reviews;
	}
	public String[] getReviews() {
		return reviews;
	}
	/**
	 * Setter method for reviews
	 * @param reviews
	 */
	public void setReviews(String[] reviews) {
		this.reviews = reviews;
	}
	/**
	 * Getter method for waitList
	 * @return waitList
	 */
	public String[] getWaitList() {
		return waitList;
	}
	/**
	 * Setter method for waitList
	 * @param waitList
	 */
	public void setWaitList(String[] waitList) {
		this.waitList = waitList;
	}
	/**
	 * Getter method for id
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Setter method for id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Getter method for creator
	 * @return creator
	 */
	public String getCreator() {
		return creator;
	}
	/**
	 * Setter method for creator
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}
	/**
	 * Getter method for itemName
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * Setter method for itemName
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * Getter method for description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * Setter method for description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * Getter method for rating
	 * @return rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * Setter method for rating
	 * @param rating
	 */
	public void setRating(double rating) {
		if(rating>=1.0&&rating<=5.0)
			this.rating = rating;
		else
		{
			System.out.println("Incorrect value");
		}
	}
	/**
	 * Getter method for genre
	 * @return genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * Setter method for genre
	 * @param genre
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * Getter method for yearPublished
	 * @return yearPublished
	 */
	public int getYearPublished() {
		return yearPublished;
	}
	/**
	 * Setter method for yearPublished
	 * @param yearPublished
	 */
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	/**
	 * Getter method for retail
	 * @return retail
	 */
	public double getRetail() {
		return retail;
	}
	/**
	 * Setter method for retail
	 * @param retail
	 */
	public void setRetail(double retail) {
		this.retail = retail;
	}
	/**
	 * Getter method for maxTime
	 * @return maxTime
	 */
	public int getMaxTime() {
		return maxTime;
	}
	/**
	 * Setter method for maxTime
	 * @param maxTime
	 */
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	/**
	 * Getter method for checkoutTime
	 * @return checkoutTime
	 */
	public int getCheckoutTime() {
		return checkoutTime;
	}
	/**
	 * Setter method for checkoutTime
	 * @param checkoutTime
	 */
	public void setCheckoutTime(int checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	/**
	 * Getter method for isNew
	 * @return isNew
	 */
	public boolean isNew() {
		return isNew;
	}
	/**
	 * Setter method for isNew
	 * @param isNew
	 */
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	/**
	 * Getter method for numCopies
	 * @return numCopies
	 */
	public int getNumCopies() {
		return numCopies;
	}
	/**
	 * Setter method for numCopies
	 * @param numCopies
	 */
	public void setNumCopies(int numCopies) {
		this.numCopies = numCopies;
	}
	/**
	 * Getter method for type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Setter method for type
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * ToString method returns all the instance variables
	 */
	public String toString()
	{
		return "\nCreator:"+creator+"\nItemName:"+itemName+"\nDescription:"+description
				+"\nRating:"+rating+"\nGenre:"+genre+"\nYearPublished:"+yearPublished
				+"\nRetail:"+retail+"\nMaxTime:"+maxTime+"\nCheckoutTime:"+checkoutTime
				+"\nisNew:"+isNew+"\nNumcopies:"+numCopies+"\nType:"+type;
	}
}