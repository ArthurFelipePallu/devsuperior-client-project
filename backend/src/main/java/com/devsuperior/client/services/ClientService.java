package com.devsuperior.client.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.client.dtos.ClientDTO;
import com.devsuperior.client.entities.Client;
import com.devsuperior.client.repositories.ClientRepository;
import com.devsuperior.client.services.exceptions.DatabaseException;
import com.devsuperior.client.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly=true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(x->new ClientDTO(x)).collect(Collectors.toList());		
	}
	
	@Transactional(readOnly=true)
	public ClientDTO findById(Long id){
		Optional<Client> obj = repository.findById(id);
		Client c = obj.orElseThrow(()->new ResourceNotFoundException("Entity NOT FOUND"));
		return new ClientDTO(c);		
	}

	@Transactional(readOnly=true)
	public ClientDTO insert(ClientDTO dto) {

		Client client = new Client();
		client.setName(dto.getName());
		client.setBirthDate(dto.getBirthDate());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setChildren(dto.getChildren());
		
		client = repository.save(client);
		return new ClientDTO(client);
	}
	
	
	@Transactional
	public ClientDTO update(Long id, ClientDTO dto) {
		try {
			Client c = repository.getReferenceById(id);
			c.setName(dto.getName());
			c.setBirthDate(dto.getBirthDate());
			c.setCpf(dto.getCpf());
			c.setIncome(dto.getIncome());
			c.setChildren(dto.getChildren());
			c = repository.save(c);
			return new ClientDTO(c);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found " + id);
		}		
	}
	
	@Transactional
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation");
		}
	}
	
	
}
