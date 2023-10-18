package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoldCont {

	@Autowired
	private GoldRepo gr;
	@GetMapping("/pageone")
	public List<Gold>getpageone(){
		Pageable paging=PageRequest.of(0, 5, Sort.by("pid").ascending());
		Page<Gold>p=gr.findAll(paging);
		return p.getContent();
	}
	@PostMapping("/gold")
	public ResponseEntity<Gold>savedata(@RequestBody Gold g){
		return new ResponseEntity<Gold>(gr.save(g),HttpStatus.CREATED);
	}
	@GetMapping("/gold")
	public ResponseEntity<List<Gold>>getall(){
		return new ResponseEntity<>(gr.findAll(),HttpStatus.CREATED);
	}
	@GetMapping("/gold/{id}")
	public ResponseEntity<Gold>get(@PathVariable int id,@RequestBody Gold g){
		Optional<Gold>op=gr.findById(id);
		if(op.isPresent()) {
			return new ResponseEntity<>(op.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@PutMapping("/gold/{id}")
	public ResponseEntity<Gold>update(@PathVariable int pid,@RequestBody Gold g){
		Optional<Gold>op=gr.findById(pid);
		if(op.isPresent()) {
			return new ResponseEntity<>(gr.save(op.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	@DeleteMapping("/gold/{id}")
	public ResponseEntity<Gold>delete(@PathVariable int pid,@RequestBody Gold g){
		Optional<Gold>op=gr.findById(pid);
		if(op.isPresent()) {
			gr.deleteById(pid);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
