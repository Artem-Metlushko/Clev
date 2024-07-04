package ru.clevertec.check.service;

import ru.clevertec.check.Dao.DiscountCardDAO;
import ru.clevertec.check.entity.DiscountCard;

import java.util.List;

public class DiscountCardService implements Service {

    private final DiscountCardDAO discountCardDAO;

    public DiscountCardService(DiscountCardDAO discountCardDAO) {
        this.discountCardDAO = discountCardDAO;
    }


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
