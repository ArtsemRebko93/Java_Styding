package task1;

public class Cashier {
    public boolean isTicketWin (Ticket ticket) {
        int counterLeft = 0;
        int counterRight = 0;
        for (int i = 0, j = ticket.getTicketNumber().toCharArray().length - 1; j > i; i++,j--) {
            counterLeft += Integer.parseInt(String.valueOf(ticket.getTicketNumber().toCharArray()[i]));
            counterRight += Integer.parseInt(String.valueOf(ticket.getTicketNumber().toCharArray()[j]));
        }
        return counterLeft == counterRight;
    }

}
