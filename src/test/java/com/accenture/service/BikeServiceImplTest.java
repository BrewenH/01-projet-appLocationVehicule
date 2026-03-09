package com.accenture.service;

import com.accenture.exception.BikeException;
import com.accenture.models.Bike;
import com.accenture.service.dto.BikeRequestDto;
import com.accenture.service.dto.BikeResponseDto;
import com.accenture.service.fake.FakeBikeMapper;
import com.accenture.service.fake.FakeBikeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.StaticMessageSource;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

 class BikeServiceImplTest {

    private FakeBikeRepository bikeRepository;
    private FakeBikeMapper bikeMapper;
    private BikeServiceImpl service;

    @BeforeEach
    void setup() {
        bikeRepository = new FakeBikeRepository();
        bikeMapper = new FakeBikeMapper();

        service = new BikeServiceImpl(bikeRepository, bikeMapper, messageAccessor());
    }

    @Nested
    @DisplayName("addBike")
    class AddBikeTests {
        @Test
        @DisplayName("OK")
        void addBikeOk() {
            BikeRequestDto req = new BikeRequestDto("Brand A", "Model A", "Type A",
                    "Color A", "License A", 0, 0, false,
                    false, 0, 0, false, false,
                    0, 0);
            BikeResponseDto res = service.addBike(req);

            assertEquals("Brand A", res.brand());
            assertEquals("Model A", res.model());
            assertEquals("Type A", res.type());
            assertEquals("Color A", res.color());
            assertEquals("License A", res.license());
            assertEquals(0, res.mileage());
            assertEquals(0, res.dailyBaseRate());
            assertEquals(false, res.active());
            assertEquals(false, res.removedFromPark());
            assertEquals(0, res.frameSize());
            assertEquals(0, res.weight());
            assertEquals(false, res.electric());
            assertEquals(false, res.disckBrakes());
            assertEquals(0, res.batteryCapacity());
            assertEquals(0, res.autonomy());
        }

        @Test
        @DisplayName("invalid (null)")
        void addBikeInvalidNull() {
            assertThrows(BikeException.class, () -> service.addBike(null));
        }

        @Test
        @DisplayName("invalid (empty brand)")
        void addBikeInvalidEmptyBrand() {
            BikeRequestDto bikeRequestDto = new BikeRequestDto(" ", "Model A", "Type A",
                    "Color A", "License A", 0, 0, false,
                    false, 0, 0, false, false,
                    0, 0);
            assertThrows(BikeException.class, () -> service.addBike(bikeRequestDto));

        }

        @Test
        @DisplayName("invalid (empty model)")
        void addBikeInvalidEmptyModel() {
            BikeRequestDto bikeRequestDto = new BikeRequestDto("Brand A", "", "Type A",
                    "Color A", "License A", 0, 0, false,
                    false,0, 0, false, false,
                    0, 0);
            assertThrows(BikeException.class, () -> service.addBike(bikeRequestDto));
        }
    }

    @Nested
    @DisplayName("findAllBikes")
    class findTests {
        @Test
        @DisplayName("all : OK")
        void finAllOk() {
            bikeRepository.store.put(UUID.randomUUID(), bike(UUID.randomUUID(),"B1", "M1", "T1", "C1", "L1", 1,
                    1, false, false, 1, 1, false, false, 1, 1));

            List<BikeResponseDto> res = service.findAll();

            assertEquals(1, res.size());
        }
    }

    private MessageSourceAccessor messageAccessor() {
        StaticMessageSource sms = new StaticMessageSource();
        sms.addMessage("bike.id.notofund", Locale.getDefault(), "bike.id.notfound");
        sms.addMessage("bike.null", Locale.getDefault(), "bike.null");
        sms.addMessage("bike.brand.null", Locale.getDefault(), "bike.brand.null");
        sms.addMessage("bike.model.null", Locale.getDefault(), "bike.model.null");
        return new MessageSourceAccessor(sms);
    }

    private Bike bike(UUID uuid, String brand, String model, String type, String color, String license, int mileage,
                      int dailyBaseRate, boolean active, boolean removedFromPark, int frameSize, int weight,
                      boolean electric, boolean discBrakes, int batteryCapacity, int autonomy) {
        Bike b = new Bike();
        b.setId(uuid);
        b.setBrand(brand);
        b.setModel(model);
        b.setType(type);
        b.setColor(color);
        b.setLicense(license);
        b.setMileage(mileage);
        b.setDailyBaseRate(dailyBaseRate);
        b.setActive(active);
        b.setRemovedFromPark(removedFromPark);
        b.setFrameSize(frameSize);
        b.setWeight(weight);
        b.setElectric(electric);
        b.setDiscBrakes(discBrakes);
        b.setBatteryCapacity(batteryCapacity);
        b.setAutonomy(autonomy);
        return b;
    }

}
