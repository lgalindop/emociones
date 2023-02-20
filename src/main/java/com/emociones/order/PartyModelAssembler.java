package com.emociones.order;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PartyModelAssembler implements RepresentationModelAssembler<Party, EntityModel<Party>> {

    @Override
    public EntityModel<Party> toModel(Party party) {

        return EntityModel.of(party, //
                linkTo(methodOn(PartyController.class).one(party.getPartyID())).withSelfRel(),
                linkTo(methodOn(PartyController.class).all()).withRel("parties"));
    }
}