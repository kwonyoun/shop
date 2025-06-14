package com.example.coffe.shop.service;

import com.example.coffe.shop.dao.MenuDao;
import com.example.coffe.shop.dto.MenuDto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuDao menuDao;

    public List<MenuDto> findAll() {
        return menuDao.findAll();
    }

    public void insertFromCsv(String resourcePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new RuntimeException(resourcePath + " 파일을 찾을 수 없습니다.");
            }
            try (CSVReader csvReader = new CSVReaderBuilder(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .withSkipLines(1)
                    .build()) {

                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    MenuDto menu = new MenuDto();
                    menu.setProdCode(line[0]);
                    menu.setName(line[1]);
                    menu.setEngName(line[2]);
                    menu.setDescription(line[3]);
                    menu.setImageUrl(line[4]);
                    menu.setVolume(line[5]);
                    menu.setCalorie(line[6]);
                    menu.setSaturatedFat(line[7]);
                    menu.setProtein(line[8]);
                    menu.setSodium(line[9]);
                    menu.setSugar(line[10]);
                    menu.setCaffeine(line[11]);
                    menu.setAllergy(line[12]);

                    menuDao.insertMenu(menu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
