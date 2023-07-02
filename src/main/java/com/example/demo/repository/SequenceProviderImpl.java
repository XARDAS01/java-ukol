package com.example.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class SequenceProviderImpl implements SequenceProvider {

    private final static String QUERY = "select nextval('account_sequence')";

    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(readOnly = true)
    public String next() {
        return (jdbcTemplate.queryForObject(QUERY, String.class));
    }
}
