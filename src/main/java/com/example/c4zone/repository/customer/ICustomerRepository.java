package com.example.c4zone.repository.customer;

import com.example.c4zone.dto.customer.IShoppingHistory;
import com.example.c4zone.dto.order.ICustomerDtoOrder;
import com.example.c4zone.model.customer.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    /**
     * Author: TinDT
     * Goal: save customers
     */


    @Transactional
    @Modifying
    @Query(value = "INSERT INTO c4_zone.customer(name_customer, gender_customer, birth_date_customer, address_customer, phone_number_customer, email_customer, status_customer) VALUES(:#{#customer.nameCustomer}, :#{#customer.genderCustomer}, :#{#customer.dateOfBirthCustomer}, :#{#customer.addressCustomer}, :#{#customer.phoneNumberCustomer}, :#{#customer.emailCustomer}, :#{#customer.statusCustomer});", nativeQuery = true)
    void saveCustomer(Customer customer);

    /**
     * Author: TinDT
     * Goal: save customers
     */
    @Query(value = "select * from  c4_zone.customer where phone_number_customer = :phone_number_customer  ", nativeQuery = true)
    Customer findCustomerByPhone(@Param("phone_number_customer") String phoneNumberCustomer);

    /**
     * Author: TinDT
     * Goal: save customers
     */

    @Query(value = "select * from  c4_zone.customer where email_customer = :email_customer  ", nativeQuery = true)
    Customer findCustomerByEmail(@Param("email_customer") String email);


    /**
     * Author: NguyenNH
     * Goal: show list customer
     */

    @Query(value = "select c.*, count(o.id_customer ) as total_purchases " +
            " from customer c " +
            " left join order_bill o on c.id_customer = o.id_customer " +
            " where c.name_customer like :name " +
            " and TIMESTAMPDIFF(YEAR, c.birth_date_customer, CURDATE()) =:age " +
            " group by c.id_customer", nativeQuery = true)
    Page<Customer> findAllCustomerByAge(Pageable pageable, @Param("name") String valueSearchName, @Param("age") String valueSearchAge);

    @Query(value = "select c.*, count(o.id_customer ) as total_purchases " +
            " from customer c " +
            " left join order_bill o on c.id_customer = o.id_customer " +
            " where c.name_customer like :name " +
            " and TIMESTAMPDIFF(YEAR, c.birth_date_customer, CURDATE()) >= 0 " +
            " group by c.id_customer ", nativeQuery = true)
    Page<Customer> findAllCustomerByName(Pageable pageable, @Param("name") String valueSearchName);

    @Query(value = "select c.*, count(o.id_customer ) as total_purchases " +
            " from customer c " +
            " left join order_bill o on c.id_customer = o.id_customer " +
            " where c.name_customer like :name " +
            " and TIMESTAMPDIFF(YEAR, c.birth_date_customer, CURDATE()) =:age " +
            " and c.gender_customer = :gender " +
            " group by c.id_customer", nativeQuery = true)
    Page<Customer> findAllCustomerByAgeAndGender(Pageable pageable, @Param("name") String valueSearchName, @Param("age") String valueAge, @Param("gender") Boolean valueSearchGender);

    @Query(value = " select c.*, count(o.id_customer ) as total_purchases  " +
            " from customer c " +
            " left join order_bill o on c.id_customer = o.id_customer " +
            " where c.name_customer like :name " +
            " and TIMESTAMPDIFF(YEAR, c.birth_date_customer, CURDATE()) >= 0 " +
            " and c.gender_customer = :gender " +
            " group by c.id_customer ", nativeQuery = true)
    Page<Customer> findAllCustomerByGender(Pageable pageable, @Param("name") String valueSearchName, @Param("gender") Boolean valueSearchGender);

    /**
     * method findByCustomer
     * Create ThoiND
     * Date 12-10-2023
     * param Long id
     * return HttpStatus
     */
    @Query(value = "select id_customer as idCustomerOrder, name_customer as customerNameOrder" +
            ",phone_number_customer as customerPhoneorder " +
            ",address_customer as addressCustomerOrder,birth_date_customer as birthDayCustomerOrder" +
            ",email_customer as emailCustomerOrder " +
            "from customer " +
            "where id_customer = :id", nativeQuery = true)
    ICustomerDtoOrder findCustomerByIdOrder(Long id);


    @Query(value = "select * from customer where id_customer = :id ", nativeQuery = true)
    Optional<Customer> findCustomerById(@Param("id") Long id);

    /**
     * Author: NguyenNH
     * Goal: show list shopping history
     */
    @Query(value = "select  ob.date_of_order as dateOfOrder, p.name_product as nameProduct, od.price_order as priceOrder" +
            " from customer c " +
            " join order_bill ob on c.id_customer = ob.id_customer " +
            " join order_detail od on ob.id_order_bill = od.id_order " +
            " join product p on od.id_product = p.id_product" +
            " where p.name_product like :name " +
            " and c.id_customer = :id " +
            " order by ob.date_of_order desc ", nativeQuery = true)
    Page<IShoppingHistory> findShoppingHistory(Pageable pageable, @Param("name") String valueSearchName, @Param("id") Long id);


}
