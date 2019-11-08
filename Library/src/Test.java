import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonIO.editBook();
		ArrayList<Item> items=JsonIO.loadItems();
		ArrayList<User> users = JsonIO.loadUsers();
		JsonIO.writeUser(users);
		JsonIO.writeItem(items);
		for(Item item : items)
		{
			System.out.println(item.toString());
		}
		
		System.out.println("\n" + "--------------------" );
		System.out.println("\n" + "User Tests:" );
		for(User user : users)
		{
			System.out.println(user.firstName + "'s balance: " + user.getBalance());
			System.out.println(user.firstName + "'s item limit: " +user.getLimit());
			System.out.println("ID:"+user.getItemList()[0]);
		} 
	}

}
