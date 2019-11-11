import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
import java.io.IOException;
/**
 * JsonIO has methods to read and write to JSON files
 * @author Uncrustables (Josh,Adam,Steven)
 *
 */
public class JsonIO {
	
	/**
	 * Constants for json files
	 */
	private static final String itemFile="Library/src/items.json";
	private static final String userFile="Library/src/users.json";
	
	/**
	 * loadItems method reads from a JSON file and returns an arraylist of those items
	 * @return ArrayList<items>
	 */
	public static ArrayList<Item> loadItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			FileReader reader = new FileReader(itemFile);
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray itemJSON = (JSONArray)jsonData.get("item");
			
			for(int i=0; i < itemJSON.size(); i++) {
				//Gets values from each variable
				JSONObject itemJSONIO = (JSONObject)itemJSON.get(i);
				String creator = (String)itemJSONIO.get("creator");
				String itemName = (String)itemJSONIO.get("itemName");
				String description = (String)itemJSONIO.get("description");
				double rating= (double)itemJSONIO.get("rating");
				String genre = (String)itemJSONIO.get("genre");
				int yearPublished= (int)(long)itemJSONIO.get("yearPublished");
				double retail= (double)itemJSONIO.get("retail");
				int maxTime= (int)(long)itemJSONIO.get("maxTime");
				int checkoutTime= (int)(long)itemJSONIO.get("checkoutTime");
				boolean isNew=(boolean)itemJSONIO.get("isNew");
				int numCopies=(int)(long)itemJSONIO.get("numCopies");
				String type=(String)itemJSONIO.get("type");
				int id=(int)(long)itemJSONIO.get("id");
				String[] waitList=new String[10];
				JSONArray userIDS=(JSONArray)itemJSONIO.get("waitList");
				Iterator<String> iterator=userIDS.iterator();
				int j=0;
				while(iterator.hasNext()) {
						waitList[j]=(String)iterator.next();
						j++;
				}
				String[] reviews=new String[10];
				JSONArray reviewList=(JSONArray)itemJSONIO.get("reviews");
				iterator=reviewList.iterator();
				j=0;
				while(iterator.hasNext()) {
						reviews[j]=(String)iterator.next();
						j++;
				}
				//if else adds a new item to arraylist based on type
				if(type.equalsIgnoreCase("book"))
					items.add(new Book(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type,id,waitList,reviews));
				else if (type.equalsIgnoreCase("ebook"))
					items.add(new Ebook(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type,id,waitList,reviews));
				else if (type.equalsIgnoreCase("audiobook"))
					items.add(new Audiobook(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type,id,waitList,reviews));
				else if (type.equalsIgnoreCase("dvd"))
					items.add(new DVD(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type,id,waitList,reviews));
				else if (type.equalsIgnoreCase("magazine"))
					items.add(new Magazine(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew,numCopies,type,id,waitList,reviews));
			}
			
			return items;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * loadUsers method reads from a JSON file and returns an arraylist of those users
	 * @return ArrayList<users>
	 */
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
				//Gets values from variables
				JSONObject userJSONIO = (JSONObject)userJSON.get(i);
				String firstName = (String)userJSONIO.get("firstName");
				String lastName = (String)userJSONIO.get("lastName");
				String address = (String)userJSONIO.get("address");
				int phoneNumber = (int)(long)userJSONIO.get("phoneNumber");
				String email = (String)userJSONIO.get("email");
				int age= (int)(long)userJSONIO.get("age");
				String password = (String)userJSONIO.get("password");
				int itemLimit = (int)(long)userJSONIO.get("itemLimit");
				double balance = (double)userJSONIO.get("balance");
				String type=(String)userJSONIO.get("userType");
				int[] itemL=new int[10];
				JSONArray itemIDS=(JSONArray)userJSONIO.get("itemList");
				Iterator<Long> iterator=itemIDS.iterator();
				int j=0;
				while(iterator.hasNext()) {
						itemL[j]=(int)(long)iterator.next();
						j++;
				}

