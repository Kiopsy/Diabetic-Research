package backend.utility;

public class Position {

    private int columnPosition;
    private int rowPosition;

    public Position(int column, int row){
        columnPosition = column;
        rowPosition = row;
    }

    public int getColumnPosition(){
        return columnPosition;
    }

    public int getRowPosition(){
        return rowPosition;
    }

    public void setColumnPosition(int column){
        columnPosition = column;
    }

    public void setRowPosition(int row){
        rowPosition = row;
    }
}