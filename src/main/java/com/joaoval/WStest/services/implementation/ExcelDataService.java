package com.joaoval.WStest.services.implementation;

import com.joaoval.WStest.entities.Car;
import com.joaoval.WStest.entities.Factory;
import com.joaoval.WStest.repositories.CarRepository;
import com.joaoval.WStest.repositories.FactoryRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ExcelDataService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    FactoryRepository factoryRepository;

    public List<Car> getExcelDataAsList(Workbook workbook) {

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        // Getting number of columns in the Sheet
        int noOfRows = sheet.getLastRowNum();

        List<Car> carsList = new ArrayList<>();

        List<Factory> factories = new ArrayList<>();


        for (int i = 0; i < noOfRows; i++) {

            Row row = sheet.getRow(i);

            if (row.getLastCellNum() < 9) {
                break;
            }

            Factory factory;
            Car car = new Car();

            Long factoryId = (long) row.getCell(1).getNumericCellValue();
            String factoryName = row.getCell(2).getStringCellValue();

            car.setId((long) row.getCell(0).getNumericCellValue());
            car.setModel(row.getCell(3).getStringCellValue());
            car.setYear((short) row.getCell(4).getNumericCellValue());
            car.setFuel(row.getCell(5).getStringCellValue());
            car.setDoors((short) row.getCell(6).getNumericCellValue());
            car.setCost(BigDecimal.valueOf(row.getCell(7).getNumericCellValue()));
            car.setColor(row.getCell(8).getStringCellValue());

            Optional<Car> carOptionalId = carRepository.findById(car.getId());

            if (carOptionalId.isEmpty() || !car.compare(carOptionalId.get())) {

                Optional<Factory> factoryOptId = factoryRepository.findById(factoryId);
                if (
                    factoryOptId.isPresent() &&
                    factoryOptId.get().getFactoryName().toLowerCase(Locale.ROOT) == factoryName.toLowerCase(Locale.ROOT)
                ) {
                    factory = factoryOptId.get();
                }
                else {
                    factory = new Factory();
                }

                car.setFactory(factory);
                factories.add(factory);
                carsList.add(car);
            }
        }

        factoryRepository.saveAll(factories);
        carRepository.saveAll(carsList);

        return carsList;
    }

        public int saveExcelData (List<Car> CarModels) {
            CarModels = carRepository.saveAll(CarModels);
            return CarModels.size();
        }

}


