package com.liveperson.intents.task.api;

import com.liveperson.intents.task.common.IntentRecord;
import com.liveperson.intents.task.core.IntentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IntentsController {

    private IntentService intentService;

    public IntentsController(IntentService intentService) {
        this.intentService = intentService;
    }

    @GetMapping("/intent/{id}")
    public IntentRecord getIntent(@PathVariable("id") int id) {
        return intentService.getIntentById(id);
    }

    @DeleteMapping("/intent/{id}")
    public void deleteIntent(@PathVariable("id") int id) {
        intentService.deleteIntent(id);
    }

    @PostMapping("/intent")
    public String createIntent(String category, String subCategory, String text) {
        try {
            intentService.createIntent(category, subCategory, text);
            return "SUCCESSFULLY CREATED INTENT RECORD";
        } catch (Exception e) {
            return "FAILED TO CREATE INTENT RECORD";
        }
    }

    @PostMapping("/intents")
    public String createMultipleIntents(List<IntentRecord> intentRecords) {
        try {
            intentRecords.forEach(intentRecord -> intentService.createIntent(intentRecord));
            return "SUCCESSFULLY CREATED MULTIPLE INTENT RECORDS";
        } catch (Exception e) {
            return "FAILED TO CREATE SOME/ALL INTENT RECORDS";
        }
    }

    @GetMapping("/intents")
    public List<IntentRecord> getAllIntents() {
        List<IntentRecord> allIntents = intentService.getAllIntents();
        return allIntents;
    }

    @GetMapping("/intents/category/{category}")
    public List<IntentRecord> getIntentsByCategory(@PathVariable("category") String category) {
        return intentService.getIntentsByCategoryAndSubCategory(category, null);
    }

    @GetMapping("/intents/subcategory/{subCategory}")
    public List<IntentRecord> getIntentsBySubCategory(@PathVariable("subCategory") String subCategory) {
        return intentService.getIntentsByCategoryAndSubCategory(null, subCategory);
    }

    @GetMapping("/intents/category/{category}/subcategory/{subCategory}")
    public List<IntentRecord> getIntentsByCategoryAndSubCategory(@PathVariable("category") String category,
                                                                 @PathVariable("subCategory") String subCategory) {
        return intentService.getIntentsByCategoryAndSubCategory(category, subCategory);
    }
}
