package lab6.api;

public class Myerr  extends Exception{
    public String file;
    Myerr(String file){
    super(file);
    }
}
