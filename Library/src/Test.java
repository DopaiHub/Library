import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	JsonIO.editBook();
		ArrayList<Item> items=JsonIO.loadItems();
		ArrayList<Adult> adults = JsonIO.loadUsers();
		for(Item item : items)
		{
			System.out.println(item.toString());
		}
		
		System.out.println("\n" + "--------------------" );
		System.out.println("\n" + "User Tests:" );
		for(Adult adult : adults)
		{
			System.out.println(adult.firstName + "'s balance: " + adult.getBalance());
			System.out.println(adult.firstName + "'s item limit: " +adult.getLimit());
		} 
	}

}
