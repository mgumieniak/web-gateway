package com.mgumieniak.webgateway.controllers;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.Logger;

@Slf4j
@RestController
@RequestMapping(value = "/cv-api", produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('SCOPE_admin')")
    public Mono<Authentication> getAdmin(Mono<Authentication> auth) {
        return auth;
    }


    @GetMapping("/user")
    @PreAuthorize("hasAuthority('SCOPE_user') || hasAuthority('SCOPE_admin')")
    public Mono<Authentication> getUser(Mono<Authentication> auth) {
        return auth;
    }
}
