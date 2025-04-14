package furhatos.app.gazeproject2025

import furhatos.app.gazeproject2025.flow.Init
import furhatos.flow.kotlin.Flow
import furhatos.skills.Skill

class Gazeproject2025Skill : Skill() {
    override fun start() {
        Flow().run(Init)
    }
}

fun main(args: Array<String>) {
    Skill.main(args)
}
