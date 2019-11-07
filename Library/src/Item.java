
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
	protected int numCopies;
	protected String type;
	protected int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item()
	{
		
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
	public double getRetail() {
		return retail;
	}
	public void setRetail(double retail) {
		this.retail = retail;
	}
	public int getMaxTime() {
		return maxTime;
	}
	public void setMaxTime(int maxTime) {
		this.maxTime = maxTime;
	}
	public int getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(int checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public Item(String creator,String itemName,String description,double rating,
			String genre,int yearPublished,double retail,int maxTime,int checkoutTime,boolean isNew,
			int numCopies,String type,int id)
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
	}
	public int getNumCopies() {
		return numCopies;
	}
	public void setNumCopies(int numCopies) {
		this.numCopies = numCopies;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString()
	{
		return "\nCreator:"+creator+"\nItemName:"+itemName+"\nDescription:"+description
				+"\nRating:"+rating+"\nGenre:"+genre+"\nYearPublished:"+yearPublished
				+"\nRetail:"+retail+"\nMaxTime:"+maxTime+"\nCheckoutTime:"+checkoutTime
				+"\nisNew:"+isNew+"\nNumcopies:"+numCopies+"\nType:"+type;
	}
}