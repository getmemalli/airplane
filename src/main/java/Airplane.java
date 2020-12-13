public class Airplane {


    public Airplane() {

    }

    /**
     * Create seat object for the given input
     * While creating seat object, we will find out the SeatType (Window, Aisle, Center) as well
     * @param rowsAndColumns
     * @return
     */
    Seat[][] createSeatingMatrix(int[][] rowsAndColumns) {

        int[] maxRowAndColumn = getMaxRowsAndColumns(rowsAndColumns);
        int seatMatrixRows = maxRowAndColumn[0];
        int seatMatrixColumns = maxRowAndColumn[1];

        Seat[][] seatsMatrix = new Seat[seatMatrixRows][seatMatrixColumns];

        int totalColumn = 0;
        for(int[] table: rowsAndColumns) {

            for (int row = 0; row < table[1]; row++) {

                for (int col = 0; col < table[0]; col++) {
                    int currentColumn = totalColumn + col;

                    Seat seat = new Seat();
                    if (currentColumn == 0 || currentColumn == seatMatrixColumns - 1) {
                        seat.seatType = SeatType.WINDOW;
                    }
                    else if (col == 0 || col == table[0] - 1) {
                        seat.seatType = SeatType.AISLE;
                    }
                    else {
                        seat.seatType = SeatType.CENTER;
                    }

                    seatsMatrix[row][currentColumn] = seat;
                }
            }
            totalColumn += table[0];


        }

        return seatsMatrix;
    }


    int[] getMaxRowsAndColumns(int[][] rowsAndColumns) {

        int row = 0, column = 0;

        for(int[] table: rowsAndColumns) {
            column += table[0];
            row = (row < table[1]) ? table[1] : row;
        }

        return new int[]{row, column};

    }
}
