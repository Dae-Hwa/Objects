package ch06.v02_2

import ch01.v1.TicketOffice


class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    fun setTicket(audience: Audience) {
        ticketOffice.plusAmount(
            audience.setTicket(ticketOffice.getTicket())
        )
    }
}