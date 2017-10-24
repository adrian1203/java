package lab2.exercise1.pkg1;

public class A {
    int number;
    protected String name;
    public A(String name, int number){
        this.name=name;
        this.number=number;
    }

    public void Calldecrement(){number-=1;}
    public void  CallchangeName(){name="noweAAAA";}
    public void callincrement(){number+=1;System.out.println("A");}
    private void increment(){
        number+=1;
    }
    protected void decrement(){number+=1;}
    void changeName(){name="nowe";}


}
