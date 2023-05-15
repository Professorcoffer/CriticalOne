package com.pe.criticalOne.repo;

import com.pe.criticalOne.entity.CampaignEntity;
import com.pe.criticalOne.entity.QuestEntity;
import org.springframework.data.repository.CrudRepository;

public interface QuestRepo extends CrudRepository<QuestEntity, Long> {
    QuestEntity findByName(String name);
    QuestEntity findByCampaign(CampaignEntity campaign);
}
