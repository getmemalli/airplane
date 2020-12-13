import Exceptions.NoSeatsAvailableException;

public class WindowFirstAllocationImpl implements IAllocation {

    Seat[][] seats;
    ListNode windowList, aisleList, centerList;

    public Seat[][] getSeats() {
        return seats;
    }

    public WindowFirstAllocationImpl(Seat[][] seats) {
        this.seats = seats;

        this.windowList = createSeatSequenceForType(seats, SeatType.WINDOW);
        this.aisleList = createSeatSequenceForType(seats, SeatType.AISLE);
        this.centerList = createSeatSequenceForType(seats, SeatType.CENTER);
    }

    /**
     * This method is used to create linked list based on seatType
     * So we don't need to loop through all the seats every time during allocation
     * We can just move to next node once seat is allocated
     * @param seats
     * @param seatType
     * @return
     */
    private ListNode createSeatSequenceForType(Seat[][] seats, SeatType seatType) {
        ListNode output = new ListNode();
        ListNode temp = output;

        for(Seat[] seatList: seats) {
            for(Seat seat: seatList) {
                if (seat != null)
                    if (seat.seatType == seatType) {
                        temp.next = new ListNode(seat);
                        temp = temp.next;
                    }
            }
        }

        return output.next;
    }

    /**
     * This method assigns the passenger to the next available seat as per the following rules
     *      1. Starting from front to back and left to right
     *      2. Aisle seats to be filled first
     *      3. Followed by center seats
     *      4. Finally middle seats
     *  throws exception when no seats available
     * @param passengerNumber
     * @throws NoSeatsAvailableException
     */
    @Override
    public void allocateSeat(int passengerNumber) throws NoSeatsAvailableException {

        if (this.aisleList != null) {
            this.aisleList.seat.passengerReference = passengerNumber;
            this.aisleList = this.aisleList.next;
        }
        else if (this.windowList != null) {
            this.windowList.seat.passengerReference = passengerNumber;
            this.windowList = this.windowList.next;
        }
        else if (this.centerList != null) {
            this.centerList.seat.passengerReference = passengerNumber;
            this.centerList = this.centerList.next;
        }
        else {
            throw new NoSeatsAvailableException("No Seats Available");
        }

    }
}

class ListNode {

    Seat seat;
    ListNode next;

    ListNode() {

    }
    ListNode(Seat seat) {
        this.seat = seat;
    }
}
