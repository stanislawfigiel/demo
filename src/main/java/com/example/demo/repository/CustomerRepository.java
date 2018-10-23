package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

//public interface CustomerRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {
public interface CustomerRepository extends CrudRepository<Customer, Long>, JpaSpecificationExecutor<Customer>,
		PagingAndSortingRepository<Customer,Long> {

		//interface CustomerRepository extends PaginationAndSortingRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

//	Page<Order> findAllByCreatedBy_IdOrderByNumberDesc(Long userId, Pageable pageable);
//	Optional<Order> findByNumber(String number);
//	List<Order> findAllByStatus(OrderStatus status, Sort sort);
	Page<Customer> findAll(Pageable pageable);
//	Page<Customer> findAllOrderByLastNameAsc(Pageable pageable);

}
