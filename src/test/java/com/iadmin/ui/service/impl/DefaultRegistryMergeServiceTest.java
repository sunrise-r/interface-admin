package com.iadmin.ui.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.BaseData;
import com.iadmin.ui.service.MergeService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRegistryMergeServiceTest {

    @Mock
    MergeService mergeService;
    @InjectMocks
    private DefaultRegistryMergeService defaultRegistryMergeService;

    @Before
    public void before() {
        reset(mergeService);
    }

    @Test
    public void merge() throws Exception {
        Object val1 = new Object();
        Object val2 = new Object();
        Object result = new Object();
        when(mergeService.merge(val1, val2)).thenReturn(result);
        Object functionResult = defaultRegistryMergeService.merge(val1, val2);
        assertEquals(result, functionResult);
    }

    @Test
    public void mergeList() throws Exception {
        List<Object> toMerge = Lists.newArrayList();
        defaultRegistryMergeService.merge(toMerge);
        verify(mergeService).merge(toMerge);
    }

    @Test
    public void mergeListAndObject() throws MergeException {
        List<Object> toMerge = Lists.newArrayList();
        Object obj1 = new Object();
        Object expectedResult = new Object();
        when(mergeService.merge(Mockito.anyList())).thenAnswer(invocation -> {
            List<Object> arg = (List<Object>) invocation.getArguments()[0];
            assertEquals(1, arg.size());
            return expectedResult;
        });
        Object result = defaultRegistryMergeService.merge(obj1, toMerge);
        assertEquals(expectedResult, result);
    }

    @Test
    public void mergeByCode() throws Exception {
        List<BaseData> models = Lists.newArrayList();
        Map<String, List<BaseData>> map = Maps.newHashMap();
        String code1 = "code1";
        String code2 = "code2";
        BaseData result1 = new BaseData();
        BaseData result2 = new BaseData();
        result1.setCode(code1);
        result2.setCode(code2);
        List<BaseData> list1 = Lists.newArrayList(result1);
        List<BaseData> list2 = Lists.newArrayList(result2);
        map.put(code1, list1);
        map.put(code2, list2);
        when(mergeService.groupByCode(models)).thenReturn(map);
        when(mergeService.merge(eq(list1))).thenReturn(result1);
        when(mergeService.merge(eq(list2))).thenReturn(result2);
        List<BaseData> result = defaultRegistryMergeService.mergeByCode(models);
        assertEquals(2, result.size());
        assertTrue(result.contains(result1));
        assertTrue(result.contains(result2));
    }

}
