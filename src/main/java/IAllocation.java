import Exceptions.NoSeatsAvailableException;

public interface IAllocation {

    void allocateSeat(int passengerNumber) throws NoSeatsAvailableException;
    Seat[][] getSeats();
}
