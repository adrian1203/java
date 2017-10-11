package lab1.primenumbers;

public class LiczbyPierwsze {
    private int liczba;
    LiczbyPierwsze(int liczba){
        this.liczba=liczba;
    }
    public void PrintPrimeNumbers(){
        int tab[] =new int[liczba+1];
        for (int i = 0; i <= liczba; i++) {
            tab[i] = i;
        }
        int n=1;
        int m=1;
        while(n<liczba){
            n+=1;
            if(Integer.valueOf(tab[n]).equals(0)){
                continue;
            }
            m=2*n;
            while(m<=liczba){
                tab[m]=0;
                m+=n;
            }
        }
        for(int i=2;i<liczba;i++){
            if(tab[i]!=0){
                System.out.println(i);
            }
        }
    }
}
