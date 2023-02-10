package com.emociones.order;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.mediatype.problem.Problem;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
class OrderController {

    private final OrderRepository orderRepository;
    private final OrderModelAssembler assembler;

    OrderController(OrderRepository orderRepository, OrderModelAssembler assembler) {

        this.orderRepository = orderRepository;
        this.assembler = assembler;
    }

    @GetMapping("/orders")
    CollectionModel<EntityModel<Order>> all() {

        List<EntityModel<Order>> orders = orderRepository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(orders, //
                linkTo(methodOn(OrderController.class).all()).withSelfRel());
    }

    @GetMapping("/orders/{orderID}")
    EntityModel<Order> one(@PathVariable Long orderID) {

        Order order = orderRepository.findById(orderID) //
                .orElseThrow(() -> new OrderNotFoundException(orderID));

        return assembler.toModel(order);
    }

    @PostMapping("/orders")
    ResponseEntity<EntityModel<Order>> newOrder(@RequestBody Order order) {

        order.setOrderStatus(OrderStatus.IN_PROGRESS);
        Order newOrder = orderRepository.save(order);

        return ResponseEntity //
                .created(linkTo(methodOn(OrderController.class).one(newOrder.getOrderID())).toUri()) //
                .body(assembler.toModel(newOrder));
    }
    @DeleteMapping("/orders/{orderID}/cancel")
    ResponseEntity<?> cancel(@PathVariable Long orderID) {

        Order order = orderRepository.findById(orderID) //
                .orElseThrow(() -> new OrderNotFoundException(orderID));

        if (order.getOrderStatus() == OrderStatus.IN_PROGRESS) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            return ResponseEntity.ok(assembler.toModel(orderRepository.save(order)));
        }

        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed") //
                        .withDetail("You can't cancel an order that is in the " + order.getOrderStatus() + " status"));
    }

    @PutMapping("/orders/{orderID}/complete")
    ResponseEntity<?> complete(@PathVariable Long orderID) {

        Order order = orderRepository.findById(orderID) //
                .orElseThrow(() -> new OrderNotFoundException(orderID));

        if (order.getOrderStatus() == OrderStatus.IN_PROGRESS) {
            order.setOrderStatus(OrderStatus.COMPLETED);
            return ResponseEntity.ok(assembler.toModel(orderRepository.save(order)));
        }

        return ResponseEntity //
                .status(HttpStatus.METHOD_NOT_ALLOWED) //
                .header(HttpHeaders.CONTENT_TYPE, MediaTypes.HTTP_PROBLEM_DETAILS_JSON_VALUE) //
                .body(Problem.create() //
                        .withTitle("Method not allowed") //
                        .withDetail("You can't complete an order that is in the " + order.getOrderStatus() + " status"));
    }
}