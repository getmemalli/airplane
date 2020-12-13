import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirplaneTest {

    Airplane airplane;

    @Before
    public void setUp() throws Exception {
        airplane = new Airplane();
    }

    @Test
    public void createSeatingMatrix() {
        int[][] rowsAndColumns = {{3,2}, {4,3}, {2,3}, {3,4}};
        Seat[][] seats = airplane.createSeatingMatrix(rowsAndColumns);

        assertEquals(4, seats.length);
        assertNull(seats[2][0]);
        assertNull(seats[2][1]);
        assertNull(seats[2][2]);
        assertNotNull(seats[2][3]);
    }

    @Test
    public void getMaxRowsAndColumns() {
        int[][] rowsAndColumns = {{3,2}, {4,3}, {2,3}, {3,4}};
        int[] maxRowAndColumn = airplane.getMaxRowsAndColumns(rowsAndColumns);

        assertArrayEquals(new int[]{4, 12}, maxRowAndColumn);
    }
}