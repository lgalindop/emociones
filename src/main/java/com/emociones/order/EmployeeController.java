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
public class EmployeeController {


    private final EmployeeRepository repository;

    private final EmployeeModelAssembler assembler;

    EmployeeController(EmployeeRepository repository, EmployeeModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/employees")
    CollectionModel<EntityModel<Employee>> all() {

        List<EntityModel<Employee>> employees = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).all()).withSelfRel());
    }
    @PostMapping("/employees")
    ResponseEntity<?> newEmployee(@RequestBody Employee newEmployee) {

        EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @GetMapping("/employees/{employeeID}")
    EntityModel<Employee> one(@PathVariable Long employeeID) {

        Employee employee = repository.findById(employeeID) //
                .orElseThrow(() -> new EmployeeNotFoundException(employeeID));

        return EntityModel.of(employee, //
                linkTo(methodOn(EmployeeController.class).one(employeeID)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
    }

    @PutMapping("/employees/{employeeID}")
    ResponseEntity<?> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long employeeID) {

        Employee updatedEmployee = repository.findById(employeeID) //
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setEmployeeEmailAddress(newEmployee.getEmployeeEmailAddress());
                    return repository.save(employee);
                }) //
                .orElseGet(() -> {
                    newEmployee.setEmployeeID(employeeID);
                    return repository.save(newEmployee);
                });

        EntityModel<Employee> entityModel = assembler.toModel(updatedEmployee);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/employees/{employeeID}")
    ResponseEntity<?> deleteEmployee(@PathVariable Long employeeID) {

        repository.deleteById(employeeID);

        return ResponseEntity.noContent().build();
    }
}
