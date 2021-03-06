package com.virtusa.shipment.biz.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.virtusa.shipment.data.enity.ShippmentEntity;
import com.virtusa.shipment.data.repository.ShippmentRepository;

@Service
public class ShippmentService {

	@Inject
	private ShippmentRepository shipmentRepository;

	@Transactional
	public ShippmentEntity create(ShippmentEntity shippmentEntity) {
		ShippmentEntity shippmentObj = shipmentRepository.save(shippmentEntity);
		return shippmentObj;
	}

	public List<ShippmentEntity> getAll() {
		return shipmentRepository.findAll();
	}

	@Transactional
	public ShippmentEntity get(Long id) {
		return shipmentRepository.findOne(id);
	}

	@Transactional
	public ShippmentEntity update(ShippmentEntity shipmentEntity) {
		Long id=shipmentEntity.getId();
		ShippmentEntity shipmentObj=shipmentRepository.findOne(id);
		return shipmentRepository.save(shipmentEntity);
	}

	@Transactional
	public ShippmentEntity partialUpdate(long id,
			ShippmentEntity shippmentEntity) {
		ShippmentEntity shipmentObj = shipmentRepository.findOne(id);
		shipmentObj.setStatus(shippmentEntity.getStatus());
		return shipmentRepository.save(shipmentObj);
	}

	@Transactional
	public void delete(long id) {
		shipmentRepository.delete(id);
	}
}
