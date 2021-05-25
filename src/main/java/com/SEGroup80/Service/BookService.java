package com.SEGroup80.Service;
import com.SEGroup80.Pojo.BasicPojo.Book;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Tool.DateTool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class BookService {

    public ArrayList<Book> initBookArrangement(int visableDays) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        ArrayList<Book> bookArrayList = new ArrayList<Book>();

        for (int i = 0; i < visableDays; i++) {
            Date day = new DateTool().getBeforeOrAfterDate(new Date(),i);
            ArrayList<Integer> timeTable = new ArrayList<Integer>();
            for (int j = 0; j < 9; j++) {
                timeTable.add(0);
            }
            bookArrayList.add(new Book(""+sdf.format(day), timeTable));
        }

        return bookArrayList;
    }


    public ArrayList<Book> extractFutureBookArrangement(Coach coach, int visableDays) throws ParseException {

        DateTool dateTool = new DateTool();

        ArrayList<Book> extantBookList = null;

        ArrayList<Book> futureBookList = initBookArrangement(visableDays);

        ArrayList<Book> mergedBookList = new ArrayList<>();

        Date today = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String todayStr = simpleDateFormat.format(today);

        Book lastBook = null;

        extantBookList = coach.getBookList();
        if (!extantBookList.isEmpty()){
            lastBook = extantBookList.get(extantBookList.size() - 1);
        }

        int num = 0;

        if (lastBook != null) {
            if (dateTool.CompareTimeString(lastBook.getDate(), todayStr, simpleDateFormat)){
                return futureBookList;
            } else {
                for (Book book : extantBookList){
                    if (dateTool.CompareTimeString(todayStr, book.getDate(), simpleDateFormat)) {
                        mergedBookList.add(book);
                        num += 1;
                    }
                }

                for (int i = num - 1; i < visableDays; i++) {
                    mergedBookList.add(futureBookList.get(i));
                }
                return mergedBookList;
            }
        } else {
            return futureBookList;
        }
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
