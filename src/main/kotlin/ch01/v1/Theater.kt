package ch01.v1

class Theater(
    private val ticketSeller: TicketSeller
) {
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