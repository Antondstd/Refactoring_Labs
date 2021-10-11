package Models

//@Serializable
class WordModel{
    fun addWord() {
        word = showMessageAndRead("Введите слово:")
    }

    var word: String? = null
    var root: String? = null
    var prefix: String? = null
    var endings = mutableListOf<String>()

    fun getRootFromConsole() {
        root = showMessageAndRead("Корень:")
    }

    fun getPrefixFromConsole() {
        prefix = showMessageAndRead("Приставка:")
    }

    fun getEndingsFromConsole() {
        var noEndingWord = true
        var ending: String?
        while (noEndingWord) {
            ending = showMessageAndRead("Суффикс или окончание:")
            if (ending != null)
                if (ending.isEmpty() || ending.isBlank())
                    noEndingWord = false
                else {
                    endings.add(ending)
                }
            else
                noEndingWord = false
        }
    }

    fun getAmountOfParts():Int{
        var amount = 0
        if (prefix != null)
            amount++
        if (root != null)
            amount++
        amount+= endings.size
        return amount
    }

    fun checkCorrectParts(): Boolean {
        if (word == getWordFromParts())
            return true
        return false
    }

    fun getWordFromParts(): String {
        var fullWord: String = ""
        if (prefix != null)
            fullWord = fullWord + prefix
        return fullWord + root + endings.joinToString("")
    }

    fun getWordByParts(): String {
        val endingString = endings.joinToString("-")
        if (prefix != null && !prefix!!.isEmpty())
            return StringBuilder("$prefix-$root-$endingString").toString()
        else
            return StringBuilder("$root-$endingString").toString()
    }

    companion object {
        fun showMessageAndRead(message: String): String? {
            println(message)
            val text = Regex("[^А-Яа-я-]").replace(readLine()!!, "")
            if (text.isEmpty() || text.isBlank())
                return null
            else
                return text.lowercase()
        }
    }
}