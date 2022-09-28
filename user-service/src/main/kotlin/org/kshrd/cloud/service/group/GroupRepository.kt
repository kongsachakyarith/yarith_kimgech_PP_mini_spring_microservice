package org.kshrd.cloud.service.group

import org.kshrd.cloud.model.entity.Group
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.UUID

@Repository
interface GroupRepository : ReactiveCrudRepository<Group, UUID>{
//     @Query(value = "select * from groups where id =$1")
//     fun findByGroupId(id: UUID):Mono<Group>

//     fun findById(id: UUID): Mono<G>


}