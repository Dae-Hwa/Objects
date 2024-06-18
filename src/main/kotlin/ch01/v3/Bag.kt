package ch01.v3

class Bag(
    private var amount: Long,
    private val invitation: Invitation? = null
) {
    private var ticket: Ticket? = null

    // 인터페이스인 hold를 제외한 모든 메소드와 필드는 private으로 변경했다.
    fun hold(ticket: Ticket): Long {
        if (hasInvitation()) {
            setTicket(ticket)
            return 0L
        } else {
            setTicket(ticket)
            minusAmount(ticket.fee)
            return ticket.fee
        }
    }

    private fun hasInvitation(): Boolean {
        return invitation != null
    }

    private fun setTicket(ticket: Ticket) {
        this.ticket = ticket
    }

    private fun minusAmount(amount: Long) {
        this.amount -= amount
    }
}
