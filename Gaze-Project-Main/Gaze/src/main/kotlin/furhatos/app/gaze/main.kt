package furhatos.app.gaze

import furhatos.app.gaze.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class GazeSkill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
