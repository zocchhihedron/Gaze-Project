package furhatos.app.gazeproject2025.gaze

import furhatos.flow.kotlin.Furhat

import furhatos.app.gazeproject2025.gaze.GazeSample
import furhatos.app.gazeproject2025.gaze.GazeDataCompiler
import furhatos.gestures.Gestures
import furhatos.gestures.defineGesture

/* */
//Continuous sequence of gaze data as furhat gestures
object GazeGesture {

    // Animate Furhat's gaze based on the human gaze pattern
    fun mimicGazePattern(furhat: Furhat, samples: List<GazeSample>) {

        for (sample in samples) {
            // Averaging out gaze point data from both eyes
            val x = (sample.gazeLeftEye[0] + sample.gazeRightEye[0]) / 2
            val y = (sample.gazeLeftEye[1] + sample.gazeRightEye[1]) / 2

            /*
            // Clamp values to Furhat's coordinate system (amplitude parameter)
            val clampedX = ((x - 0.5) * 2).coerceIn(0, 1.0)
            val clampedY = ((y - 0.5) * -2).coerceIn(0, 1.0)

            // Send gaze gesture to Furhat with duration
            val gazeGesture = defineGesture("Gadfgze") {
                x = clampedX.toFloat(),
                y = clampedY.toFloat(),
                duration = sample.time.toFloat() // Duration in seconds
            }

            // Send gaze gesture to Furhat with duration
            val Normal = defineGesture("Gaze") {
                frame(duration) {
                    Gestures.BrowRaise to 0.0
                    Gestures.Smile to 0.0
                }
                reset(0.5)
            }


            )

             */
        }
    }

    // Entry point to load data and apply to Furhat
    fun applyGazePattern(jsonPath: String, furhat: Furhat) {
        val samples = GazeDataCompiler.loadGazeSamples(jsonPath)
        mimicGazePattern(furhat, samples)
    }
}
