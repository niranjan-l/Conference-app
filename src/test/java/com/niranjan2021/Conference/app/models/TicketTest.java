package com.niranjan2021.Conference.app.models;


import com.niranjan2021.Conference.app.repository.PricingCategoryRepository;
import com.niranjan2021.Conference.app.repository.TicketPriceRepository;
import com.niranjan2021.Conference.app.repository.TicketTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TicketTest {

    @Autowired
    private TicketPriceRepository repository;

    @Autowired
    private PricingCategoryRepository pcRepository;

    @Autowired
    private TicketTypeRepository ttRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
        TicketPrice ticket = repository.find(1L);
        assertNotNull(ticket);
    }

    @Test
    @Transactional
    public void testSaveAndGetAndDelete() throws Exception {
        TicketPrice tp = new TicketPrice();
        tp.setBasePrice(BigDecimal.valueOf(200, 2));

        tp.setPricingCategory(pcRepository.find("E"));

        tp.setTicketType(ttRepository.find("C"));

        tp = repository.create(tp);

        // clear the persistence context so we don't return the previously cached location object
        // this is a test only thing and normally doesn't need to be done in prod code
        entityManager.clear();

        TicketPrice otherTp = repository.find(tp.getTicketPriceId());
        assertEquals(BigDecimal.valueOf(200, 2), otherTp.getBasePrice());

        repository.delete(otherTp.getTicketPriceId());
    }

}
