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
public class PartyController {


    private final PartyRepository repository;

    private final PartyModelAssembler assembler;

    PartyController(PartyRepository repository, PartyModelAssembler assembler) {

        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/party")
    CollectionModel<EntityModel<Party>> all() {

        List<EntityModel<Party>> party = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(party, linkTo(methodOn(PartyController.class).all()).withSelfRel());
    }
    @PostMapping("/party")
    ResponseEntity<?> newParty(@RequestBody Party newParty) {

        EntityModel<Party> entityModel = assembler.toModel(repository.save(newParty));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @GetMapping("/party/{partyID}")
    EntityModel<Party> one(@PathVariable Long partyID) {

        Party party = repository.findById(partyID) //
                .orElseThrow(() -> new PartyNotFoundException(partyID));

        return EntityModel.of(party, //
                linkTo(methodOn(PartyController.class).one(partyID)).withSelfRel(),
                linkTo(methodOn(PartyController.class).all()).withRel("party"));
    }

    @PutMapping("/party/{partyID}")
    ResponseEntity<?> replaceParty(@RequestBody Party newParty, @PathVariable Long partyID) {

        Party updatedParty = repository.findById(partyID) //
                .map(party -> {
                    party.setPartyMemberName(newParty.getPartyMemberName());
                    party.setCustomerPhone(newParty.getCustomerPhone());
                    return repository.save(party);
                }) //
                .orElseGet(() -> {
                    newParty.setPartyID(partyID);
                    return repository.save(newParty);
                });

        EntityModel<Party> entityModel = assembler.toModel(updatedParty);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel);
    }

    @DeleteMapping("/party/{partyID}")
    ResponseEntity<?> deleteParty(@PathVariable Long partyID) {

        repository.deleteById(partyID);

        return ResponseEntity.noContent().build();
    }
}