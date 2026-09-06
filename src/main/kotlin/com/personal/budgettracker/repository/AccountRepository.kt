package com.personal.budgettracker.repository

import com.personal.budgettracker.entity.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository: JpaRepository<Account, Long> {
}