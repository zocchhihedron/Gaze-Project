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

val Greeting: State = state(Parent) {
    onEntry {
        furhat.say("This is working!")
        // Apply the gaze pattern from the JSON file
        //GazeGesture.applyGazePattern("src/main/resources/gazedata.json", furhat)

    }
    }

