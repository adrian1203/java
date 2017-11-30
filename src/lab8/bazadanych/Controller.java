package lab8.bazadanych;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Controller {
    public TextField isbn_field;
    public TextField title_field;
    public TextField author_field;
    public TextField year_field;
    public Button add_buton;
    public Label emptyFormLabel;
    public Button addBooks;
    public Pane panelFrom;
    public Button button_author;
    public Button isbn_button;
    public ListView listbooks;
    public DB db = new DB();
    public TextField find_author;
    public TextField isbnfind;


    public void add_books(ActionEvent actionEvent) {
        String isbn=isbn_field.getText();
        String title=title_field.getText();
        String author=author_field.getText();
        String year=year_field.getText();
     if(isbn.isEmpty() || title.isEmpty() || year.isEmpty() || author.isEmpty()){
         emptyFormLabel.setText("Uzupełnij wszytskie pola");

     }
     else{
         emptyFormLabel.setText("");
         Book book=new Book(isbn, title, author, year);
         db.addbook(book);
         isbn_field.clear();
         title_field.clear();
         year_field.clear();
         author_field.clear();
         addBooks.setText("Dodaj kolejną książke");
         panelFrom.setVisible(false);
     }
    }

    public void viewPanelForm(ActionEvent actionEvent) {
        panelFrom.setVisible(true);
    }

    public void authorfind(ActionEvent actionEvent) {
        db.searchauthor(find_author.getText());
        Viewlist();

    }

    public void isbnfind(ActionEvent actionEvent) {
        db.searchIsbn(isbnfind.getText());
        Viewlist();

    }
    public void Viewlist(){
        listbooks.getItems().clear();
        ArrayList<Book> list=db.arrayList;
        List<String> pictures = new LinkedList<>();
        for (Book x:list){
            pictures.add(x.getIsbn()+" "+x.getTitle()+" "+x.getAuthor()+" "+x.getYear());

        }
        ObservableList<String> itms = FXCollections.observableArrayList(pictures);
        listbooks.setVisible(true);
        listbooks.setItems(itms);
        list.clear();
    }
}
