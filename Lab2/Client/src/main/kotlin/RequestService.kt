import Models.WordModel
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.RequestEntity
import org.springframework.http.converter.json.GsonHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.net.URI
//import kotlinx.serialization.json.JSON


class RequestService {
    companion object{
        const val serverUrl = "http://localhost:8080"
        fun getRootWords(word:String):List<WordModel>{
//            val endpoint = URI.create(serverUrl + "/words/"+word)
//            val request = RequestEntity<Any>(HttpMethod.GET, endpoint)
            val rest = RestTemplate().apply { messageConverters.add(GsonHttpMessageConverter())}
            val answer = rest.getForObject(serverUrl + "/words/"+word,Array<WordModel>::class.java)
            return answer.asList()
//            JSON.
//            return ObjectMapper().readValue(answer,Array<WordModel>::class.java).toList()
//            Gson().fromJson<List<WordModel>>(answer,object : TypeToken<List<WordModel>>() {}.type)
//            return listOf()
        }
        fun addWord(wordModel: WordModel):Boolean{
            val restTemplate:RestTemplate = RestTemplate().apply { messageConverters.add(
                MappingJackson2HttpMessageConverter()
            )}
            return (restTemplate.postForEntity(serverUrl + "/words",wordModel, WordModel::class.java).statusCode == HttpStatus.OK)
        }

        inline fun <reified T: Any> typeRef(): ParameterizedTypeReference<T> = object: ParameterizedTypeReference<T>(){}
    }
}