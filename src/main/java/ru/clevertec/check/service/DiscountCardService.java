package ru.clevertec.check.service;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.Dao.DiscountCardDAO;
import ru.clevertec.check.entity.DiscountCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class DiscountCardService {

    private final DiscountCardDAO discountCardDAO;


    public DiscountCard getDiscountCard(long id) {
        return discountCardDAO.getDiscountCard(id);
    }

    public void addDiscountCard(DiscountCard card) {
        discountCardDAO.addDiscountCard(card);
    }

    public void updateDiscountCard(DiscountCard card) {
        discountCardDAO.updateDiscountCard(card);
    }

    public void deleteDiscountCard(long id) {
        discountCardDAO.deleteDiscountCard(id);
    }

    public List<DiscountCard> getAllDiscountCards() {
        return discountCardDAO.getAllDiscountCards();
    }
}
