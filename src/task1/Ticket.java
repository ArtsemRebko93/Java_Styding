package task1;

import java.io.IOException;

public class Ticket {
    //!ticketNumber.getClass().equals("String") ?
    private String ticketNumber;

    public Ticket(String ticketNumber) throws IOException {
        ticketNumber = ticketNumber.trim();
        if (ticketNumber.toCharArray().length % 2 != 0 || ticketNumber.isEmpty()) {
            throw new IOException("Illegal argument");
        }
        this.ticketNumber = ticketNumber;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
}
