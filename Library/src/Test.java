import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonIO.editBook();
		ArrayList<Book> books=JsonIO.loadBooks();
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
