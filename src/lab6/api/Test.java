package lab6.api;

import io.indico.api.utils.IndicoException;

import java.io.IOException;


public class Test {
    public static void main(String[] arg) {
        try {
            Api api = new Api();
            api.Segregate("C:/Users/Adrian/Desktop/pliki/foto");
        } catch (IndicoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Myerr e){
            e.getMessage();

        }
    }
}