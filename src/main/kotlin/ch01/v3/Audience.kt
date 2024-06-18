package ch01.v3

class Audience(
    private val bag: Bag
) {
    /**
     * 초대권을 가졌을 경우 0 반환
     * 아닐 경우 가방에서 제외한 티켓 요금만큼 반환
     */
    fun buy(ticket: Ticket): Long {
        // bag도 캡슐화 됐다
        val usedTicketFee = bag.hold(ticket)
        return usedTicketFee
    }
}