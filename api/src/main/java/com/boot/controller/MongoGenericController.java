package com.boot.controller;

import com.boot.entity.EntityUtils;
import com.boot.entity.GenericEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/mongodb")
public class MongoGenericController {
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@GetMapping(value = "/{collectionName}")
	public List<GenericEntity> list(@PathVariable(required = true) String collectionName) {
		return mongoTemplate.findAll(GenericEntity.class,collectionName);
	}

	@PostMapping(value = "/{collectionName}")
	public void create(@PathVariable(required = true) String collectionName,@RequestBody GenericEntity blogpost) {
		 mongoTemplate.save(blogpost,collectionName);
	}

	@GetMapping(value = "/{collectionName}/{id}")
	public GenericEntity get(@PathVariable(required = true) String collectionName,@PathVariable String id) {
		return mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)),GenericEntity.class,collectionName);
	}

	@PutMapping(value = "/{collectionName}/{id}")
	public void update(@PathVariable(required = true) String collectionName,@PathVariable String id, @RequestBody GenericEntity blogpost) throws IOException {
		//GenericEntity existingGenericEntity = mongoTemplate.findOne(new Query(Criteria.where("_id").is(id)),GenericEntity.class,collectionName);
		//BeanUtils.copyProperties(blogpost, existingGenericEntity);
		Update update = new Update();
		Map<String,Object> modifiedFields = EntityUtils.getNonNulFields(blogpost);
		modifiedFields.forEach((k,v)->{ update.addToSet(k,v);});
		mongoTemplate.findAndModify(new Query(Criteria.where("_id").is(id)),update,GenericEntity.class,collectionName);
	}

	@DeleteMapping(value = "/{collectionName}/{id}")
	public void delete(@PathVariable(required = true) String collectionName,@PathVariable String id) {
		mongoTemplate.findAndRemove(new Query(Criteria.where("_id").is(id)),GenericEntity.class,collectionName);
	}
	
}
