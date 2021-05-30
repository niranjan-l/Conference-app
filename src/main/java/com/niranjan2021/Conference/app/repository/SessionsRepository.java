package com.niranjan2021.Conference.app.repository;

import com.niranjan2021.Conference.app.models.Sessions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionsRepository extends JpaRepository<Sessions, Long> ,SessionsCustomRepository{

    List<Sessions> findBySessionNameContains(String name);
    Long countBySessionNameContains(String name);
    List<Sessions> getBySessionNameContains(String name);
    //List<Sessions> readyBySessionNameContains(String name);
    List<Sessions> queryBySessionNameContains(String name);

    List<Sessions> queryBySessionNameNotLike(String name);
    List<Sessions> queryBySessionNameLike(String name);

    List<Sessions> queryBySessionNameStartingWith(String name);
    List<Sessions> queryBySessionNameEndingWith(String name);

    List<Sessions>  findBySessionLength(Integer length);
    List<Sessions>  findBySessionLengthIs(Integer length);
    //List<Sessions>  findBySessionLengthEqual(Integer length);
    List<Sessions>  findBySessionLengthNot(Integer length);

    List<Sessions>  findBySessionLengthLessThan(Integer length);
    List<Sessions>  findBySessionLengthLessThanEqual(Integer length);
    List<Sessions>  findBySessionLengthGreaterThan(Integer length);
    List<Sessions>  findBySessionLengthGreaterThanEqual(Integer length);


    @Query(
            "select s from Sessions s where s.sessionName like %:name "
    )
    Page<Sessions> getSessionsWithName(@Param("name")String name, Pageable pageable);
}

