package ch01.v2

class TicketSeller(
    // 이제 ticketOffice는 외부에서 접근할 수 없다. 따라서 TicketSeller는 ticketOffice를 이용해 스스로 일을 처리해야 한다.
    private val ticketOffice: TicketOffice
) {
    fun sellTo(audience: Audience) {
        /*
         * 구매에 사용된 ticketFee 만큼 ticketOffce의 amount를 증가시킨다.
         */
        // 이제 Audience는 자신의 가방안을 직접 확인한다.
        // 가방이 있다는 사실도 TicketSeller는 더 이상 알 필요가 없다.
        val ticketFee = audience.buy(ticketOffice.getTicket())
        ticketOffice.plusAmount(ticketFee)
    }
}