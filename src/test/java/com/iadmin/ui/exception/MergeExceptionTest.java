package com.iadmin.ui.exception;

import com.iadmin.ui.model.BaseData;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeExceptionTest {

    @Test
    public void getMessage() {
        BaseData one = new BaseData();
        one.setCode("one");
        BaseData two = new BaseData();
        two.setCode("two");
        MergeException mergeException = new MergeException(one, two, new Exception());
        String result = String.format("Failed to merge objects one=%s ans two=%s", one, two);
        assertEquals(result, mergeException.getMessage());
    }

}
