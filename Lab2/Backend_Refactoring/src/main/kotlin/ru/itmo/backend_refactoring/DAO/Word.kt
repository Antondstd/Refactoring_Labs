package ru.itmo.backend_refactoring.DAO

import javax.persistence.*

@Entity
class Word(
    @ManyToOne(cascade= arrayOf(CascadeType.MERGE,CascadeType.PERSIST))
    @JoinColumn(name = "prefix_id")
    var prefix: Prefix?,
    @ManyToOne(cascade= arrayOf(CascadeType.MERGE,CascadeType.PERSIST))
    @JoinColumn(name = "root_id")
    var root: Root,
    @ManyToMany(cascade= arrayOf(CascadeType.MERGE,CascadeType.PERSIST))
    @JoinTable(
        name = "suffixes_words",
        inverseJoinColumns = [JoinColumn(name = "suffix", referencedColumnName = "suffix")],
        joinColumns = [JoinColumn(name = "word_id", referencedColumnName = "id")])
    var suffixes: MutableList<Suffix> = mutableListOf(),
    @Column(name = "fullWord",unique=true)
    var fullWord:String,
    @ManyToOne(cascade= arrayOf(CascadeType.MERGE,CascadeType.PERSIST))
    @JoinColumn(name = "ending_id")
    var ending: EndingDAO?,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    var id: Long = 0
}