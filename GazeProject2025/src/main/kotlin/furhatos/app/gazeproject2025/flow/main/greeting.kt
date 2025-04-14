package furhatos.app.gazeproject2025.flow.main

import furhatos.app.gazeproject2025.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

//For gaze
import furhatos.app.gazeproject2025.gaze.mimicGaze
import furhatos.app.gazeproject2025.gaze.compileGaze

val Greeting: State = state(Parent) {
    onEntry {
        furhat.ask("Should I say Hello World?")
    }

    onResponse<Yes> {
        furhat.say("Hello World! ")
    }

    onResponse<No> {
        furhat.say("Ok.")
    }

}

