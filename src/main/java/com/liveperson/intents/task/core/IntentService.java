package com.liveperson.intents.task.core;

import com.liveperson.intents.task.common.IntentRecord;

import java.util.List;

public interface IntentService {
    void createIntent(String category, String subCategory, String text);
    void createIntent(IntentRecord intentRecord);
    void deleteIntent(int id);
    List<IntentRecord> getAllIntents();
    IntentRecord getIntentById(int id);
    List<IntentRecord> getIntentsByCategoryAndSubCategory(String category, String subCategory);
}
