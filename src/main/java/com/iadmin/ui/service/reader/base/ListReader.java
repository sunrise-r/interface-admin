package com.iadmin.ui.service.reader.base;

import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.ReaderServiceData;

import java.io.IOException;
import java.util.List;

public abstract class  ListReader<T extends BaseData> extends UIReader<List<T>> {

    public ListReader(ReaderServiceData readerServiceData) {
        super(readerServiceData);
    }

    public List<T> read() throws IOException, MergeException {
        List<T> models = find();
        models = registryMergeService.mergeByCode(models);
        for (int i = 0; i < models.size(); i++) {
            T p = models.get(i);
            p = getSingleReader(p).read();
            models.set(i, p);
        }
        return models;
    }

    /**
     * Предоставляет объкт чтения экземпляра объекта T
     * @param source исходные данные объекта.
     * @return
     */
    protected abstract UIReader<T> getSingleReader(T source);

    /**
     * Найти все доступные экземпляры объектов
     * @return Список найденных объектов
     */
    protected abstract List<T> find();
}

