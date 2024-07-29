package com.liveasy.loadmanagement.service;

import com.liveasy.loadmanagement.entity.Load;
import com.liveasy.loadmanagement.repository.LoadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoadService {
    @Autowired
    private LoadRepository loadRepository;

    public Load saveLoad(Load load) {
        return loadRepository.save(load);
    }

    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }

    public Optional<Load> getLoadById(UUID loadId) {
        return loadRepository.findById(loadId);
    }

    public Load updateLoad(UUID loadId, Load loadDetails) {
        Load load = loadRepository.findById(loadId).orElseThrow(() -> new RuntimeException("Load not found"));
        load.setLoadingPoint(loadDetails.getLoadingPoint());
        load.setUnloadingPoint(loadDetails.getUnloadingPoint());
        load.setProductType(loadDetails.getProductType());
        load.setTruckType(loadDetails.getTruckType());
        load.setNoOfTrucks(loadDetails.getNoOfTrucks());
        load.setWeight(loadDetails.getWeight());
        load.setComment(loadDetails.getComment());
        load.setDate(loadDetails.getDate());
        return loadRepository.save(load);
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }
}
