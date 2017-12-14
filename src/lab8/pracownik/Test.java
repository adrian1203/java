package lab8.pracownik;

import lab8.pracownik.DB;

public class Test {
    public static void main(String[] args) throws Exception {
        DB db= new DB();
        Pracownik pracownik=new Pracownik("12032539989", "Niezany ", "Nieznany");
        db.addbook(pracownik);
        db.searchIsbn("12032539989");




    }
}
