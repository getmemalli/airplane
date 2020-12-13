import Exceptions.NoSeatsAvailableException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WindowFirstAllocationImplTest {

    IAllocation allocation;

    @Test
    public void allocateSeat() throws NoSeatsAvailableException {

        for (int i = 0; i < 9; i++) {
            allocation.allocateSeat(i+1);
        }

        Seat[][] seats = allocation.getSeats();

        assertEquals(1, seats[0][2].passengerReference);
        assertEquals(2, seats[1][2].passengerReference);
        assertEquals(3, seats[2][2].passengerReference);

        assertEquals(4, seats[0][0].passengerReference);
        assertEquals(5, seats[1][0].passengerReference);
        assertEquals(6, seats[2][0].passengerReference);

        assertEquals(7, seats[0][1].passengerReference);
        assertEquals(8, seats[1][1].passengerReference);
        assertEquals(9, seats[2][1].passengerReference);

    }

    @Test(expected = NoSeatsAvailableException.class)
    public void allocateSeatWhenNotAvailable() throws NoSeatsAvailableException {

        for (int i = 0; i < 9; i++) {
            allocation.allocateSeat(i+1);
        }

        allocation.allocateSeat(10);

    }

    @Before
    public void setUp() throws Exception {


        Seat[][] seats = {
                {new Seat(SeatType.WINDOW), new Seat(SeatType.CENTER), new Seat(SeatType.AISLE)},
                {new Seat(SeatType.WINDOW), new Seat(SeatType.CENTER), new Seat(SeatType.AISLE)},
                {new Seat(SeatType.WINDOW), new Seat(SeatType.CENTER), new Seat(SeatType.AISLE)}
        };
        allocation = new WindowFirstAllocationImpl(seats);
    }
}