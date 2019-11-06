import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
import java.io.IOException;
public class JsonIO {
	
	private static final String itemFile="Library/src/items.json";
	private static final String userFile="Library/src/users.json";
	
	public static ArrayList<Item> loadItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			FileReader reader = new FileReader(itemFile);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray bookJSON = (JSONArray)jsonData.get("item");
			
			for(int i=0; i < bookJSON.size(); i++) {
				JSONObject bookJSONIO = (JSONObject)bookJSON.get(i);
				String creator = (String)bookJSONIO.get("creator");
				String itemName = (String)bookJSONIO.get("itemName");
				String description = (String)bookJSONIO.get("description");
				double rating= (double)(long)bookJSONIO.get("rating");
				String genre = (String)bookJSONIO.get("genre");
				int yearPublished= (int)(long)bookJSONIO.get("yearPublished");
				double retail= (double)bookJSONIO.get("retail");
				int maxTime= (int)(long)bookJSONIO.get("maxTime");
				int checkoutTime= (int)(long)bookJSONIO.get("checkoutTime");
				boolean isNew=(boolean)bookJSONIO.get("isNew");
				int numCopies=(int)(long)bookJSONIO.get("numCopies");
				String type=(String)bookJSONIO.get("type");
				
				if(type.equalsIgnoreCase("book"))
					items.add(new Book(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type));
				else if (type.equalsIgnoreCase("ebook"))
					items.add(new Ebook(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type));
				else if (type.equalsIgnoreCase("audiobook"))
					items.add(new Audiobook(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type));
				else if (type.equalsIgnoreCase("dvd"))
					items.add(new DVD(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type));
				else if (type.equalsIgnoreCase("magazine"))
					items.add(new Magazine(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type));
			}
			
