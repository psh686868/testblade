package com.copyblade.exception;

import org.junit.Assert;
import org.junit.Test;

/**
 * Create by psh
 * Date: 2017/11/15
 */
public class BladeExceptionTest {

    @Test
    public void testBladeException () {
        try {
            throw new BadRequestException("Bad Requset Exception");
        } catch (BladeException e) {
            Assert.assertEquals(e.getStatus(),400);
        }

        try {
            throw new InternalErrorException("Bad Requset Exception");
        } catch (BladeException e) {
            Assert.assertEquals(e.getStatus(),500);
        }


    }
}
