package com.personal.budgettracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FamilyBudgetTrackerApplication

fun main(args: Array<String>) {
	runApplication<FamilyBudgetTrackerApplication>(*args)
}
