package ru.itmo.backend_refactoring.Services

import org.springframework.stereotype.Service
import ru.itmo.backend_refactoring.Repository.RootRepository

@Service
class RootService(rootRepository: RootRepository): RootRepository by rootRepository {

}