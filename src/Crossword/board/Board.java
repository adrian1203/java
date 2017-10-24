package Crossword.board;

import java.util.LinkedList;

public class Board {
    private BoardCell[][] board;
    private int x;
    private int y;
    Board(int x, int y){
        board=new BoardCell[x][y];
    }
    public int getWidth(){return this.x;}
    public int getHeight(){return this.y;}
    public BoardCell getCell(int x, int y){return board[x][y];}
    public void setCell(int x, int y, BoardCell c){board[x][y]=c;}
    //public LinkedList<BoardCell> getStartCells(){}
    //String createPattern(int fromx, int fromy, int tox, int toy){}
}
