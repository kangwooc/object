package chapter1;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }
    // encapsulation
    // ticketOffice의 구현이 아닌 인터페이스에 의존함
    public void sellTo(Audience audience) {
        this.ticketOffice.sellTicketTo(audience);
    }
}
