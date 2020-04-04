package com.liveperson.intents.task.dal;

import com.liveperson.intents.task.common.IntentRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IntentRepositoryImpl implements IntentRepository {
    private JdbcTemplate jdbcTemplate;

    public IntentRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createIntent(String category, String subCategory, String text) {
        jdbcTemplate.update(String.format("INSERT INTO missed_intents (category, sub_category, text) VALUES ('%s', '%s', '%s')",
                category, subCategory, text));
    }

    @Override
    public void createIntent(IntentRecord intentRecord) {
        jdbcTemplate.update(String.format("INSERT INTO missed_intents (category, sub_category, text) VALUES ('%s', '%s', '%s')",
                intentRecord.getCategory(), intentRecord.getSubCategory(), intentRecord.getText()));
    }

    @Override
    public void deleteIntent(int id) {
        jdbcTemplate.update("DELETE FROM missed_intents where id = " + id);
    }

    @Override
    public List<IntentRecord> getAllIntents() {
        return jdbcTemplate.query("SELECT * FROM missed_intents", (resultSet, i) -> new IntentRecord(
                resultSet.getInt("id"),
                resultSet.getString("category"),
                resultSet.getString("sub_category"),
                resultSet.getString("text")));
    }

    @Override
    public IntentRecord getIntentById(int id) {
        List<IntentRecord> intentRecords = jdbcTemplate.query("SELECT * FROM missed_intents WHERE id = " + id, (resultSet, i) -> new IntentRecord(
                resultSet.getInt("id"),
                resultSet.getString("category"),
                resultSet.getString("sub_category"),
                resultSet.getString("text")));
        return CollectionUtils.isEmpty(intentRecords) ? null : intentRecords.get(0);
    }

    @Override
    public List<IntentRecord> getIntentsByCategoryAndSubcategory(String category, String subCategory) {
        String query = "SELECT * " +
                        "FROM missed_intents " +
                        "WHERE 1=1 ";
        if (category != null) {
            query += "AND category = '" + category + "' ";
        }
        if (subCategory != null) {
            query += "AND sub_category = '" + subCategory + "' ";
        }
        return jdbcTemplate.query(query, (resultSet, i) -> new IntentRecord(
                resultSet.getInt("id"),
                resultSet.getString("category"),
                resultSet.getString("sub_category"),
                resultSet.getString("text")));
    }

    @Override
    public String getApiKey(String key) {
        List<String> apiKeys = jdbcTemplate.query("SELECT api_key FROM api_keys WHERE api_key = " + key, (resultSet, i) -> resultSet.getString("api_key"));
        return CollectionUtils.isEmpty(apiKeys) ? null : apiKeys.get(0);
    }
}
