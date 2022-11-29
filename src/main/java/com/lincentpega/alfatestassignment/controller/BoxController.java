package com.lincentpega.alfatestassignment.controller;

import com.lincentpega.alfatestassignment.exception.BoxNotFoundException;
import com.lincentpega.alfatestassignment.model.Box;
import com.lincentpega.alfatestassignment.repository.BoxRepository;
import com.lincentpega.alfatestassignment.repository.ItemRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BoxController {
    BoxRepository boxRepository;
    ItemRepository itemRepository;

    public BoxController(BoxRepository boxRepository, ItemRepository itemRepository) {
        this.boxRepository = boxRepository;
        this.itemRepository = itemRepository;
    }

    @GetMapping("/boxes")
    public CollectionModel<EntityModel<Box>> getAllBoxes() {
        List<EntityModel<Box>> boxes = boxRepository.findAll().stream()
                .map(box -> EntityModel.of(box,
                        linkTo(methodOn(BoxController.class).getBox(box.getId())).withSelfRel(),
                        linkTo(methodOn(BoxController.class).getAllBoxes()).withRel("boxes")))
                .collect(Collectors.toList());
        return CollectionModel.of(boxes,
                linkTo(methodOn(BoxController.class).getAllBoxes()).withSelfRel());
    }

    @GetMapping("/boxes/{id}")
    public EntityModel<Box> getBox(@PathVariable Integer id) {
        Box box = boxRepository.findById(id).orElseThrow(() -> new BoxNotFoundException(id));
        return EntityModel.of(box,
                linkTo(methodOn(BoxController.class).getBox(id)).withSelfRel(),
                linkTo(methodOn(BoxController.class).getAllBoxes()).withRel("boxes"));
    }

    @PostMapping("/boxes")
    public EntityModel<Box> addBox(@RequestBody Box box) {
        return EntityModel.of(boxRepository.save(box),
                linkTo(methodOn(BoxController.class).addBox(box)).withSelfRel());
    }
}
