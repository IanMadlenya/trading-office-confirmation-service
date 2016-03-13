package com.trading;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
class ConfirmationController {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmationController.class);

    private final ConfirmationRepository confirmationRepository;
    private final ResolveUri resolveUri;

    @Autowired
    public ConfirmationController(ConfirmationRepository confirmationRepository, ResolveUri resolveUri) {
        this.confirmationRepository = confirmationRepository;
        this.resolveUri = resolveUri;
    }

    @ApiOperation(value = "getConfirmation", nickname = "getConfirmation")
    @RequestMapping(value = "confirmation/{id}", method = RequestMethod.GET)
    public Confirmation getConfirmation(
            @ApiParam(name = "id", required = true, value = "Confirmation id")
            @PathVariable String id
    ) {
        return confirmationRepository.findOne(id);
    }

    @ApiOperation(value = "addConfirmation", nickname = "addOperation")
    @RequestMapping(value = "confirmation", method = RequestMethod.POST)
    public ResponseEntity addConfirmation(
            @ApiParam(name = "confirmation", required = true)
            @RequestBody Confirmation confirmation) {

        Confirmation saved = confirmationRepository.save(confirmation);
        URI uri = resolveUri.path("/{id}").expandUri(saved.getAllocationId());

        LOG.info("Created: " + uri.toString());
        return ResponseEntity.created(uri).body(saved);
    }
}
