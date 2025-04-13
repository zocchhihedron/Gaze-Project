//Import of a JSON file with an array of gaze sample dictionaries, parsing and creation of a Kotlin list with
//gaze samples of their own data class

package furhatos.app.gaze.dataImport
import com.google.gson.Gson //Parsing a JSON file
import com.google.gson.reflect.TypeToken  //Specify deserialization into an array
import java.io.InputStreamReader

data class GazeSample(val gaze_duration:Double, val gaze_left_eye:Double, val gaze_right_eye:Double)

fun deserialize(): List<GazeSample> {
    //Accessing the JSON file from the resources folder
    val inputStream = GazeSample::class.java.getResourceAsStream("/datafile_name.json")
        ?: throw IllegalArgumentException("Resource not found: datafile_name.json")

    // Read the stream as a text using InputStreamReader
    val reader = InputStreamReader(inputStream)

    //Deserializes into an array of GazeSample objects
    val gson = Gson()
    val type = object : TypeToken<Array<GazeSample>>() {}.type
    return gson.fromJson(reader, type)
}

val gazeSamples = deserialize()

//Adapt gaze data to furhat's API