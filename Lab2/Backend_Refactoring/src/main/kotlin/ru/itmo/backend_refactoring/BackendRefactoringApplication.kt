package ru.itmo.backend_refactoring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class BackendRefactoringApplication

fun main(args: Array<String>) {
    runApplication<BackendRefactoringApplication>(*args)
}
