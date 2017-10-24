package Crossword.board;

import Crossword.dictionary.Entry;

import java.util.Enumeration;

public class CwEntry extends Entry {
    CwEntry(String word, String clue, int x, int y, Dircetion d) {
        super(word, clue);
        this.x = x;
        this.y = y;
        this.d = d;
    }

    private int x;
    private int y;

    private enum Dircetion {
        HORIZ,
        VERT;
    }

    private Dircetion d;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDir() {
        if (this.d.equals(Dircetion.HORIZ)) return 1;
        else return 0;
    }
}
