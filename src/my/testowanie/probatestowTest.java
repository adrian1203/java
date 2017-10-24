package my.testowanie;

public class probatestowTest {
    static void dodaj() throws probatestow{
        int d=3+59;
        if(d==10){
            throw new probatestow();
        }
    }
    public static void main(String[] args) {
        try{
            dodaj();
        }
        catch (probatestow a){
            a.foo();
        }
    }

}