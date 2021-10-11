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

    override fun equals(other: Any?): Boolean {
        return this.text == (other as Prefix).text
    }

    override fun hashCode(): Int {
        return text.hashCode()
    }

    override fun toString(): String {
        return text
    }
}