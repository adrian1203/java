package myPackage;

import java.io.*;

public class JIn {
    public static String getString() {
        String text = null;
        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader rbg = new BufferedReader(rd);
            text = rbg.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static int getInt() {
        int text = 0;
        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader rbg = new BufferedReader(rd);
            text = Integer.parseInt(rbg.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    public static double getDouble() {
        double text = 0;
        try {
            InputStreamReader rd = new InputStreamReader(System.in);
            BufferedReader rbg = new BufferedReader(rd);
            text = Double.parseDouble(rbg.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }


}
