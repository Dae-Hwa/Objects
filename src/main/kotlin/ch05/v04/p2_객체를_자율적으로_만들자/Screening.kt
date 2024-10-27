package ch05.v04.p2_객체를_자율적으로_만들자

import java.time.LocalDateTime

class Screening(
    var movie: Movie,
    var sequence: Int,
    var whenScreened: LocalDateTime
) {
}