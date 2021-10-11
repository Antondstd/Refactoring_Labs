package ru.itmo.backend_refactoring.Services

import org.springframework.stereotype.Service
import ru.itmo.backend_refactoring.Repository.WordRepository

@Service
class WordService(wordRepository: WordRepository):WordRepository by wordRepository {

}