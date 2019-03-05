package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.MergeHelper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultMergeServiceTest {

    @Mock
    private MergeHelper mergeHelper;

    @InjectMocks
    private DefaultMergeService mergeService;

    @Before
    public void before() {
        reset(mergeHelper);
    }

    @Test
    public void merge() throws Exception {
        Object val1 = new Object();
        Object val2 = new Object();
        Object result = new Object();
        when(mergeHelper.mergeObjects(val1, val2)).thenReturn(result);
        Object functionResult = mergeService.merge(val1, val2);
        assertEquals(result, functionResult);
    }

    @Test
    public void mergeList() throws Exception {
        Object obj1 = new Object();
        Object obj2 = new Object();
        Object obj3 = new Object();
        Object result1 = new Object();
        Object result2 = new Object();
        when(mergeHelper.mergeObjects(obj1, obj2)).thenReturn(result1);
        when(mergeHelper.mergeObjects(result1, obj3)).thenReturn(result2);
        List<Object> toMerge = Lists.newArrayList(obj1, obj2, obj3);
        Object result = mergeService.merge(toMerge);
        assertEquals(result2, result);
    }

    @Test
    public void groupByCode() {
        String code1 = "code1";
        String code2 = "code2";
        BaseData data1 = new BaseData();
        data1.setCode(code1);
        BaseData data2 = new BaseData();
        data2.setCode(code1);
        BaseData data3 = new BaseData();
        data3.setCode(code2);
        List<BaseData> toGroup = Lists.newArrayList(data1, data2, data3);
        Map<String, List<BaseData>> result = mergeService.groupByCode(toGroup);
        assertTrue(result.containsKey(code1));
        assertTrue(result.containsKey(code2));
        assertEquals(2, result.get(code1).size());
        assertEquals(1, result.get(code2).size());
    }

}
