package ru.clevertec.check.Dao;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.entity.DiscountCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class DiscountCardDAO {

    private final Map<Long, DiscountCard> discountCardMap;


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

