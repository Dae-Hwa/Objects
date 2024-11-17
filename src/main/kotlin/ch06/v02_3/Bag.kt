package ch06.v02_3

import ch01.v1.Invitation
import ch01.v1.Ticket

class Bag(
    private var amount: Long,
    private var invitation: Invitation? = null
) {
    private var ticket: Ticket? = null

    fun setTicket(ticket: Ticket): Long {
        if (hasInvitation()) {
            this.ticket = ticket
            return 0L
        } else {
            this.ticket = ticket
            minusAmount(ticket.fee)
            return ticket.fee
        }
    }

    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}