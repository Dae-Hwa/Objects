package ch01.v2

class Audience(
    private val bag: Bag
) {
    /**
     * 초대권을 가졌을 경우 0 반환
     * 아닐 경우 가방에서 제외한 티켓 요금만큼 반환
     */
    fun buy(ticket: Ticket): Long {
        if (bag.hasInvitation()) {
            bag.setTicket(ticket)
            return 0L
        } else {
            bag.setTicket(ticket)
            bag.minusAmount(ticket.fee)
            return ticket.fee
        }
    }
}