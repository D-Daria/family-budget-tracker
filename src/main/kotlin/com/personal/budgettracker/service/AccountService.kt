package com.personal.budgettracker.service

import com.personal.budgettracker.dto.AccountRequest
import com.personal.budgettracker.dto.AccountResponse
import com.personal.budgettracker.dto.TransactionResponse
import com.personal.budgettracker.dto.toResponse
import com.personal.budgettracker.entity.AccountEntity
import com.personal.budgettracker.repository.AccountRepository
import com.personal.budgettracker.repository.TransactionRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

interface AccountService {

    fun createAccount(accountReq: AccountRequest): AccountResponse

    fun getAccountById(id: Long): AccountResponse

    fun getAllTransactionsFromAccount(id: Long): List<TransactionResponse>
}

@Service
@Transactional
class AccountServiceImpl(
    private val accountRepository: AccountRepository,
    private val transactionRepository: TransactionRepository
) : AccountService {

    override fun createAccount(accountReq: AccountRequest): AccountResponse =
        accountRepository.save(
            AccountEntity(
                name = accountReq.name,
                currency = accountReq.currency
            )
        ).toResponse()

    override fun getAccountById(id: Long) = getAccountById(accountRepository, id).toResponse()

    override fun getAllTransactionsFromAccount(id: Long) =
        getAccountById(accountRepository, id).toResponse().run {
            transactionRepository.findByAccountId(id).map { it.toResponse() }
        }
}