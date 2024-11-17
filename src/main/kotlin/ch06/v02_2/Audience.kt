package ch06.v02_2

import ch01.v1.Bag
import ch01.v1.Ticket

class Audience(
    private val bag: Bag
) {
    /**
     * TicketSeller가 원하는 것은 Audience가 Ticket을 가지도록 하는 것
     *
     * 이것도 디미터 법칙 위반
     */
    fun setTicket(ticket: Ticket): Long {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket)
            return 0L
        } else {
            bag.setTicket(ticket)
            return ticket.fee
        }
    }
}