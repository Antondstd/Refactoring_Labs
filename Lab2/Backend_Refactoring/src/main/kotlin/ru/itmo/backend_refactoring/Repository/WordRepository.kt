package ru.itmo.backend_refactoring.Repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.itmo.backend_refactoring.DAO.Root
import ru.itmo.backend_refactoring.DAO.Word

interface WordRepository : JpaRepository<Word, Long> {
    fun findWordsByRootEquals(root:Root):List<Word>
    fun findWordByFullWord(fullWord:String):Word?
}