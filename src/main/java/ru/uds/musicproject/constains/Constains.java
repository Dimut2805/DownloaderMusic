package ru.uds.musicproject.constains;

import java.util.HashMap;

public interface Constains {
    HashMap<String, String> HASH_MAP_SECTIONS = new HashMap<String, String>() {
        {
            put("Не выбрано", null);
            put("Топ-100", "https://muzika.vip");
            put("Billie Eilish", "https://muzika.vip/m-artists/billie-eilish-121989");
            put("Григорий Лепс", "https://muzika.vip/m-artists/григорий-лепс-6298");
            put("Группа Кино", "https://muzika.vip/m-artists/виктор-цой-6257");
            put("Макс Корж", "https://muzika.vip/m-artists/макс-корж-9229");
            put("Lindsey Stirling", "https://muzika.vip/m-artists/lindsey-stirling-10942");
        }
    };
}