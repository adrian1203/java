package lab5.subtitle;

public class SubtitleEndBeforeStart extends Exception {
    int line;
    String text;
    SubtitleEndBeforeStart(int line, String text){
        this.line=line;
        this.text=text;
    }
    void print(){
        System.out.println("Subtitle end before start line:"+line+"\n"+text);
    }
}
