package org.example.dao;

import org.example.entity.Drugs;
import org.example.util.CsvReader;

import java.util.List;

public class CsvParser {

    public static List<Drugs> loadInventory() {
        return CsvReader.getDrugs();
    }

}