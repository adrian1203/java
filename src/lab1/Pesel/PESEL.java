package lab1.Pesel;

public class PESEL {
    String pesel;
    PESEL(String pesel){
        this.pesel=pesel;
    }
    public boolean check(){
        int valueIteration[]={9,7,3,1,9,7,3,1,9,7};
        int tmp=0;
        if(pesel.length()!=11){
           return false;
        }
        for(int i=0;i<10;i++){
            tmp+=Integer.parseInt(pesel.substring(i,i+1))*valueIteration[i];
        }
        return Integer.valueOf(tmp%10).equals(Integer.parseInt(pesel.substring(10,11)));
    }
}
