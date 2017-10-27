package com.wyait.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wyait.boot.pojo.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {
	Cat findByName(String name);

	@Query("from Cat c where c.name=:name")
	Cat findCat(@Param("name") String name);

}
