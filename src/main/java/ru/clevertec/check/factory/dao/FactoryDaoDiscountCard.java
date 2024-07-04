package ru.clevertec.check.factory.dao;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.Dao.Dao;
import ru.clevertec.check.Dao.DiscountCardDAO;
import ru.clevertec.check.entity.DiscountCard;


import java.util.Map;

@RequiredArgsConstructor
public class FactoryDaoDiscountCard extends FactoryDaoAbstract {
    private final Map<Long, DiscountCard> discountCardMap;

    @Override
    public Dao createDao() {
        return new DiscountCardDAO(discountCardMap);
    }
}
