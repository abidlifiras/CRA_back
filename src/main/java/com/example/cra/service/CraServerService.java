package com.example.cra.service;

import com.example.cra.model.CraServer;
import com.example.cra.repository.CraServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CraServerService {

    @Autowired
    private CraServerRepository craServerRepository;

    public List<CraServer> getAllServers() {
        return craServerRepository.findAll();
    }

    public Optional<CraServer> getServerById(Long id) {
        return craServerRepository.findById(id);
    }

    public CraServer createServer(CraServer server) {
        return craServerRepository.save(server);
    }

    public CraServer updateServer(Long id, CraServer server) {
        Optional<CraServer> optionalServer = craServerRepository.findById(id);
        if (optionalServer.isPresent()) {
            CraServer existingServer = optionalServer.get();
            existingServer.setServerName(server.getServerName());
            existingServer.setApplication(server.getApplication());
            existingServer.setDataSource(server.getDataSource());
            existingServer.setOperatingSystem(server.getOperatingSystem());
            existingServer.setType(server.getType());
            existingServer.setRole(server.getRole());
            existingServer.setCurrentNumberOfCores(server.getCurrentNumberOfCores());
            existingServer.setCurrentRAMGB(server.getCurrentRAMGB());
            existingServer.setCurrentDiskGB(server.getCurrentDiskGB());
            existingServer.setPowerStatus(server.getPowerStatus());
            existingServer.setServerNotes(server.getServerNotes());
            existingServer.setIpAddress(server.getIpAddress());
            existingServer.setTimestamp(server.getTimestamp());
            return craServerRepository.save(existingServer);
        } else {
            return null;
        }
    }

    public void deleteServer(Long id) {
        craServerRepository.deleteById(id);
    }
}
