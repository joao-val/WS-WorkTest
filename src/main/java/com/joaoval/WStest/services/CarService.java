package com.joaoval.WStest.services;

import com.joaoval.WStest.controllers.forms.CarForm;
import com.joaoval.WStest.dto.CarDTO;
import com.joaoval.WStest.entities.Car;
import com.joaoval.WStest.entities.Factory;
import com.joaoval.WStest.repositories.CarRepository;
import com.joaoval.WStest.repositories.FactoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final FactoryRepository factoryRepository;

    public CarService(CarRepository carRepository, FactoryRepository factoryRepository) {
        this.carRepository = carRepository;
        this.factoryRepository = factoryRepository;
    }

    public Car addCar(CarForm carForm) {
        Optional<Factory> factoryOptional = factoryRepository.findById(carForm.getFactoryId());

        if (factoryOptional.isEmpty()) throw new EntityNotFoundException(String.format(
                "Factory with id %d not found", carForm.getFactoryId()));

        Car car = new Car(
            factoryOptional.get(),
            carForm.getModel(),
            carForm.getYear(),
            carForm.getFuelType(),
            carForm.getDoors(),
            carForm.getCost(),
            carForm.getColor());

        carRepository.save(car);

        return  car;
    }

    public Page<CarDTO> findCarList(
            String factoryName,
            Short yearMin, Short yearMax,
            Short doorsMin, Short doorsMax,
            BigDecimal costMin, BigDecimal costMax,
            String color,
            Pageable pageable) {

        Page<Car> carsList;

        if (factoryName != null && color != null){
            carsList = carRepository.findWithFilters(factoryName, yearMin, yearMax, doorsMin, doorsMax, costMin, costMax, color, pageable);
        } else if (factoryName != null ){
            carsList = carRepository.findWithFilters(factoryName, yearMin, yearMax, doorsMin, doorsMax, costMin, costMax, pageable);
        } else if (color != null ){
            carsList = carRepository.findWithFilters(yearMin, yearMax, doorsMin, doorsMax, costMin, costMax, color, pageable);
        } else {
            carsList = carRepository.findWithFilters(yearMin, yearMax, doorsMin, doorsMax, costMin, costMax, pageable);
        }

        return carsList.map(CarDTO::new);
    }

    @Transactional
    public Car getCarById(Long id) {
        Optional<Car> carOptional = carRepository.findById(id);

        if (carOptional.isEmpty()) throw new EntityNotFoundException(String.format(
                "Car with id %d not found", id));
        return carOptional.get();
    }

    @Transactional
    public Car updatedCarData(Long id, CarForm carForm) {
        Optional<Car> carOptional = carRepository.findById(id);

        if (carOptional.isEmpty()) throw new EntityNotFoundException(String.format(
                "Car with id %d not found", id));

        Car car = carOptional.get();

        if (!car.getFactory().equals(carForm.getFactoryId())){
            Optional<Factory> factoryOptional = factoryRepository.findById(id);

            if (factoryOptional.isEmpty()) throw new EntityNotFoundException(String.format(
                    "Factory with id %d not found", carForm.getFactoryId()));

            car.setFactory(factoryOptional.get());
        }

        car.setModel(carForm.getModel());
        car.setYear(carForm.getYear());
        car.setFuel(carForm.getFuelType());
        car.setDoors(carForm.getDoors());
        car.setCost(carForm.getCost());
        car.setColor(carForm.getColor());

        return car;
    }

    public void deleteCarFromDB(Long id) {
        Car car = getCarById(id);

        carRepository.delete(car);
    }

}
