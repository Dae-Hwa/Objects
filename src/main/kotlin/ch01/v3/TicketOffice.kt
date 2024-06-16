package ch01.v3

class TicketOffice(
    private var amount: Long,
    private val tickets: MutableList<Ticket>
) {
    constructor(amount: Long, vararg tickets: Ticket) : this(amount, tickets.toMutableList())

    // 관람객에게 판매하는 인터페이싀 외의 모든 메소드와 필드는 private으로 변경했다.
    fun sellTicketTo(audience: Audience) {
        plusAmount(audience.buy(getTicket()))
    }

    private fun getTicket(): Ticket {
        return tickets.removeFirst()
    }

    private fun plusAmount(amount: Long) {
        this.amount += amount
    }
}