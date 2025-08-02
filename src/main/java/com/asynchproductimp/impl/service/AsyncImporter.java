package com.asynchproductimp.impl.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.asynchproductimp.impl.dao.ProductRepository;
import com.asynchproductimp.impl.entities.Product;
import com.asynchproductimp.impl.entities.Status;

@Service
public class AsyncImporter {

	@Autowired
	private ProductRepository productRepository;
	
	Logger logger = LoggerFactory.getLogger(AsyncImporter.class);

	@Async
	public void importProductAsync(List<Product> prods, ConcurrentHashMap<String, Status> statusMap, String trackId) {

		try {
			logger.info("Import status: "+Status.IN_PROGRESS.toString());
			statusMap.put(trackId, Status.IN_PROGRESS);
			Thread.sleep(20000);
			for(Product p : prods) {
				p.setTrackId(trackId);
			}
			productRepository.saveAll(prods);
			logger.info("Import status: "+ Status.COMPLETED.toString());
			statusMap.put(trackId, Status.COMPLETED);

		} catch (Exception e) {
			logger.info("Import status: "+Status.FAILED.toString());
			statusMap.put(trackId, Status.FAILED);
			e.printStackTrace();

		}

	}

}
