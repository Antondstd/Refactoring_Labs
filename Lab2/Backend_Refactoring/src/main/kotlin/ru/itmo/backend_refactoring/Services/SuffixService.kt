package ru.itmo.backend_refactoring.Services

import org.springframework.stereotype.Service
import ru.itmo.backend_refactoring.Repository.SuffixRepository

@Service
class SuffixService(suffixRepository: SuffixRepository):SuffixRepository by suffixRepository {
}