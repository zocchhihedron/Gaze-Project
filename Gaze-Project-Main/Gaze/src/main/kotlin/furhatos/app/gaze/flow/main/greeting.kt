package furhatos.app.gaze.flow.main


import furhatos.app.gaze.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

//Furhat immediately mimics the gaze
val Greeting: State = state(Parent) {
    onEntry {
        mimicGazeSequence()
    }

    //onResponse<Yes> {
    //    furhat.say("Hello World! ")
    //}

    //onResponse<No> {
    //    furhat.say("Ok.")
    //}

}

