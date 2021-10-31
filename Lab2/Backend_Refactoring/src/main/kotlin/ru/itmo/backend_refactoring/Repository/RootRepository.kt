package ru.itmo.backend_refactoring.Repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.itmo.backend_refactoring.DAO.Prefix
import ru.itmo.backend_refactoring.DAO.Root

interface RootRepository: JpaRepository<Root, String> {
}