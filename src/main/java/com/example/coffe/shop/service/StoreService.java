package com.example.coffe.shop.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.coffe.shop.dao.StoreDao;
import com.example.coffe.shop.dto.StoreDto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreDao storeDao;

    public List<StoreDto> findAll() {
        return storeDao.findAll();
    }


    public void insertStoreList(String resourcePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new RuntimeException(resourcePath + " 파일을 찾을 수 없습니다.");
            }

            try (CSVReader csvReader = new CSVReaderBuilder(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .withSkipLines(1)  // 헤더 스킵
                    .build()) {

                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    StoreDto store = new StoreDto();

                    store.setStoreName(line[0]);
                    store.setX(parseFloatSafe(line[1]));
                    store.setY(parseFloatSafe(line[2]));
                    store.setStoreType(line[3]);
                    store.setStoreAddr(line[4]);       

                    storeDao.insertStoreList(store);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private int parseIntSafe(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private float parseFloatSafe(String str) {
        try {
            return Float.parseFloat(str.trim());
        } catch (Exception e) {
            return 0.0f;
        }
    }
}
