package kolos.wzrozecbuilder;

public class A {
    private int a;
    private int b;
    protected A(Builder bulider){
        this.a=bulider.a;
        this.b=bulider.b;
    }
    public static class Builder{
        private int a;
        private int b;
        public Builder adda(int a){
            this.a=a;
            return this;
        }
        public Builder addb(int b){
            this.b=b;
            return this;
        }
        public A build(){
            return new A(this);
        }
    }
    public static Builder builder(){return new A.Builder();}
}
