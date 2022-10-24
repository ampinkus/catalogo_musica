package com.musica.catalogo.repository;

import com.musica.catalogo.model.Vinilo;
import org.springframework.data.jpa.repository.JpaRepository;


/*
* JpaRepository expose common database methods like find by Id, find all, delete, add.....
* Spring @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
* Spring @Repository Annotation:
* Spring Repository annotation is a specialization of @Component annotation, so Spring Repository classes are autodetected by spring
* framework through classpath scanning. Spring Repository is very close to DAO pattern where DAO classes are responsible for providing CRUD operations
* on database tables. However, if you are using Spring Data for managing database operations, then you should use Spring Data Repository interface.
* */

public interface ViniloRepository extends JpaRepository <Vinilo, Long>{
}
