package ru.itmo.backend_refactoring.Repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.itmo.backend_refactoring.DAO.EndingDAO

@Repository
interface EndingRepository: JpaRepository<EndingDAO, String> {
}