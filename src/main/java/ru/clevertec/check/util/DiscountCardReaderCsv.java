package ru.clevertec.check.util;

import lombok.RequiredArgsConstructor;
import ru.clevertec.check.entity.DiscountCard;
import ru.clevertec.check.entity.Product;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;


@RequiredArgsConstructor
public class DiscountCardReaderCsv {

    private final Map<Long, DiscountCard> discountCardMap ;

    public void loadDiscountCards(String filePath) {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");

                long id = Long.parseLong(values[0]);
                String number = values[1];
                int discountAmount = Integer.parseInt(values[2]);

                DiscountCard discountCard = getDiscountCard(id, number, discountAmount);
                discountCardMap.put(id,discountCard);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private DiscountCard getDiscountCard(long id, String number, int discountAmount) {
        return DiscountCard.builder()
                .id(id)
                .number(number)
                .discountAmount(discountAmount)
                .build();
    }
}
