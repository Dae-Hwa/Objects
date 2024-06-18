package ch01.v1

class Theater(
    private val ticketSeller: TicketSeller
) {
    /*
     * - 아래 메소드는 인간의 직관(상식)과 상충된다.
     * - 의존하고 있는 객체들에 변경이 일어난다면 이 메소드도 변경되어야 한다(변경의 이유가 여러개가 된다? 단일 책임원칙을 준수하지 못하는 것).
     */
    fun enter(audience: Audience) {
        if (audience.bag.hasInvitation()) {
            val ticket = ticketSeller.ticketOffice.getTicket()
            audience.bag.setTicket(ticket)
        } else {
            val ticket = ticketSeller.ticketOffice.getTicket()
            audience.bag.setTicket(ticket)
            ticketSeller.ticketOffice.plusAmount(ticket.fee)
            audience.bag.minusAmount(ticket.fee)
        }
    }
}