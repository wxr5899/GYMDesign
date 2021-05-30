package com.SEGroup80.Controller;

import com.SEGroup80.App;
import com.SEGroup80.Bean.TemBean;
import com.SEGroup80.Pojo.BasicPojo.Book;
import com.SEGroup80.Pojo.UserPojo.Coach;
import com.SEGroup80.Pojo.UserPojo.Trainer;
import com.SEGroup80.Service.BookService;
import com.SEGroup80.Service.ModifyFileService;
import com.SEGroup80.Tool.DateTool;
import com.SEGroup80.Tool.PageTransTool;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    private int visableDays = 7;

    private final int liveClassNum = 9;

    private Coach coach;

    private Parent root;

    private Book book;

    private int timePointIndex;

    private int dateIndex;

    private ArrayList<Book> bookArrayList;

    private ArrayList<String> timePointList = new ArrayList<>();

    private DateTool dateTool = new DateTool();

    private Trainer trainer;

    @FXML
    private AnchorPane rootLayout;

    @FXML
    private ChoiceBox dateChoiceBox;

    @FXML
    private Rectangle rectangle1, rectangle2, rectangle3, rectangle4;

    @FXML
    private Rectangle rectangle5, rectangle6, rectangle7, rectangle8, rectangle9;

    @FXML
    private Label CoachName, CoachAge, CoachGender;

    @FXML
    private ImageView BackHomeImageView, BookImageView;

    @FXML
    public void bookClick(MouseEvent mouseEvent) throws ParseException {

        Rectangle rectangle = (Rectangle) mouseEvent.getSource();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String currentTimePointStr = simpleDateFormat.format(new Date());

        timePointIndex = Integer.parseInt("" + rectangle.getId().charAt(rectangle.getId().length() - 1)) - 1;

        if (dateChoiceBox.getValue() != null) {

            if (dateChoiceBox.getValue().equals(dateFormat.format(new Date()))){
                if (dateTool.CompareTimeString(currentTimePointStr, timePointList.get(timePointIndex), simpleDateFormat)) {
                    if (rectangle.getOpacity() != 0.5) {
                        if ((rectangle.getFill().equals(Color.BLACK)) && (!rectangle.getFill().equals(Color.WHITE))) {
                            rectangle.setFill(Color.WHITE);
                            book.getTimeTable().set(timePointIndex, 0);
                            book.setTrainerID(null);
                            book.setCoachID(coach.getUserID());
                        } else {
                            rectangle.setFill(Color.BLACK);
                            book.getTimeTable().set(timePointIndex, 1);
                            book.setTrainerID(trainer.getUserID());
                            book.setCoachID(coach.getUserID());
                        }
                        bookArrayList.set(dateIndex, book);
                        System.out.println(bookArrayList);
                    }
                }
            } else {
                if (rectangle.getOpacity() != 0.5) {
                    if ((rectangle.getFill().equals(Color.BLACK)) && (!rectangle.getFill().equals(Color.WHITE))) {
                        rectangle.setFill(Color.WHITE);
                        book.getTimeTable().set(timePointIndex, 0);
                    } else {
                        rectangle.setFill(Color.BLACK);
                        book.getTimeTable().set(timePointIndex, 1);
                    }
                    bookArrayList.set(dateIndex, book);
                    System.out.println(bookArrayList);
                }
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*
            Init the time point of the class
         */
        rectangle1.setOpacity(1);
        rectangle2.setOpacity(1);
        rectangle3.setOpacity(1);
        rectangle4.setOpacity(1);
        rectangle5.setOpacity(1);
        rectangle6.setOpacity(1);
        rectangle7.setOpacity(1);
        rectangle8.setOpacity(1);
        rectangle9.setOpacity(1);

        timePointList.add("08:00:00");
        timePointList.add("09:00:00");
        timePointList.add("10:00:00");
        timePointList.add("11:00:00");

        timePointList.add("14:00:00");
        timePointList.add("15:00:00");
        timePointList.add("16:00:00");

        timePointList.add("20:00:00");
        timePointList.add("21:00:00");


        coach = TemBean.getCoach();
        trainer = TemBean.getTrainer();

        CoachName.setText(coach.getName());
        CoachAge.setText("" + coach.getAge());


        if (coach.isSex()) {
            CoachGender.setText("Lady");
        } else {
            CoachGender.setText("Sir");
        }


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < visableDays; i++) {
            Date day = new DateTool().getBeforeOrAfterDate(new Date(),i);
            dateChoiceBox.getItems().addAll(""+sdf.format(day));
        }

        dateChoiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {

                String date = (String) observableValue.getValue();

                BookService bookService = new BookService();


                if (bookArrayList == null){
                    if (coach.getBookList() == null){
                        bookArrayList = bookService.initBookArrangement(coach.getUserID(), visableDays);
                    } else {
                        try {
                            bookArrayList = bookService.extractFutureBookArrangement(coach, visableDays);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                }

                book = bookService.showBookArrangement(bookArrayList, date);

                //TODO:
                System.out.println(bookArrayList);
                System.out.println(book);

                dateIndex = bookArrayList.indexOf(book);

                System.out.println("date Index:" + dateIndex);

                if (book.getTimeTable().get(0) == 0){
                    rectangle1.setFill(Color.WHITE);
                } else {
                    rectangle1.setFill(Color.BLACK);
                    rectangle1.setOpacity(0.5);
                }

                if (book.getTimeTable().get(1) == 0){
                    rectangle2.setFill(Color.WHITE);
                } else {
                    rectangle2.setFill(Color.BLACK);
                    rectangle2.setOpacity(0.5);
                }

                if (book.getTimeTable().get(2) == 0){
                    rectangle3.setFill(Color.WHITE);
                } else {
                    rectangle3.setFill(Color.BLACK);
                    rectangle3.setOpacity(0.5);
                }

                if (book.getTimeTable().get(3) == 0){
                    rectangle4.setFill(Color.WHITE);
                } else {
                    rectangle4.setFill(Color.BLACK);
                    rectangle4.setOpacity(0.5);
                }

                if (book.getTimeTable().get(4) == 0){
                    rectangle5.setFill(Color.WHITE);
                } else {
                    rectangle5.setFill(Color.BLACK);
                    rectangle5.setOpacity(0.5);
                }

                if (book.getTimeTable().get(5) == 0){
                    rectangle6.setFill(Color.WHITE);
                } else {
                    rectangle6.setFill(Color.BLACK);
                    rectangle6.setOpacity(0.5);
                }

                if (book.getTimeTable().get(6) == 0){
                    rectangle7.setFill(Color.WHITE);
                } else {
                    rectangle7.setFill(Color.BLACK);
                    rectangle7.setOpacity(0.5);
                }

                if (book.getTimeTable().get(7) == 0){
                    rectangle8.setFill(Color.WHITE);
                } else {
                    rectangle8.setFill(Color.BLACK);
                    rectangle8.setOpacity(0.5);
                }

                if (book.getTimeTable().get(8) == 0){
                    rectangle9.setFill(Color.WHITE);
                } else {
                    rectangle9.setFill(Color.BLACK);
                    rectangle9.setOpacity(0.5);
                }
            }
        });

    }

    @FXML
    public void checkOutBook() throws IOException {
        coach.setBookList(bookArrayList);
        trainer.setBookList(bookArrayList);
        System.out.println(coach.toString());
        new ModifyFileService().modifyUserFile(coach);
        new ModifyFileService().modifyUserFile(trainer);
        TemBean.setCoach(coach);
        TemBean.setTrainer(trainer);
        BackToHome();
    }

    @FXML
    public void BackToHome() throws IOException {
        root = App.loadFXML("HomeInterface");
        new PageTransTool().TransToAnotherPage(rootLayout, root);
    }

}
