package ch06.v02_1

import ch01.v1.Audience
import ch01.v1.TicketOffice


class TicketSeller(
    val ticketOffice: TicketOffice
) {
    /*
     * 묻지말고 시켜라 스타일을 따르는 퍼블릭 인터페이스를 만들어 줘야함
     *
     * Theater가 TicketSeller에게 시키고 싶은 일은 Audience가 Ticket을 가지도록 하는 것
     *
     * -> Theater의 enter 메소드 로직을 이 안으로 옮겨준다.
     */
    fun setTicket(audience: Audience) {
        if (audience.bag.hasInvitation()) {
            val ticket = ticketOffice.getTicket()
            audience.bag.setTicket(ticket)
        } else {
            val ticket = ticketOffice.getTicket()
            audience.bag.setTicket(ticket)
            ticketOffice.plusAmount(ticket.fee)
            audience.bag.minusAmount(ticket.fee)
        }
    }
}