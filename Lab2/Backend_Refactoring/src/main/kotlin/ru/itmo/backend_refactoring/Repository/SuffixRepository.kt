package ru.itmo.backend_refactoring.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.backend_refactoring.DAO.Suffix

@Repository
interface SuffixRepository: JpaRepository<Suffix, String> {
}