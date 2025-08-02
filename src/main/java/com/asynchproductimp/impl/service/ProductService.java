package com.asynchproductimp.impl.service;


import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asynchproductimp.impl.entities.Product;
import com.asynchproductimp.impl.entities.Status;


@Service
public class ProductService {

	@Autowired
	private AsyncImporter asyncImporter;
	
	ConcurrentHashMap<String, Status> statusMap = new ConcurrentHashMap<>();
	Logger logger = LoggerFactory.getLogger(ProductService.class);
	
	public String uploadProducts(List<Product> p) {
		
		String trackId = UUID.randomUUID().toString();
		statusMap.put(trackId, Status.PENDING);
		logger.info("Import status: "+Status.PENDING.toString());
		asyncImporter.importProductAsync(p, statusMap, trackId);
		return trackId;
		
	}
	
	public Status getStatus(String trackId) {
		return statusMap.getOrDefault(trackId,Status.NOT_FOUND);
	}

}
