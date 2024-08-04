package net.perata.playground.mapper;

import com.opencsv.bean.AbstractBeanField;
import net.perata.playground.domain.Book;

import java.time.ZonedDateTime;

public class LocalDateConverter extends AbstractBeanField<Book, String> {

    @Override
    protected Object convert(String value) {
        return  ZonedDateTime.parse(value).toLocalDate();
    }
}
