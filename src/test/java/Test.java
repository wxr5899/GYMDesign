import com.SEGroup80.Pojo.BasicPojo.Book;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        ArrayList<Book> bookArrayList = new ArrayList<>();
        bookArrayList.add(null);
        System.out.println(bookArrayList.isEmpty());
        System.out.println(bookArrayList.size());
    }
}

