package lab2.Crossword;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Random;
import java.util.regex.*;

public class InteliCwDB extends CwDB {
    public InteliCwDB(String filename) throws IOException {
        super(filename);
    }

    public LinkedList<Entry> findAll(String pattern) {
        Pattern pat = Pattern.compile(pattern);
        LinkedList<Entry> list = new LinkedList<Entry>();
        for (Entry x : this.dict) {
            Matcher matcher = pat.matcher(x.getWord());
            if (matcher.find() == true) {
                list.add(x);
            }
        }
        return list;
    }

    public Entry getRandom() {
        int i=(new Random().nextInt(dict.size()));
        return dict.get(i);
    }

    ;

    public Entry getRandom(int lenght) {
        LinkedList<Entry> list = new LinkedList<Entry>();
        for (Entry x : this.dict) {

            if (x.getWord().length()==lenght) {
                list.add(x);
            }
        }
        int i=(new Random().nextInt(list.size()));
        return list.get(i);

    }

    ;

    public Entry getRandom(String pattern) {
        LinkedList<Entry> list=new LinkedList<Entry>();
        list=findAll(pattern);
        int i=(new Random().nextInt(list.size()));
        return list.get(i);

    }



    public void add(String word, String clue) {
    }
}
