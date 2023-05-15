package com.pe.criticalOne.repo;

import com.pe.criticalOne.entity.CampaignEntity;
import org.springframework.data.repository.CrudRepository;

public interface CampaignRepo extends CrudRepository<CampaignEntity, Long> {
    CampaignEntity findByCampaignName(String name);
}
