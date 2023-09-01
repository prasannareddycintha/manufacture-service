package com.manufacture.manage.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manufacture.manage.entity.ManufacturerEntity;
import com.manufacture.manage.exception.ManufactureNotFound;
import com.manufacture.manage.mapper.ManufacturerEntityMapper;
import com.manufacture.manage.mapper.ManufacturerModelMapper;
import com.manufacture.manage.model.ManufacturerModel;
import com.manufacture.manage.repository.ManufacturerDao;
import com.manufacture.manage.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerDao manufacturerDao;

	@Autowired
	private ManufacturerEntityMapper manufacturerEntityMapper;

	@Autowired
	private ManufacturerModelMapper manufacturerModelMapper;

	@Override
	public void createManufacturer(ManufacturerModel manufacturerModel) {
		manufacturerDao.save(manufacturerEntityMapper.modelToManufacturerEntity(manufacturerModel));
	}

	@Override
	public void updateManufacturer(ManufacturerModel manufacturerModel) {
		manufacturerDao.save(manufacturerEntityMapper.modelToManufacturerEntity(manufacturerModel));
	}

	@Override
	public void deleteByManufacturerId(int manufacturerId) {
		manufacturerDao.deleteById(manufacturerId);
	}

	@Override
	public ManufacturerModel findByManufacturerId(int manufacturerId) {
		ManufacturerModel manufacturerModel;
		Optional<ManufacturerEntity> manufacturerEntityOptional = manufacturerDao.findById(manufacturerId);
		if (manufacturerEntityOptional.isPresent()) {
			manufacturerModel = manufacturerModelMapper.entityToManufacturerModel(manufacturerEntityOptional.get());
		} else {
			throw new ManufactureNotFound("manufacturer is not found for given manufactureId--->" + manufacturerId);
		}
		return manufacturerModel;
	}

}
