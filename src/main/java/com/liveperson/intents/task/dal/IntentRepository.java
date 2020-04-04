package com.liveperson.intents.task.dal;

import com.liveperson.intents.task.common.IntentRecord;

import java.util.List;

public interface IntentRepository {
    void createIntent(String category, String subCategory, String text);
    void createIntent(IntentRecord intentRecord);
    void deleteIntent(int id);
    List<IntentRecord> getAllIntents();
    IntentRecord getIntentById(int id);
    List<IntentRecord> getIntentsByCategoryAndSubcategory(String category, String subCategory);

    String getApiKey(String key);
}
