package com.amapia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amapia.entity.Amap;
import com.amapia.entity.Member;

@Repository
public interface AmapRepository extends JpaRepository<Amap, Long>{
	boolean existsByLinkName(String linkName);
	Amap findByLinkName(String linkName);
	boolean existsByEmail(String email);
	Optional<Amap> findByEmail(String email);

	
	@EntityGraph(attributePaths = "members")
    @Query("SELECT a FROM Amap a WHERE a.linkName = :linkName")
    Amap findByLinkNameWithMembers(@Param("linkName") String linkName);


}
