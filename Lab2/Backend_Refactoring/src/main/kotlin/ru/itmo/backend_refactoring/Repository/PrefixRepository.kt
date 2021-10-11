package ru.itmo.backend_refactoring.Repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.itmo.backend_refactoring.DAO.Prefix

interface PrefixRepository: JpaRepository<Prefix, String> {
}