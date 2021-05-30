package com.niranjan2021.Conference.app.models;


import com.niranjan2021.Conference.app.repository.TicketPriceJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TicketPriceTest {


@Autowired
    public TicketPriceJpaRepository ticketPriceJpaRepository;



@Test
public  void testTicketPrice(){

    List<TicketPrice> ticketUnderPriceWithWorkshops = ticketPriceJpaRepository.getTicketsUnderPriceWithWorkshops(BigDecimal.valueOf(100));

    assertFalse(ticketUnderPriceWithWorkshops.size()>0);

}
}
