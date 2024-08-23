package chapter1;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }
    // encapsulation
    public void sellTo(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = this.ticketOffice.getTicket();
            audience.getBag().setTicket(ticket);
            return;
        }
        Ticket ticket = this.ticketOffice.getTicket();
        audience.getBag().minusAmount(ticket.getFee());
        this.ticketOffice.plusAmount(ticket.getFee());
        audience.getBag().setTicket(ticket);
    }
}
