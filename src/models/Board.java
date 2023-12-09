package src.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size) {
        this.size = size; //3
        this.board = new ArrayList<>(); //[]
        for (int i = 0; i < size; i++) { //[[] [] []]
            this.board().add(new ArrayList<>());
            for (int j=0; j<size; j++){ //[ [_,_,_], [_,_,_], [_,_,_] ]
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public void printBoard(){
        for(int i=0; i<size;i++){
            List<Cell> row = board.get(i);
            for(int j=0; j<size;j++){
                row.get(j).display();
            }
            System.out.println();
        }
    }

    public int size() {
        return size;
    }

    public Board setSize(int size) {
        this.size = size;
        return this;
    }

    public List<List<Cell>> board() {
        return board;
    }

    public Board setBoard(List<List<Cell>> board) {
        this.board = board;
        return this;
    }
}
