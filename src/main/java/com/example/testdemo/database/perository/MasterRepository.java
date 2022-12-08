package com.example.testdemo.database.perository;

import com.example.testdemo.database.entities.Master;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MasterRepository extends CommonRepository<Master> {

    void deleteByFirstNameAndAndLastName(String firstName, String lastName);

    @Query("select (count(m) > 0) from Master m where m.firstName = ?1 and m.lastName = ?2")
    boolean existsByFirstNameAndLastName(String firstName, String lastName);


    @Query("select m from Master m where m.firstName = ?1 and m.lastName = ?2 and m.phoneNumber = ?3")
    Optional<Master> findMasterByFirstNameAndAndLastNameAndAndPhoneNumber(String firstName, String lastName, String phoneNumber);
}
