import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;
public class JsonIO {
	
	private static final String booksFile="books.json";
	
	public static ArrayList<Book> loadPeople() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		try {
			FileReader reader = new FileReader("src/books.json");
			JSONParser parser = new JSONParser();
			JSONObject jsonData = (JSONObject)new JSONParser().parse(reader);
			JSONArray bookJSON = (JSONArray)jsonData.get("book");
			
			for(int i=0; i < bookJSON.size(); i++) {
				JSONObject bookJSONIO = (JSONObject)bookJSON.get(i);
				String creator = (String)bookJSONIO.get("creator");
				String itemName = (String)bookJSONIO.get("itemName");
				String description = (String)bookJSONIO.get("description");
				double rating =3;
				//double rating= (double)bookJSONIO.get("rating");
				String genre = (String)bookJSONIO.get("genre");
				int yearPublished=1957;
				double retail=7.50;
				int maxTime=30;
				int checkoutTime=0;
				//int yearPublished= (int)bookJSONIO.get("yearPublished");
				//double retail= (double)bookJSONIO.get("retail");
				//int maxTime= (int)bookJSONIO.get("maxTIme");
				//int checkoutTime= (int)bookJSONIO.get("checkoutTime");
				boolean isNew=(boolean)bookJSONIO.get("isNew");
				
				books.add(new Book(creator,itemName,description,rating,genre,yearPublished,retail,maxTime,checkoutTime,isNew));
			}
			
			return books;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}


}
