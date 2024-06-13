package ch01.v2

class TicketSeller(
    // 이제 ticketOffice는 외부에서 접근할 수 없다. 따라서 TicketSeller는 ticketOffice를 이용해 스스로 일을 처리해야 한다.
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        if (audience.bag.hasInvitation()) {
            val ticket = ticketOffice.getTicket()
            audience.bag.setTicket(ticket)
        } else {
            val ticket = ticketOffice.getTicket()
            audience.bag.setTicket(ticket)
            ticketOffice.plusAmount(ticket.fee)
            audience.bag.minusAmount(ticket.fee)
        }
    }
}