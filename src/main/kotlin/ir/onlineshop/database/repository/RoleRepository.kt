package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleRepository:JpaRepository<Role,Long>