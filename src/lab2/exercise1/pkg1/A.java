package lab2.exercise1.pkg1;

public class A {
    int number;
    protected String name;
    public A(String name, int number){
        this.name=name;
        this.number=number;
    }
    private void increment(){
        number+=1;
    }
}
