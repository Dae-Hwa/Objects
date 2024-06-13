package ch01.v1

class Bag(
    private var amount: Long,
    private var invitation: Invitation? = null
) {
    private var ticket: Ticket? = null

    fun hasInvitation(): Boolean {
        return invitation != null
    }

    fun hasTicket(): Boolean {
        return ticket != null
    }

    fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    fun minusAmount(amount: Long) {
        this.amount -= amount
    }

    fun plusAmount(amount: Long) {
        this.amount += amount
    }
}
