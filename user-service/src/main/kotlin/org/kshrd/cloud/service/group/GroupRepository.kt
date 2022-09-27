package org.kshrd.cloud.service.group

import org.springframework.data.repository.reactive.ReactiveCrudRepository
import javax.swing.GroupLayout.Group

interface GroupRepository : ReactiveCrudRepository<Group, Long>{
}