import Exceptions.NoSeatsAvailableException;

public class Main {

    public static void main(String args[]) {

        int[][] rowsAndColumns = {{3,2}, {4,3}, {2,3}, {3,4}};
        int numberOfPassengers = 30;

        Airplane airplane = new Airplane();
        Seat[][] seats = airplane.createSeatingMatrix(rowsAndColumns);

        IAllocation allocation = new WindowFirstAllocationImpl(seats);

        for (int i = 1; i <= numberOfPassengers; i++) {
            try {
                allocation.allocateSeat(i);
            }
            catch (NoSeatsAvailableException ex) {
                System.out.println("No Seats Available");
            }
        }


        printResult(seats);

    }

    private static void printResult(Seat[][] seats) {
        System.out.println("");
        for(Seat[] seatList: seats) {
            for(Seat seat: seatList) {
                if (seat != null && seat.passengerReference != 0)
                    System.out.print(String.format("%20s", seat.passengerReference + " "  + seat.seatType) + "\t");
                else
                    System.out.print(String.format("%20s", "null") +" \t");
            }
            System.out.println("");
        }
    }
}
