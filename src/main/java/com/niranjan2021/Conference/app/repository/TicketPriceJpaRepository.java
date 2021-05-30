package com.niranjan2021.Conference.app.repository;

import com.niranjan2021.Conference.app.models.TicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface TicketPriceJpaRepository extends JpaRepository <TicketPrice,Long>{


    @Query(
            "select tp from TicketPrice tp where tp.basePrice < ?1 " +
                    "and tp.ticketType.includesWorkshop= true"
    )
    List <TicketPrice> getTicketsUnderPriceWithWorkshops(BigDecimal maxPrice);
}
