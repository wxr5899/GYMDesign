package com.SEGroup80.Service;
import com.SEGroup80.Pojo.BasicPojo.Book;
import com.SEGroup80.Tool.GetDateTool;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookService {

    public ArrayList<Book> initBookArrangement(int visableDays) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<Book> bookArrayList = new ArrayList<Book>();

        for (int i = 0; i < visableDays; i++) {
            Date day = new GetDateTool().getBeforeOrAfterDate(new Date(),i);
            ArrayList<Integer> timeTable = new ArrayList<Integer>();
            for (int j = 0; j < 9; j++) {
                timeTable.add(0);
            }
            bookArrayList.add(new Book(""+sdf.format(day), timeTable));
        }

        return bookArrayList;
    }



    public Book showBookArrangement (ArrayList<Book> bookList, String date) {

        for (Book book : bookList) {
            if (book.getDate().equals(date)){
                return book;
            }
        }

        System.out.println("Can't find the book!");
        return null;

    }




}
