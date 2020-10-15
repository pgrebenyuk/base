package base.service.manufacturer;

import org.springframework.stereotype.Component;

//в спрінг є спеціальні анотації для сервіса @Service
//по суті це то й же компонент, але просто позначає сервіс
@Component
public interface ManufacturerService {
    int getRandomManufacturersId();
}
