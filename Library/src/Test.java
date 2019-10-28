import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Book> books=JsonIO.loadPeople();
		ArrayList<Adult> adults = JsonIO.loadUsers();
		
		for(Book book : books)
		{
			System.out.println(book.toString());
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