				//if else statement adds user to arraylist based on type
				if(type.equalsIgnoreCase("adult"))
				{
					
				users.add(new Adult(firstName, lastName, address,
						phoneNumber, email, age, password,
						itemLimit, balance,type,itemL));
				}
				else if(type.equalsIgnoreCase("admin"))
				{
					users.add(new Admin(firstName, lastName, address,
							phoneNumber, email, age, password,
							itemLimit, balance,type, itemL));
				}
				else if(type.equalsIgnoreCase("teacher"))
				{
					users.add(new Teacher(firstName, lastName, address,
							phoneNumber, email, age, password,
							itemLimit, balance,type, itemL));
				}
				else if(type.equalsIgnoreCase("kid"))
				{
					users.add(new Kid(firstName, lastName, address,
							phoneNumber, email, age, password,
							itemLimit, balance,type, itemL));
				}
			}
			
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/**
	 * writeItem method writes to a JSON file after reading the arrayList
	 * @param itemList
	 */
	public static void writeItem(ArrayList<Item> itemList)
	{
		try {
			

			JSONArray jsonArray=new JSONArray();
			JSONObject itemDetails= new JSONObject();;
			JSONObject item=new JSONObject();
			for(int i=0; i < itemList.size(); i++) {
				//Gets values from variables
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
				int id=itemList.get(i).getId();
				String[] waitList=new String[10];
				waitList=itemList.get(i).getWaitList();
				JSONArray idList=new JSONArray();
				for(int j=0;j<waitList.length;j++)
				{
					idList.add(waitList[j]);
				}
				String[] reviews=new String[10];
				reviews=itemList.get(i).getReviews();
				JSONArray reviewList=new JSONArray();
				for(int j=0;j<reviews.length;j++)
				{
					reviewList.add(reviews[j]);
				}
				itemDetails= new JSONObject();
				//Puts variable tags and their values into itemDetails
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
				itemDetails.put("id", id);
				itemDetails.put("waitList", idList);
				itemDetails.put("reviews", reviewList);
				jsonArray.add(itemDetails);
			}
			//Print to JSON file
			JSONObject mainItem=new JSONObject();
			mainItem.put("item",jsonArray);
			FileWriter file = new FileWriter(itemFile);
            file.write(mainItem.toJSONString());
            file.flush();
            file.close();
         
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	/**
	 * writeItem method writes to a JSON file after reading the arrayList
	 * @param itemList
	 */
	public static void writeUser(ArrayList<User> userList)
	{
		try {
			JSONParser parser = new JSONParser();
			JSONArray jsonArray=new JSONArray();
			JSONObject userDetails= new JSONObject();
			JSONObject user=new JSONObject();
			for(int i=0; i < userList.size(); i++) {
				//Gets values from variables
				String firstName = userList.get(i).getFirstName();
				String lastName = userList.get(i).getLastName();
				String address = userList.get(i).getAddress();
				int phoneNumber= userList.get(i).getPhoneNumber();
				String email = userList.get(i).getEmail();
				int age= userList.get(i).getAge();
				String password=userList.get(i).getPassword();
				int itemLimit=userList.get(i).getItemLimit();
				double balance=userList.get(i).getBalance();
				int[] itemL=new int[10];
				itemL=userList.get(i).getItemList();
				JSONArray idList=new JSONArray();
				for(int j=0;j<itemL.length;j++)
				{
					idList.add(itemL[j]);
				}
				String type=userList.get(i).getUserType();
				userDetails=new JSONObject();
				//Puts variable tags and their values into userDetails
				userDetails.put("firstName",firstName);
				userDetails.put("lastName",lastName);
				userDetails.put("address",address);
				userDetails.put("phoneNumber",phoneNumber);
				userDetails.put("email",email.toString());
				userDetails.put("age",age);
				userDetails.put("password",password.toString());
				userDetails.put("itemLimit",itemLimit);
				userDetails.put("balance",balance);
				userDetails.put("userType",type);
				userDetails.put("itemList",idList);
				jsonArray.add(userDetails);
			}
			//Writes to JSON file
			JSONObject mainUser=new JSONObject();
			mainUser.put("user",jsonArray);
			FileWriter file = new FileWriter(userFile);
            file.write(mainUser.toJSONString());
            file.flush();
            file.close();
         
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


