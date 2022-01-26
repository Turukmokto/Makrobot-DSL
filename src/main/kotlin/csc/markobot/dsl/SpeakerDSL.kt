package csc.markobot.dsl

import csc.markobot.api.Speaker

@MakroBotDsl
class SpeakerDSL {
    var power: Int = 0

    fun toSpeaker(): Speaker = Speaker(power)
}