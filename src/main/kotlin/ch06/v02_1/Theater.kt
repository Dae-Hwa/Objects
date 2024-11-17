package ch06.v02_1

import ch01.v1.Audience

class Theater(
    private val ticketSeller: TicketSeller
) {
    /*
     * 묻지말고 시켜라 스타일을 따르는 퍼블릭 인터페이스를 만들어 줘야함
     */
    fun enter(audience: Audience) {
        ticketSeller.setTicket(audience)
    }
}