package com.example.c4zone.repository.customer;

import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;

import java.util.Optional;


public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) =:age and gender_customer = :gender ", nativeQuery = true)
    Page<Customer> findAllCustomerByAge(Pageable pageable, @Param("name") String valueSearchName,@Param("age") String valueAge, @Param("gender") Boolean valueSearchGender);

    @Query(value = "select * from customer where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) >= 0 and gender_customer = :gender ", nativeQuery = true)
    Page<Customer> findAllCustomerByGender(Pageable pageable, @Param("name") String valueSearchName, @Param("gender") Boolean valueSearchGender);
    @Query(value = "select customer.*, count(sale_history.id_order_detail) as total_purchases " +
            "from customer " +
            "join order_bill on customer.id_customer = order_bill.id_customer " +
            "join order_detail on order_bill.id_order_bill = order_detail.id_order " +
            "join sale_history on  order_detail.id_order_detail = sale_history.id_order_detail " +
            "where name_customer like :name and TIMESTAMPDIFF(YEAR, birth_date_customer, CURDATE()) >= 0 group by customer.id_customer ", nativeQuery = true)
    Page<Customer> findAllCustomerByName(Pageable pageable, @Param("name") String valueSearchName);
    @Query(value = "select id_customer as idCustomerOrder, name_customer as customerNameOrder" +
            ",phone_number_customer as customerPhoneorder " +
            ",address_customer as addressCustomerOrder,birth_date_customer as birthDayCustomerOrder" +
            ",email_customer as emailCustomerOrder " +
            "from customer " +
            "where id_customer = :id",nativeQuery = true)
    ICustomerDtoOrder findCustomerByIdOrder(Long id);

    @Query(value = "select * from customer where id_customer = :id ", nativeQuery = true)
    Optional<Customer> findCustomerById(@Param("id") Long id);
}
