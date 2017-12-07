package lab8.bazadanych;

public class ConnectException extends Exception {
   public ConnectException(){

   }
   public String printError(){
       return "Brak połączenia z bazą danych ;(";
   }
}
