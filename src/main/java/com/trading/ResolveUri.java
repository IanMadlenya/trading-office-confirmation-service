package com.trading;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

class ResolveUri {
    private UriComponentsBuilder uriComponentsBuilder;

    ResolveUri path(String path) {
        uriComponentsBuilder = ServletUriComponentsBuilder.fromCurrentRequest().path(path);
        return this;
    }

    URI expandUri(Object... uriVariableValues) {
        return uriComponentsBuilder.buildAndExpand(uriVariableValues).toUri();
    }
}
