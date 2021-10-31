package ru.itmo.backend_refactoring.DAO

import javax.persistence.*

@Entity
data class Prefix(
    @Id
    @Column(name = "prefix",unique=true)
    val text: String
) {
    @OneToMany(mappedBy="prefix")
    val word: MutableList<Word> = mutableListOf()
}