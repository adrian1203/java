package lab8.pracownik;

public class Pracownik {
    public String pesel;
    public String name;
    public String surname;

public Pracownik(String pesel, String name, String surname){
    this.surname=surname;
    this.name=name;
    this.pesel=pesel;
}
String GetPesel(){
        return  this.pesel;
    }
    String GetName(){
        return  this.name;
    }
    String GetSurname(){
        return  this.surname;
    }
}
