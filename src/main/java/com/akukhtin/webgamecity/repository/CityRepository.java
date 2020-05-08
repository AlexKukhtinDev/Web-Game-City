package com.akukhtin.webgamecity.repository;

import com.akukhtin.webgamecity.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query(value = "SELECT COUNT(id)FROM City ", nativeQuery = true)
    Long countByElement();

    @Modifying(clearAutomatically = true)
    @Query("update City city set city.usageWord =true where city.id =:wordId")
    void setUsageWord(@Param("wordId") Long wordId);


    City findByCityName(String cityName);

    @Query(value = "SELECT cityName from City where cityName like 'letter%'", nativeQuery = true)
    String findByLetter(char letter);
}
