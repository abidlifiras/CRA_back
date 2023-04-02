package com.example.cra.controller;

import com.example.cra.model.CraServer;
import com.example.cra.service.CraServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servers")
@CrossOrigin("*")
public class CraServerController {

    @Autowired
    private CraServerService craServerService;

    @GetMapping
    public ResponseEntity<List<CraServer>> getAllServers() {
        List<CraServer> servers = craServerService.getAllServers();
        return new ResponseEntity<>(servers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CraServer> getServerById(@PathVariable("id") Long id) {
        CraServer server = craServerService.getServerById(id).orElse(null);
        if (server == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(server, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CraServer> createServer(@RequestBody CraServer server) {
        CraServer newServer = craServerService.createServer(server);
        return new ResponseEntity<>(newServer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CraServer> updateServer(@PathVariable("id") Long id, @RequestBody CraServer server) {
        CraServer updatedServer = craServerService.updateServer(id, server);
        if (updatedServer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedServer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServer(@PathVariable("id") Long id) {
        craServerService.deleteServer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
