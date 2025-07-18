package furhatos.app.gazeproject2025.gaze

import furhatos.flow.kotlin.Furhat

import furhatos.app.gazeproject2025.gaze.GazeSample
import furhatos.app.gazeproject2025.gaze.GazeDataCompiler
import furhatos.gestures.Gestures
import furhatos.gestures.defineGesture
import kotlin.random.Random               // For Random.nextInt(), nextDouble()
import furhatos.ActionGaze

/* */
//Continuous sequence of gaze data as furhat gestures
object GazeGesture {

    // Animate Furhat's gaze based on the human gaze pattern
    fun mimicGazePattern(furhat: Furhat, samples: List<GazeSample>) {

        // Natural gaze location within more realistic bounds
        val x = Random.nextDouble(-0.6, 0.6)  // Smaller range for left-right movements
        val y = Random.nextDouble(-0.2, 0.2)  // Smaller range for up-down movements
        val z = Random.nextDouble(1.2, 1.8)   // Gaze distance between 1.2m and 1.8m

        // Random slack value for more dynamic head behavior
        val slack = Random.nextInt(5, 15)

        // Random speed for head movement
        val speed = when (Random.nextInt(4)) {
            0 -> ActionGaze.Speed.SLOW
            1 -> ActionGaze.Speed.MEDIUM
            2 -> ActionGaze.Speed.FAST
            else -> ActionGaze.Speed.XSLOW
        }

        // Random gaze mode for more variety
        val gazeMode = when (Random.nextInt(3)) {
            //0 -> ActionGaze.Mode.DEADZONE
            1 -> ActionGaze.Mode.EYE                  //If you only want the eyes to move, just use this parameter
            else -> ActionGaze.Mode.DEFAULT
        }

        // Perform the random gaze action
        val location = Location(x, y, z)
        furhat.attend(location, gazeMode = gazeMode, speed = speed, slack = slack)

        /*for (sample in samples) {
            // Averaging out gaze point data from both eyes
            val x = (sample.gazeLeftEye[0] + sample.gazeRightEye[0]) / 2
            val y = (sample.gazeLeftEye[1] + sample.gazeRightEye[1]) / 2


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
