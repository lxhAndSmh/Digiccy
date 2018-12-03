package com.botpy.digiccy;


import com.botpy.digiccy.app.DigiccyApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@Config(application = DigiccyApplication.class)
@RunWith(RobolectricTestRunner.class)
public class SampleTest {
    @Test
    public void testMainActivity(){
        String s = "demo";
        Assert.assertNotNull(s);

    }
}
