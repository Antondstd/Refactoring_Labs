package ru.itmo.backend_refactoring.Services

import org.springframework.stereotype.Service
import ru.itmo.backend_refactoring.Repository.EndingRepository

@Service
class EndingService(endingRepository: EndingRepository): EndingRepository by endingRepository {
}