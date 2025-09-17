package furhatos.app.gazeproject2025.flow.main

import furhatos.app.gazeproject2025.flow.Parent
import furhatos.flow.kotlin.State
import furhatos.flow.kotlin.furhat
import furhatos.flow.kotlin.onResponse
import furhatos.flow.kotlin.state
import furhatos.nlu.common.No
import furhatos.nlu.common.Yes

//For gaze
import furhatos.app.gazeproject2025.gaze.GazeSample
import furhatos.app.gazeproject2025.gaze.GazeDataCompiler
import furhatos.gestures.*
import furhatos.gestures.ARKitParams



val CustomExpression = defineGesture("Custom") {
    frame(0.0, 5.0){
        BasicParams.LOOK_LEFT
    }
    reset(10.04)
}

val Greeting: State = state(Parent) {
    onEntry {
        furhat.gesture(CustomExpression)
        furhat.say("Hello!")
        // Apply the gaze pattern from the JSON file
        //furhat.gesture(Gestures.Gaze)
        furhat.gesture(CustomExpression)

    }
    }

