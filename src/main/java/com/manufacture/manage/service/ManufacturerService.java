package com.manufacture.manage.service;

import com.manufacture.manage.model.ManufacturerModel;

public interface ManufacturerService {

	public void createManufacturer(ManufacturerModel manufacturerModel);

	public void updateManufacturer(ManufacturerModel manufacturerModel);

	public void deleteByManufacturerId(int manufacturerId);

	public ManufacturerModel findByManufacturerId(int manufacturerId);
}
