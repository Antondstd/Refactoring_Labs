package ru.itmo.backend_refactoring.Controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.itmo.backend_refactoring.DAO.EndingDAO
import ru.itmo.backend_refactoring.DAO.Suffix
import ru.itmo.backend_refactoring.DAO.Prefix
import ru.itmo.backend_refactoring.DAO.Word
import ru.itmo.backend_refactoring.Models.WordModel
import ru.itmo.backend_refactoring.Services.EndingService
import ru.itmo.backend_refactoring.Services.SuffixService
import ru.itmo.backend_refactoring.Services.PrefixService
import ru.itmo.backend_refactoring.Services.WordService

@RestController
@RequestMapping("/words")
class WordController {

    @Autowired
    lateinit var wordService: WordService

    @Autowired
    lateinit var suffixService: SuffixService

    @Autowired
    lateinit var prefixService:PrefixService

    @Autowired
    lateinit var endingService: EndingService

    @PostMapping
    fun addWord(@RequestBody wordModel: WordModel) {
        println(wordModel)
        val suffixes: MutableList<Suffix> = mutableListOf()
        var ending: EndingDAO? = null
        var endingSize = wordModel.endings.size
        if (endingSize > 0) {
            try {
                 ending = endingService.findById(wordModel.endings.last()).get()
            } catch (e: Exception) {
                ending = EndingDAO(wordModel.endings.last())
            }
            wordModel.endings.removeLast()
            if (endingSize > 1){
                for (end in wordModel.endings)
                    try {
                        val sufBuf = suffixService.findById(end).get()
                        suffixes.add(sufBuf)
                    } catch (e: Exception) {
                        suffixes.add(Suffix(end))
                    }
            }

        }

        var prefix: Prefix? = null
        wordModel.prefix?.let {
            try {
                val prefixBuf = prefixService.findById(it).get()
                prefix = prefixBuf
            } catch (e: Exception) {
                prefix = Prefix(it)
            }
        }
        wordService.save(Word(prefix, wordModel.root!!,suffixes,wordModel.word!!,ending))
    }

    @GetMapping("/{fullWord}")
    fun getWordsWithSameRoot(@PathVariable(value = "fullWord")fullWord:String): List<WordModel> {
        val root = wordService.findWordByFullWord(fullWord)?.root
        if (root != null) {
            val words = wordService.findWordsByRootEquals(root)
            val wordModels = mutableListOf<WordModel>()
            if (words.size != 0)
                for (word in words)
                    wordModels.add(WordModel(word))
            return wordModels
        }
        return listOf()
    }
}