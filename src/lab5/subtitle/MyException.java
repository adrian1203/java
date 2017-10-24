package lab5.subtitle;

public class MyException extends RuntimeException {
    private int line;
    private String text;
    public MyException(int line,String text){
        this.text=text;
        this.line=line;
        System.out.println("Subtitle ffffffre start line:"+line+"\n"+text);
    }
}
