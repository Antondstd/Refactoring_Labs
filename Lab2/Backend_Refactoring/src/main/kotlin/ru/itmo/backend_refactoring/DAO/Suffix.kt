package ru.itmo.backend_refactoring.DAO

import javax.persistence.*

@Entity
class Suffix(
    @Id
    @Column(name = "suffix",unique=true)
    val text: String
) {
    @ManyToMany
    var words: MutableSet<Word> = mutableSetOf()
}