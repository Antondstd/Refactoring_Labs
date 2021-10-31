package ru.itmo.backend_refactoring.DAO

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany


@Entity
data class Root(
    @Id
    @Column(name = "root",unique=true)
    val text: String
) {
    @OneToMany(mappedBy = "root")
    val word: MutableList<Word> = mutableListOf()
}