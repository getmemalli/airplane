public class Seat {

    int passengerReference;
    SeatType seatType;

    public Seat() {

    }

    public Seat(SeatType seatType) {
        this.seatType = seatType;
    }

    public int getPassengerReference() {
        return passengerReference;
    }

    public void setPassengerReference(int passengerReference) {
        this.passengerReference = passengerReference;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "passengerReference=" + passengerReference +
                ", seatType=" + seatType +
                '}';
    }
}
