package com.personal.budgettracker.service

import com.personal.budgettracker.controller.InsufficientFundsException
import com.personal.budgettracker.dto.TransactionRequest
import com.personal.budgettracker.entity.AccountEntity
import com.personal.budgettracker.entity.TransactionEntity
import com.personal.budgettracker.repository.AccountRepository
import com.personal.budgettracker.repository.TransactionRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.Instant
import kotlin.require

interface TransactionService {
    fun createTransaction(accountId: Long, transactionReq: TransactionRequest)
}

@Service
class TransactionServiceImpl(
    private val accountRepository: AccountRepository,
    private val transactionRepository: TransactionRepository
): TransactionService {

    @Transactional
    override fun createTransaction(accountId: Long, transactionReq: TransactionRequest) {
        require(transactionReq.amount > BigDecimal.ZERO) {
            "Invalid amount for transaction"
        }

        val acc = getAccountById(accountRepository, accountId).also {
            it.balance += transactionReq.amount
        }

        if (acc.balance < BigDecimal.ZERO) {
            throw InsufficientFundsException("Account ${acc.id} doesn't have enough funds")
        }

        val transactionEntity = TransactionEntity(
            account = acc,
            amount = transactionReq.amount,
            category = "",
            description = "",
            timestamp = Instant.now()
        )

        transactionRepository.save(transactionEntity)
    }
}