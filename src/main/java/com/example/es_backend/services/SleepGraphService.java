package com.example.es_backend.services;

import com.example.es_backend.models.SleepData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@Service
public class SleepGraphService {
    // группирует список по 100 значений и находит максимум в каждой выборке
    public List<Float> groupData(List<Float> data) {
        List<Float> sums = new ArrayList<>();
        Iterator<Float> it = data.iterator();
        while (it.hasNext()) {
            float max = 0.0f;
            int count = 0;
            while (it.hasNext() && ++count < 100) {
                max = Math.max(it.next(), max);
            }
            sums.add(max);
        }
        return sums;
    }

    // преобразует список значений в фазу сна в моменте
    public List<Boolean> mapDataToIsHigh(List<Float> data) {
        return data.stream()
                .map(a -> (a > 0.01))
                .toList();
    }

    // расширяет быстрый сон
    public List<Boolean> shrinkData(List<Boolean> list) {
        List<Boolean> result = new ArrayList<>(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)) {
                if (i > 0) {
                    result.set(i - 1, true);
                }
//                if (i < list.size() - 1) {
//                    result.set(i + 1, true);
//                }
            }
        }
        return result;
    }


    public List<Boolean> getSleepGraphData(List<SleepData> sleepDataRaw) {
        List<Float> sleepData;
        if (sleepDataRaw.size() > 1000) {
            sleepData = groupData(sleepDataRaw.stream().map(SleepData::getData).toList());
        } else {
            sleepData = sleepDataRaw.stream().map(SleepData::getData).toList();
        }
        return shrinkData(mapDataToIsHigh(sleepData));
    }
}
