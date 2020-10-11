package base.service;

public interface ManufacturerService {
    //цей метод хороший, він вирішує свою задачу, а саме сказати скільки виробників в базі
    //а от назву я б змінив на getManufacturersCount
    int size();
}
