package com.example.c4zone.repository.customer;

import com.example.c4zone.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;



public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) =:age and gender_customer = :gender ", nativeQuery = true)
    Page<Customer> findAllCustomerByAge(Pageable pageable, @Param("name") String valueSearchName,@Param("age") String valueAge, @Param("gender") Boolean valueSearchGender);

    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) >= 0 and gender_customer = :gender ", nativeQuery = true)
    Page<Customer> findAllCustomerByGender(Pageable pageable, @Param("name") String valueSearchName, @Param("gender") Boolean valueSearchGender);
    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) >= 0 ", nativeQuery = true)
    Page<Customer> findAllCustomerByName(Pageable pageable, @Param("name") String valueSearchName);
}
