import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Book> books=JsonIO.loadPeople();
		
		for(Book book : books)
		{
			System.out.println(book.toString());
		}
	}

}
