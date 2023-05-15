package com.pe.criticalOne.service;

import com.pe.criticalOne.entity.CampaignEntity;
import com.pe.criticalOne.exception.ObjectAlreadyExistsException;
import com.pe.criticalOne.repo.CampaignRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignService {
    @Autowired
    private CampaignRepo campaignRepo;

    public CampaignEntity create(CampaignEntity campaign) throws ObjectAlreadyExistsException {
        if (campaignRepo.findByCampaignName(campaign.getCampaignName()) != null) {
            throw new ObjectAlreadyExistsException("Кампания с таким названием уже существует!");
        }
        return campaignRepo.save(campaign);
    }

    public CampaignEntity getOne(Long id) {
        return campaignRepo.findById(id).get();
    }

    public List<CampaignEntity> getAll() {
        List<CampaignEntity> campaigns = new ArrayList<>();
        campaignRepo.findAll().forEach(campaigns::add);
        return campaigns;
    }

    public CampaignEntity update(Long id, CampaignEntity campaign) throws ObjectAlreadyExistsException {
        CampaignEntity campaignDB = campaignRepo.findById(id).get();
        if (campaignRepo.findByCampaignName(campaign.getCampaignName()) != null && campaignRepo.findByCampaignName(campaign.getCampaignName()) != campaignDB) {
            throw new ObjectAlreadyExistsException("Кампания с таким названием уже существует!");
        }
        campaignDB.setCampaignName(campaign.getCampaignName());
        campaignDB.setUser(campaign.getUser());
        campaignDB.setCharacters(campaign.getCharacters());
        return campaignRepo.save(campaignDB);
    }

    public Long delete(Long id) {
        CampaignEntity campaign = campaignRepo.findById(id).get();
        campaignRepo.deleteById(id);
        return id;
    }
}
