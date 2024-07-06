package ru.clevertec.check.dao;

import ru.clevertec.check.entity.DiscountCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiscountCardDAO implements Dao {

    private final Map<Long, DiscountCard> discountCardMap;

    public DiscountCardDAO(Map<Long, DiscountCard> discountCardMap) {
        this.discountCardMap = discountCardMap;
    }


    public DiscountCard getDiscountCard(long id) {
        return discountCardMap.get(id);
    }

    public void addDiscountCard(DiscountCard card) {
        discountCardMap.put(card.getId(), card);
    }

    public void updateDiscountCard(DiscountCard card) {
        discountCardMap.put(card.getId(), card);
    }

    public void deleteDiscountCard(long id) {
        discountCardMap.remove(id);
    }

    public List<DiscountCard> getAllDiscountCards() {
        return new ArrayList<>(discountCardMap.values());
    }
}

