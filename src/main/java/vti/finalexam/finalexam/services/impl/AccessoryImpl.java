package vti.finalexam.finalexam.services.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import vti.finalexam.finalexam.entity.Accessory;
import vti.finalexam.finalexam.repository.AccessoryRepository;
import vti.finalexam.finalexam.services.AccessoryService;

@Service
@Transactional
public class AccessoryImpl implements AccessoryService {

    private final Logger log = LoggerFactory.getLogger(AccessoryImpl.class);

    private final AccessoryRepository accessoryRepository;

    public AccessoryImpl(AccessoryRepository accessoryRepository) {
        this.accessoryRepository = accessoryRepository;
    }

    @Override
    public Accessory save(Accessory accessory) {
        log.debug("Request to save Accessory : {}", accessory);
        return accessoryRepository.save(accessory);
    }

    @Override
    public Accessory update(Accessory accessory) {
        log.debug("Request to update Accessory : {}", accessory);
        return accessoryRepository.save(accessory);
    }

    @Override
    public Optional<Accessory> updateById(Accessory accessory) {
        log.debug("Request to update Accessory : {}", accessory);
        return accessoryRepository.findById(accessory.getId())
                .map(existingAccessory -> {
                    if (accessory.getName() != null) {
                        existingAccessory.setName(accessory.getName());
                    }
                    if (accessory.getPrice()  != 0.0d) {
                        existingAccessory.setPrice(accessory.getPrice());
                    }
                    if (accessory.getStatusDamaged() != null) {
                        existingAccessory.setStatusDamaged(accessory.getStatusDamaged());
                    }
                    if (accessory.getRepairStatus() != null) {
                        existingAccessory.setRepairStatus(accessory.getRepairStatus());
                    }
                    return existingAccessory;
                })
                .map(accessoryRepository::save);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Accessory : {}", id);
        accessoryRepository.deleteById(id);
    }

    @Override
    public List<Accessory> findAll() {
        log.debug("Request to get all Accessory");
        return accessoryRepository.findAll();
    }

    @Override
    public Optional<Accessory> findById(Long id) {
        return accessoryRepository.findById(id);
    }

}
