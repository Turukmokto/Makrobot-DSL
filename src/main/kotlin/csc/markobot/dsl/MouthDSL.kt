package csc.markobot.dsl

import csc.markobot.api.Mouth

@MakroBotDsl
class MouthDSL {
    private val speakerDSL: SpeakerDSL = SpeakerDSL()

    fun speaker(function: SpeakerDSL.() -> Unit) {
        speakerDSL.function()
    }

    fun toMouth(): Mouth = Mouth(speakerDSL.toSpeaker())
}