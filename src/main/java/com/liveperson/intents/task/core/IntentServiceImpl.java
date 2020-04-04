package com.liveperson.intents.task.core;

import com.liveperson.intents.task.common.IntentRecord;
import com.liveperson.intents.task.dal.IntentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntentServiceImpl implements IntentService {

    private IntentRepository intentRepository;

    public IntentServiceImpl(IntentRepository intentRepository) {
        this.intentRepository = intentRepository;
    }

    @Override
    public void createIntent(String category, String subCategory, String text) {
        intentRepository.createIntent(category, subCategory, text);
    }

    @Override
    public void createIntent(IntentRecord intentRecord) {
        intentRepository.createIntent(intentRecord);
    }

    @Override
    public void deleteIntent(int id) {
        intentRepository.deleteIntent(id);
    }

    @Override
    public List<IntentRecord> getAllIntents() {
        return intentRepository.getAllIntents();
    }

    @Override
    public IntentRecord getIntentById(int id) {
        return intentRepository.getIntentById(id);
    }

    @Override
    public List<IntentRecord> getIntentsByCategoryAndSubCategory(String category, String subCategory) {
        return intentRepository.getIntentsByCategoryAndSubcategory(category, subCategory);
    }
}
