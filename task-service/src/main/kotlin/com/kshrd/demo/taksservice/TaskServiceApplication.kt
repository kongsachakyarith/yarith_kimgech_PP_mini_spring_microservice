package com.kshrd.demo.taksservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskServiceApplication {
}

fun main(args: Array<String>){
    runApplication<TaskServiceApplication>(*args)
}