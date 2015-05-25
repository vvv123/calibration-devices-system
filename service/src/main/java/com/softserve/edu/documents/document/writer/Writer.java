package com.softserve.edu.documents.document.writer;

import com.softserve.edu.documents.document.Document;
import com.softserve.edu.documents.document.meta.Column;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Writer {
    public Map<String, String> getColumnsNamesValues(Document document)
            throws IOException {
        Method[] documentMethods = document.getClass().getMethods();

        Map<String, String> columnMap = new HashMap<>();

        for (Method method : documentMethods) {
            Column column = method.getAnnotation(Column.class);

            if (column == null) {
                continue;
            }

            String columnName = column.name();
            // TODO add checks for repeated column columnName

            String columnValue = null;
            Class<?> returnType = method.getReturnType();

            if (returnType.equals(String.class)) {
                try {
                    columnValue = (String) method.invoke(document);
                } catch (IllegalAccessException |
                        InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            columnMap.put(columnName, columnValue);
        }

        return columnMap;
    }
}
