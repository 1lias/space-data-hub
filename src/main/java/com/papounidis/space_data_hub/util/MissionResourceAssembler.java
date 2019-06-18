package com.papounidis.space_data_hub.util;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import com.papounidis.space_data_hub.controller.MissionController;
import com.papounidis.space_data_hub.model.Mission;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

/*
Creates the link assembler for the implementation of HATEOAS
 */

@Component
public class MissionResourceAssembler implements ResourceAssembler<Mission, Resource<Mission>> {

    @Override
    public Resource<Mission> toResource(Mission employee) {

        return new Resource<>(employee,
                linkTo(methodOn(MissionController.class).getMission(employee.getId())).withSelfRel(),
                linkTo(methodOn(MissionController.class).getAll()).withRel("missions"));
    }
}
