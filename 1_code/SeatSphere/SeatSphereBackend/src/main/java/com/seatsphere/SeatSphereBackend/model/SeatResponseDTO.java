package com.seatsphere.SeatSphereBackend.model;

public class SeatResponseDTO {
    private Long id;
    private String seatRow;
    private int seatNumber;
    private boolean isOccupied; // This is the "calculated" value
    private boolean isHandicap;

    // Constructor that takes the physical Seat and the calculated status
    public SeatResponseDTO(Seat seat, boolean occupied) {
        this.id = seat.getId();
        this.seatRow = seat.getSeatRow();
        this.seatNumber = seat.getSeatNumber();
        this.isOccupied = occupied;
        this.isHandicap = seat.isHandicap();
    }

    // Getters (Required so the frontend can see the data)
    public Long getId() { return id; }
    public String getSeatRow() { return seatRow; }
    public int getSeatNumber() { return seatNumber; }
    public boolean isOccupied() { return isOccupied; }
    public boolean isHandicap() { return isHandicap; }
}
