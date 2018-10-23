package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/customer")
//@GetMapping("/customer")
@Controller
public class CustomerController {
@Autowired CustomerService customerService;

//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public String listCustomer(@RequestParam("page") int page, Model model) {


		Page<Customer> customers = customerService.findAll(gotoPage(page));
//		Iterable<Customer> customers = customerService.findAll();

		List<Customer> list = new ArrayList<>();
		customers.forEach(cust->{list.add(cust);
			System.out.println("CUSTOMER:"+ cust.getId());
		});
		System.out.println("size:"+list.size());
		model.addAttribute("customers", list);
		System.out.println("LISTA");
		return "customer/list";
	}


	@GetMapping("showFormForAdd")
	public String showFormForAdd(Model theModel){
		Customer customer= new Customer();
		theModel.addAttribute("customer", customer);
		return "customer/customer-form";
	}

	@PostMapping("saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, Model model){
		customerService.save(customer);
		return "redirect:/customer/list?page=0";
	}

	@GetMapping("deleteCustomer")
	public String deleteCustomer(@RequestParam("id") Long id, Model model){
		Optional<Customer> customer = customerService.findById(id);
		customerService.delete(customer.get());
		return "redirect:/customer/list?page=0";
	}


	@GetMapping("displayFormForEdit")
	public String displayFormForMapping(@RequestParam("id")Long id, Model model){
		Optional<Customer> customer = customerService.findById(id);
		model.addAttribute("customer", customer.get());
		return "customer/customer-form";
	}





	private PageRequest gotoPage(int page)

	{

		PageRequest request = PageRequest.of(page,150, Sort.Direction.ASC,"lastName");
		return request;

	}


}
