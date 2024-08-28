package ch04.v01

import java.time.LocalDateTime

class Screening(
    var movie: Movie,
    var sequence: Int,
    var whenScreened: LocalDateTime
) {
}