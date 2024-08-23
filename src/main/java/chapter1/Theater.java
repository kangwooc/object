package chapter1;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // 깔끔히 분리가 되네?
    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
