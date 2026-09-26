package com.personal.budgettracker.repository

import com.personal.budgettracker.entity.TransactionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository: JpaRepository<TransactionEntity, Long> {

    fun findByAccountId(accountId: Long): List<TransactionEntity>
}