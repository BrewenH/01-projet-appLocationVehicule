package com.accenture.service.fake;

import com.accenture.models.Bike;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;
import com.accenture.service.mapper.BikeMapper;

import java.util.UUID;

public class FakeBikeMapper implements BikeMapper {
    private final UUID seq = UUID.randomUUID();

    @Override
    public Bike toBike(BikeRequestDto bikeRequestDto) {
        Bike b = new Bike();
        b.setId(seq);
        b.setBrand(bikeRequestDto.brand());
        b.setModel(bikeRequestDto.model());
        b.setType(bikeRequestDto.type());
        b.setColor(bikeRequestDto.color());
        b.setLicense(bikeRequestDto.license());
        b.setMileage(bikeRequestDto.mileage());
        b.setDailyBaseRate(bikeRequestDto.dailyBaseRate());
        b.setActive(bikeRequestDto.active());
        b.setRemovedFromPark(bikeRequestDto.removedFromPark());
        b.setFrameSize(bikeRequestDto.frameSize());
        b.setWeight(bikeRequestDto.weight());
        b.setElectric(bikeRequestDto.electric());
        b.setDiscBrakes(bikeRequestDto.discBrakes());
        b.setBatteryCapacity(bikeRequestDto.batteryCapacity());
        b.setAutonomy(bikeRequestDto.autonomy());
        return b;
    }

    @Override
    public BikeResponseDto toBikeResponseDto(Bike bike) {
        return new BikeResponseDto(bike.getId(), bike.getBrand(), bike.getModel(), bike.getType(), bike.getColor(),
                bike.getLicense(), bike.getMileage(), bike.getDailyBaseRate(), bike.isActive(), bike.isRemovedFromPark(),
                bike.getFrameSize(), bike.getWeight(), bike.isElectric(), bike.isDiscBrakes(), bike.getBatteryCapacity(), bike.getAutonomy());
    }
}
