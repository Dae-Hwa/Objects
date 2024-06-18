package ch01.v3

class TicketSeller(
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        // 어디에 팔지만 판단한다. 금액을 올리고 내리는건 이제 매표소의 책임
        ticketOffice.sellTicketTo(audience)
    }
}