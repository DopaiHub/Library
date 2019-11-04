import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileWriter;
import java.io.IOException;
public class JsonIO {
	
	private static final String booksFile="books.json";
	
	public static ArrayList<Item> loadItems() {
		ArrayList<Item> books = new ArrayList<Item>();
		
		try {
			FileReader reader = new FileReader("Library/src/books1.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray bookJSON = (JSONArray)jsonData.get("book");
			
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
				
				books.add(new Book(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew));
			}
			
			return books;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public static ArrayList<Adult> loadUsers() {
		ArrayList<Adult> adults = new ArrayList<Adult>();
		//Temp item list
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		try {
			FileReader reader = new FileReader("Library/src/adults.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray bookJSON = (JSONArray)jsonData.get("adult");
			
			for(int i=0; i < bookJSON.size(); i++) {
				JSONObject bookJSONIO = (JSONObject)bookJSON.get(i);
				String firstName = (String)bookJSONIO.get("firstName");
				String lastName = (String)bookJSONIO.get("lastName");
				String address = (String)bookJSONIO.get("address");
				int phoneNumber = 1234567;
				String email = (String)bookJSONIO.get("email");
				int age= 30;
				String password = (String)bookJSONIO.get("password");
				int itemLimit = 5;
				double balance = 5.00;
				adults.add(new Adult(firstName, lastName, address,
						phoneNumber, email, age, password,
						itemLimit, balance, itemList));
			}
			
			return adults;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public static void writeItem(ArrayList<Item> itemList)
	{
		try {
			

			JSONArray jsonArray=new JSONArray();
			JSONObject bookDetails= new JSONObject();
			JSONObject book=new JSONObject();
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
				bookDetails.put("numCopies", numCopies);
				bookDetails.put("type", type);
				jsonArray.add(bookDetails);
				bookDetails=new JSONObject();
			}
			
			jsonArray.add(bookDetails);
			JSONObject mainBook=new JSONObject();
			mainBook.put("book",jsonArray);
			FileWriter file = new FileWriter("Library/src/books1.json");
            file.write(mainBook.toString());
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


