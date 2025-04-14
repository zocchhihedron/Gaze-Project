package furhatos.app.gazeproject2025.gaze

//Parsing the data file
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

//Reading the data file
import java.io.File

data class GazeSample(
    val time: Double,
    val gazeLeftEye: List<Double>,
    val gazeRightEye: List<Double>
)

object GazeDataCompiler {
    fun loadGazeSamples(jsonPath: String): List<GazeSample> {
        //Read the file into a string and create an instance for parsing
        val jsonString = File(jsonPath).readText()
        val gson = Gson()
        //Convert the string into a list of GazeSample objects
        val sampleType = object: TypeToken<List<GazeSample>>() {}.type
        return gson.fromJson(jsonString, sampleType)
    }
}





