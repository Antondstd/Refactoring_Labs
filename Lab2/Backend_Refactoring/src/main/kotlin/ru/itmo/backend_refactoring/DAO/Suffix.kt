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

//    override fun equals(other: Any?): Boolean {
//        return this.text == (other as Ending).text
//    }
//
//    override fun hashCode(): Int {
//        return text.hashCode()
//    }
//
//    override fun toString(): String {
//        return text
//    }
}