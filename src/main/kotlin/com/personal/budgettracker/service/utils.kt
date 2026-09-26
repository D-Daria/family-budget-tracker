package com.personal.budgettracker.service

import com.personal.budgettracker.controller.NotFoundException
import com.personal.budgettracker.dto.toResponse
import com.personal.budgettracker.repository.AccountRepository
import org.springframework.data.repository.findByIdOrNull

fun getAccountById(accountRepository: AccountRepository, id: Long) =
    accountRepository.findByIdOrNull(id) ?: throw NotFoundException("Account with id $id not found")
