package gribiwe.service;

import gribiwe.entity.TransportEntity;
import gribiwe.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransportService {

   private final TransportRepository transportRepository;

   @Autowired
   public TransportService(TransportRepository transportRepository) {
      this.transportRepository = transportRepository;
   }

   public List<TransportEntity> getTransportEntities(Double capacity, Double weight) {
      return transportRepository.findTransportEntitiesByMaxCapacityIsGreaterThanEqualAndMaxWeightIsGreaterThanEqual(capacity, weight);
   }

   public TransportEntity saveTransport(String name, Double price, Double maxCapacity, Double maxWeight) {
      TransportEntity transportEntity = new TransportEntity();
      transportEntity.setId(UUID.randomUUID());
      transportEntity.setName(name);
      transportEntity.setPrice(price);
      transportEntity.setMaxCapacity(maxCapacity);
      transportEntity.setMaxWeight(maxWeight);
      return transportRepository.save(transportEntity);
   }

   public TransportEntity getTransport(UUID uuid) {
      return transportRepository.findOne(uuid);
   }

   public List<TransportEntity> getTransportEntities() {
      return transportRepository.findAll();
   }
}
