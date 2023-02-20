package com.emociones.order;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class CustomerController {


    private final CustomerRepository repository;

    private final CustomerModelAssembler assembler;

    CustomerController(CustomerRepository repository, CustomerModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/customer")
    CollectionModel<EntityModel<Customer>> all() {

        List<EntityModel<Customer>> customer = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(customer, linkTo(methodOn(CustomerController.class).all()).withSelfRel());
    }
    @PostMapping("/customer")
    ResponseEntity<?> newCustomer(@RequestBody Customer newCustomer) {

        EntityModel<Customer> entityModel = assembler.toModel(repository.save(newCustomer));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @GetMapping("/customer/{customerID}")
    EntityModel<Customer> one(@PathVariable Long customerID) {

        Customer customer = repository.findById(customerID) //
                .orElseThrow(() -> new CustomerNotFoundException(customerID));

        return EntityModel.of(customer, //
                linkTo(methodOn(CustomerController.class).one(customerID)).withSelfRel(),
                linkTo(methodOn(CustomerController.class).all()).withRel("customer"));
    }

    @PutMapping("/customer/{customerID}")
    ResponseEntity<?> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long customerID) {

        Customer updatedCustomer = repository.findById(customerID) //
                .map(customer -> {
                    customer.setName(newCustomer.getName());
                    customer.setEmailAddress(newCustomer.getEmailAddress());
                    return repository.save(customer);
                }) //
                .orElseGet(() -> {
                    newCustomer.setCustomerID(customerID);
                    return repository.save(newCustomer);
                });

        EntityModel<Customer> entityModel = assembler.toModel(updatedCustomer);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/customer/{customerID}")
    ResponseEntity<?> deleteCustomer(@PathVariable Long customerID) {

        repository.deleteById(customerID);

        return ResponseEntity.noContent().build();
    }
}