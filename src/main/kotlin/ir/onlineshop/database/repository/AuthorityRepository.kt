package ir.onlineshop.database.repository

import ir.onlineshop.database.model.Authority
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthorityRepository:JpaRepository<Authority,Long>