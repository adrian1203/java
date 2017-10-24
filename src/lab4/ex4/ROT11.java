package lab4.ex4;

public class ROT11 implements Algorithm {
    final static char alphabet[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    final int rot=11;
    @Override
    public String crypt(String word) {


        String tmpWord ="";
        char[] wordChar = word.toCharArray();
        for(int i=0; i<wordChar.length; i++)
        {
            int k = 0;
            boolean check=false;
            for(char c : alphabet)
            {
                if(c == wordChar[i]) {
                    tmpWord += alphabet[(k + rot) % 52];
                    check=true;
                }
                k++;
            }
            if(check==false){
                tmpWord+=wordChar[i];
            }

        }
        tmpWord+=" ";
        return tmpWord;

    }

    @Override
    public String decrypt(String word) {
        String tmpWord = "";
        char[] wordChar = word.toCharArray();

        for(int i=0; i<wordChar.length;i++)
        {
            int k = 0;
            boolean check=false;
            for(char c : alphabet)
            {
                if(c == wordChar[i]) {
                    tmpWord += alphabet[(k - rot) % 52];
                    check=true;
                }
                k++;
            }
            if(check==false){
                tmpWord+=wordChar[i];
            }
        }
        tmpWord+=" ";
        return tmpWord;

    }
}
