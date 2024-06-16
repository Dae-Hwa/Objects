package ch01.v3

class Theater(
    private val ticketSeller: TicketSeller
) {
    fun enter(audience: Audience) {
        // 이제 Theater는 TicketOffice나 Audience에 대해 알지 못한다.
        // ticketSeller가 audience에게 티켓을 판매하는 일을 한다는 것만 안다.
        ticketSeller.sellTo(audience)
    }
}