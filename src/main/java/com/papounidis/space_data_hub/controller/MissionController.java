package com.papounidis.space_data_hub.controller;

import com.papounidis.space_data_hub.infrastructure.MissionRepository;
import com.papounidis.space_data_hub.model.Mission;
import com.papounidis.space_data_hub.util.MissionNotFoundException;
import com.papounidis.space_data_hub.util.MissionResourceAssembler;

import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

/*
Giving the functionality for the PCA to ADD, EDIT and DELETE Missions
 */

@RestController
public class MissionController {

    private final MissionRepository repository;
    private final MissionResourceAssembler assembler;

    MissionController(MissionRepository repository, MissionResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }


    /*
    Specifying the way to handle GET HTTP requests for the query to get all missions.
     */
    @GetMapping("/missions")
    public Resources<Resource<Mission>> getAll() {

        List<Resource<Mission>> missions = repository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(missions,
                linkTo(methodOn(MissionController.class).getAll()).withSelfRel());
    }

    /*
    Specifying the way to handle POST HTTP requests for the addition of new missions.
     */
    @PostMapping("/missions")
    public ResponseEntity<?> addMission(@RequestBody Mission newMission) throws URISyntaxException {

        Resource<Mission> resource = assembler.toResource(repository.save(newMission));

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    /*
    Specifying the way to handle GET HTTP requests for the query of a specific mission.
     */
    @GetMapping("/missions/{id}")
    public Resource<Mission> getMission(@PathVariable int id) {
        Mission mission = repository.findById(id).orElseThrow(() -> new MissionNotFoundException(id));

        return assembler.toResource(mission);
    }

    /*
    Specifying the way to handle PUT HTTP requests for the edit of specific missions.
     */
    @PutMapping("/missions/{id}")
    public ResponseEntity<?> updateMission(@RequestBody Mission newMission, @PathVariable int id) throws URISyntaxException {

        Mission updatedMission = repository.findById(id)
                .map(mission -> {
                    mission.setName(newMission.getName());
                    mission.setType(newMission.getType());
                    mission.setStart(newMission.getStart());
                    mission.setEnd(newMission.getEnd());
                    return repository.save(mission);
                })
                .orElseGet(() -> {
                    newMission.setId(id);
                    return repository.save(newMission);
                });

        Resource<Mission> resource = assembler.toResource(updatedMission);

        return ResponseEntity
                .created(new URI(resource.getId().expand().getHref()))
                .body(resource);
    }

    /*
    Specifying the way to handle DELETE HTTP requests for the deletion of specific missions.
     */
    @DeleteMapping("/missions/{id}")
    public ResponseEntity<?> deleteMission(@PathVariable int id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}

