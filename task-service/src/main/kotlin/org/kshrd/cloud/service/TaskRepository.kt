package org.kshrd.cloud.service

import org.kshrd.cloud.handler.AppUser
import org.kshrd.cloud.model.entity.Task
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface TaskRepository : ReactiveCrudRepository<Task, UUID> {

    fun deleteTaskById(Id: UUID):Mono<Task>

    @Query("select * from tasks t where t.group_id = :groupId")
    fun findByGroupIdAndAssignedTo(group: UUID, assignedTo:UUID): Mono<Task>
}