package ru.itmo.backend_refactoring.Models

import com.fasterxml.jackson.annotation.JsonIgnore
import ru.itmo.backend_refactoring.DAO.Word

class WordModel(
    var word: String? = null,
    var root: String? = null,
    var prefix: String? = null,
    var endings: MutableList<String> = mutableListOf<String>()
){
    @JsonIgnore
    fun getAmountOfParts(): Int {
        var amount = 0
        if (prefix != null)
            amount++
        if (root != null)
            amount++
        amount += endings.size
        return amount
    }
    @JsonIgnore
    fun checkCorrectParts(): Boolean {
        if (word == getWordFromParts())
            return true
        return false
    }
    @JsonIgnore
    fun getWordFromParts(): String {
        var fullWord: String = ""
        if (prefix != null)
            fullWord = fullWord + prefix
        return fullWord + root + endings.joinToString("")
    }

    constructor(w: Word) : this() {
        this.apply {
            root = w.root
            prefix = w.prefix?.text
            for (end in w.suffixes)
                endings.add(end.text)
            w.ending?.let { endings.add(it.text) }
            word = getWordFromParts()
        }
    }
}