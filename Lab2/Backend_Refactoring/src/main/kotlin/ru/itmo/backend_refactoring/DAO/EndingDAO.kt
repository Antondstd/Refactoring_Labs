package ru.itmo.backend_refactoring.DAO

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class EndingDAO (
    @Id
    @Column(name = "ending",unique=true)
    val text: String
    ) {
        @OneToMany(mappedBy="ending")
        val word: MutableList<Word> = mutableListOf()
}