			return items;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}



	public static ArrayList<User> loadUsers() {
		ArrayList<User> users = new ArrayList<User>();
		//Temp item list
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		try {
			FileReader reader = new FileReader(userFile);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray userJSON = (JSONArray)jsonData.get("user");
			
			for(int i=0; i < userJSON.size(); i++) {
				JSONObject userJSONIO = (JSONObject)userJSON.get(i);
				String firstName = (String)userJSONIO.get("firstName");
				String lastName = (String)userJSONIO.get("lastName");
				String address = (String)userJSONIO.get("address");
				int phoneNumber = 1234567;
				String email = (String)userJSONIO.get("email");
				int age= 30;
				String password = (String)userJSONIO.get("password");
				int itemLimit = 5;
				double balance = 5.00;
				String type=(String)userJSONIO.get("userType");
				if(type.equalsIgnoreCase("adult"))
				{
					
				users.add(new Adult(firstName, lastName, address,
						phoneNumber, email, age, password,
						itemLimit, balance,type,itemList));
				}
				else if(type.equalsIgnoreCase("admin"))
				{
					users.add(new Admin(firstName, lastName, address,
							phoneNumber, email, age, password,
							itemLimit, balance,type, itemList));
				}
				else if(type.equalsIgnoreCase("teacher"))
				{
					users.add(new Teacher(firstName, lastName, address,
							phoneNumber, email, age, password,
							itemLimit, balance,type, itemList));
				}
				else if(type.equalsIgnoreCase("kid"))
				{
					users.add(new Kid(firstName, lastName, address,
							phoneNumber, email, age, password,
							itemLimit, balance,type, itemList));
				}
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void writeItem(ArrayList<Item> itemList)
	{
		try {
			

			JSONArray jsonArray=new JSONArray();
			JSONObject itemDetails= new JSONObject();
			JSONObject item=new JSONObject();
			for(int i=0; i < itemList.size(); i++) {
				String creator = itemList.get(i).getCreator();
				String itemName = itemList.get(i).getItemName();
				String description = itemList.get(i).getDescription();
				double rating= itemList.get(i).getRating();
				String genre = itemList.get(i).getGenre();
				int yearPublished= itemList.get(i).getYearPublished();
				double retail= itemList.get(i).getRetail();
				int maxTime= itemList.get(i).getMaxTime();
				int checkoutTime= itemList.get(i).getCheckoutTime();
				boolean isNew=itemList.get(i).isNew();
				int numCopies=itemList.get(i).getNumCopies();
				String type=itemList.get(i).getType();
				itemDetails.put("creator",creator);
				itemDetails.put("itemName",itemName);
				itemDetails.put("description",description);
				itemDetails.put("rating",rating);
				itemDetails.put("genre",genre);
				itemDetails.put("yearPublished", yearPublished);
				itemDetails.put("retail",retail);
				itemDetails.put("maxTime", maxTime);
				itemDetails.put("checkoutTime", checkoutTime);
				itemDetails.put("isNew", isNew);
				itemDetails.put("numCopies", numCopies);
				itemDetails.put("type", type);
				jsonArray.add(itemDetails);
				itemDetails=new JSONObject();
			}
			
			jsonArray.add(itemDetails);
			JSONObject mainItem=new JSONObject();
			mainItem.put("item",jsonArray);
			FileWriter file = new FileWriter(itemFile);
            file.write(mainItem.toString());
            file.flush();
            file.close();
         
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	public static void writeUser(ArrayList<User> userList)
	{
		try {
			

			JSONArray jsonArray=new JSONArray();
			JSONObject userDetails= new JSONObject();
			JSONObject user=new JSONObject();
			for(int i=0; i < userList.size(); i++) {
				String firstName = userList.get(i).getFirstName();
				String lastName = userList.get(i).getLastName();
				String address = userList.get(i).getAddress();
				int phoneNumber= userList.get(i).getPhoneNumber();
				String email = userList.get(i).getEmail();
				int age= userList.get(i).getAge();
				String password=userList.get(i).getPassword();
				int itemLimit=userList.get(i).getItemLimit();
				double balance=userList.get(i).getBalance();
				ArrayList<Item> itemL=new ArrayList<Item>();
				String type=userList.get(i).getUserType();
				userDetails.put("firstName",firstName);
				userDetails.put("lastName",lastName);
				userDetails.put("address",address);
				userDetails.put("phoneNumber",phoneNumber);
				userDetails.put("email",email);
				userDetails.put("age",age);
				userDetails.put("password",password);
				userDetails.put("itemLimit",itemLimit);
				userDetails.put("balance",balance);
				userDetails.put("userType",type);
				userDetails.put("itemList",itemL);
				jsonArray.add(userDetails);
				userDetails=new JSONObject();
			}
			
			jsonArray.add(userDetails);
			JSONObject mainUser=new JSONObject();
			mainUser.put("user",jsonArray);
			FileWriter file = new FileWriter(userFile);
            file.write(mainUser.toString());
            file.flush();
            file.close();
         
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void editBook()
	{
		try {
			FileReader reader = new FileReader("Library/src/books1.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray bookJSON = (JSONArray)jsonData.get("book");
			

			JSONArray jsonArray=new JSONArray();
			JSONObject bookDetails= new JSONObject();
			JSONObject book=new JSONObject();
			for(int i=0; i < bookJSON.size(); i++) {
				JSONObject bookJSONIO = (JSONObject)bookJSON.get(i);
				String creator = (String)bookJSONIO.get("creator");
				String itemName = (String)bookJSONIO.get("itemName");
				String description = (String)bookJSONIO.get("description");
				double rating= (double)bookJSONIO.get("rating");
				String genre = (String)bookJSONIO.get("genre");
				int yearPublished= (int)(long)bookJSONIO.get("yearPublished");
				double retail= (double)bookJSONIO.get("retail");
				int maxTime= (int)(long)bookJSONIO.get("maxTime");
				int checkoutTime= (int)(long)bookJSONIO.get("checkoutTime");
				boolean isNew=(boolean)bookJSONIO.get("isNew");
				bookDetails.put("creator",creator);
				bookDetails.put("itemName",itemName);
				bookDetails.put("description",description);
				bookDetails.put("rating",rating);
				bookDetails.put("genre",genre);
				bookDetails.put("yearPublished", yearPublished);
				bookDetails.put("retail",retail);
				bookDetails.put("maxTime", maxTime);
				bookDetails.put("checkoutTime", checkoutTime);
				bookDetails.put("isNew", isNew);
				jsonArray.add(bookDetails);
				bookDetails=new JSONObject();
			}
			
			bookDetails=new JSONObject();
			bookDetails.put("creator","Test Author");
			bookDetails.put("itemName","Test Book"); bookDetails.put("description",
			"Random book"); bookDetails.put("rating", 2.0);
			bookDetails.put("genre","fiction"); bookDetails.put("yearPublished", 2020);
			bookDetails.put("retail",50.00); bookDetails.put("maxTime", 30);
		    bookDetails.put("checkoutTime", 0); bookDetails.put("isNew", true);
			jsonArray.add(bookDetails);
			JSONObject mainBook=new JSONObject();
			mainBook.put("book",jsonArray);
			FileWriter file = new FileWriter("Library/src/books1.json");
            file.write(mainBook.toString());
            file.flush();
            file.close();
         
 
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}


