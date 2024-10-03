
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
            
        if(size % 2 == 0){
            throw new IllegalArgumentException("the size shouldn't be even");
        }
        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int row = 0;
        int column = size / 2;
        
        for(int i = 1; i <= size*size; i++){
            square.placeValue(column, row, i);
            int previousRow = row;
            int previousColumn = column;
            
            row--;
            column++;
            
            if(row < 0 ){
                row = size - 1;
            }
            
            if(column >= size){
                column %= size;
            }
            
            if(square.readValue(column, row) != 0){
                row = previousRow + 1;
                column = previousColumn;
            }
            
            if(row >= size){
                row = 0;
            }
        }
        return square;
    }

}
