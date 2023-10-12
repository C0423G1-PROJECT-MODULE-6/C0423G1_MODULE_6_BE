package com.example.c4zone.repository.customer;

import com.example.c4zone.model.product.Capacity;
import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * Author: TinDT
     * Goal: save customers
     */
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO retro_care.customer(name_customer,gender_customer,birth_date_customer,address_customer,phone_number_customer,email_customer,status_customer) VALUES(:#{#customer.name_customer},:#{#customer.gender_customer},:#{#customer.birth_date_customer},:#{#customer.address_customer},:#{#customer.phone_number_customer},:#{#customer.email_customer},:#{#status_customer)", nativeQuery = true)
    List<Capacity> saveCustomer(Customer customer);

    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) =:age and gender_customer = :gender ", nativeQuery = true)
    Page<Customer> findAllCustomerByAge(Pageable pageable, @Param("name") String valueSearchName,@Param("age") String valueAge, @Param("gender") Boolean valueSearchGender);

    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) >= 0 and gender_customer = :gender ", nativeQuery = true)
    Page<Customer> findAllCustomerByGender(Pageable pageable, @Param("name") String valueSearchName, @Param("gender") Boolean valueSearchGender);
    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) >= 0 ", nativeQuery = true)
    Page<Customer> findAllCustomerByName(Pageable pageable, @Param("name") String valueSearchName);
    @Query(value = "select id_customer as idCustomerOrder, name_customer as customerNameOrder" +
            ",phone_number_customer as customerPhoneorder " +
            ",address_customer as addressCustomerOrder,birth_date_customer as birthDayCustomerOrder" +
            ",email_customer as emailCustomerOrder " +
            "from customer " +
            "where id_customer = :id",nativeQuery = true)
    ICustomerDtoOrder findCustomerByIdOrder(Long id);
}
