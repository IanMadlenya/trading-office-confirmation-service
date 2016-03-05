package com.trading;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
class ConfirmationController {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmationController.class);

    private final ConfirmationRepository confirmationRepository;

    @Autowired
    public ConfirmationController(ConfirmationRepository confirmationRepository) {
        this.confirmationRepository = confirmationRepository;
    }

    @ApiOperation(value = "getConfirmation", nickname = "getConfirmation")
    @RequestMapping(value = "confirmation/{id}", method = RequestMethod.GET)
    public Confirmation getConfirmation(
            @ApiParam(name = "id", required = true, value = "Confirmation id")
            @PathVariable String id
    ) {
        return confirmationRepository.queryById(id);
    }

    @ApiOperation(value = "addConfirmation", nickname = "addOperation")
    @RequestMapping(value = "confirmation", method = RequestMethod.POST)
    public ResponseEntity addConfirmation(
            @ApiParam(name = "confirmation", required = true)
            @RequestBody Confirmation confirmation) {

        try {
            confirmationRepository.save(confirmation);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
