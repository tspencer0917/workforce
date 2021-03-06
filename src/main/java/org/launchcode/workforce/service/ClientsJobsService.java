package org.launchcode.workforce.service;

import org.launchcode.workforce.model.ClientsJobs;
import org.launchcode.workforce.repository.ClientsJobsRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;

@Service
public class ClientsJobsService {

    private ClientsJobsRepository clientsJobsRepository;

    public ClientsJobsService(ClientsJobsRepository clientsJobsRepository) {
        this.clientsJobsRepository = clientsJobsRepository;
    }

    public List<ClientsJobs> getAll() {
        return clientsJobsRepository.findAll();
    }

    public Optional<ClientsJobs> get(Long id) {
        return clientsJobsRepository.findById(id);
    }

    public List<ClientsJobs> getByLocation(Long id) {
        return clientsJobsRepository.findByLocationId(id);
    }

    public List<ClientsJobs> getByClient(Long id) {
        return clientsJobsRepository.findByClientId(id);
    }

    public ClientsJobs add(ClientsJobs clientsJobs) {
        return clientsJobsRepository.save(clientsJobs);
    }

    public Optional<ClientsJobs> update(ClientsJobs clientsJobs) {
        if(clientsJobsRepository.existsById(clientsJobs.getId())){
            clientsJobsRepository.save(clientsJobs);
            return Optional.of(clientsJobs);
        }
        return Optional.empty();
    }

    public boolean delete(Long id) {
        if (clientsJobsRepository.existsById(id)) {
            clientsJobsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}