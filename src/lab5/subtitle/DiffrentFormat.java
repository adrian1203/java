package lab5.subtitle;

public class DiffrentFormat extends Exception {
    int line;
    String text;
    public DiffrentFormat(int line, String text){
        this.line=line;
        this.text=text;
    }
    void print(){
        System.out.println("Diffrent Fromat  line:"+line+"\\n"+text);
    }
}
