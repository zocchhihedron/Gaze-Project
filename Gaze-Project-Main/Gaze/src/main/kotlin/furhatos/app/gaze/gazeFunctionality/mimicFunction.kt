package furhatos.app.gaze.gazeFunctionality

//? Parametrize or have the list as the default argument. Pros / cons?
//? 'if'-cases for gaze (up, down, left, right, up_left, up_right, down_left,
// down_right, left_left, right_right, left_right, right_left) vs microexpressions

//Defines the furhat gesture that mimics the imported gaze pattern
fun mimicGaze(strength_left_eye: Double = l, strength_right_eye: Double = r, duration: Double = t) =
    defineGesture("mimicGaze", l, r, t) {
        //The gaze shift happens immediately, therefore frame gets value 0.0
        frame(0.0) {
        //Will need future modification for correct mimicking, example gestures to structure the function
            LOOK_LEFT to l
            LOOK_RIGHT to r
        }
        reset(t) //De-facto duration of the gaze sample
    }

//Defines a Kotlin function that runs a for-loop of the mimicking function for all gaze samples to enable
//continuous mimicking of a whole gaze pattern sample
fun mimicGazeSequence(gaze_samples : Array<gazeSamples> = arrayOf()) {
    for (i in gaze_samples.indices) {
        val time = gaze_samples[i].gaze_duration
        val left_eye = gaze_samples[i].gaze_left_eye
        val right_eye = gaze_samples[i].gaze_right_eye
        furhat.gesture(mimicGaze(left_eye, right_eye, time))
    }
}
