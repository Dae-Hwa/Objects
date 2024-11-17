package ch06.v02_3

import ch01.v1.Ticket

class Audience(
    private val bag: Bag
) {
    /**
     * TicketSeller가 원하는 것은 Audience가 Ticket을 가지도록 하는 것
     */
    fun setTicket(ticket: Ticket): Long {
        return bag.setTicket(ticket)
    }
}