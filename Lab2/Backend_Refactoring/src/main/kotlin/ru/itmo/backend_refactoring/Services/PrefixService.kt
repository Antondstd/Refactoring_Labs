package ru.itmo.backend_refactoring.Services

import org.springframework.stereotype.Service
import ru.itmo.backend_refactoring.Repository.PrefixRepository

@Service
class PrefixService(prefixRepository: PrefixRepository): PrefixRepository by prefixRepository {
}