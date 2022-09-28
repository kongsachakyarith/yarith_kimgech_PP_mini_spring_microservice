package org.kshrd.cloud.service

import org.kshrd.cloud.model.entity.Task
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.*

interface TaskRepository : ReactiveCrudRepository<Task, UUID> {

    @Query("select * from tasks t where t.group_id = :groupId")
    fun findByGroupId(TaskId: UUID): Mono<Task>
}