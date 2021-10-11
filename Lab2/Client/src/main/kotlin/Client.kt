import Models.WordModel
import com.google.gson.Gson

fun main() {
    var loop = true
    while (loop) {
        val wordModel = WordModel()
        wordModel.addWord()
        var words = RequestService.getRootWords(wordModel.word!!)
        if (words.isEmpty()){
            print("Неизвестное слово. Хотите добавить его в словарь (да/нет)?" )
            val answer = readLine()!!
            if (answer.lowercase() == "да") {
                wordModel.getPrefixFromConsole()
                wordModel.getRootFromConsole()
                wordModel.getEndingsFromConsole()
                println(wordModel.getWordByParts())
                if (wordModel.checkCorrectParts())
                    RequestService.addWord(wordModel)
                else
                    println("Слово из частей не соответсвует изначальному слову")
            }
        }
        else{
            println("Известные однокорренные слова:")
            words = words.sortedWith(CompareWords)
            for (w in words)
                println(w.getWordByParts())
        }
    }
}