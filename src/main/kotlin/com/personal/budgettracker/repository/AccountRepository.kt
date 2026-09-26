package com.personal.budgettracker.repository

import com.personal.budgettracker.entity.AccountEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<AccountEntity, Long> {
}