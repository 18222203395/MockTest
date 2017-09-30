package com.alen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by y64195 on 2017/9/30.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(Configuration.class)
public class TestClass {

    @Before
    public void setUp() throws Exception {
        Whitebox.setInternalState(Configuration.class, "enabled", (Object) null);
    }

    @Test
    public void shouldReturnSumIfEnabled() throws Exception {
        mockStatic(Configuration.class);

        Properties properties = new Properties();
        properties.put("enabled", "true");

        //以下Mock对象为静态方法
        doReturn(properties).when(Configuration.class, "readProperties");
        doCallRealMethod().when(Configuration.class, "isEnabled");
        doCallRealMethod().when(Configuration.class, "loadProperties");

        assertThat(new ClassTest().add(1, 5)).isEqualTo(6);
    }

    @Test
    public void shouldReturnZero() throws Exception {
        mockStatic(Configuration.class);

        Properties properties = new Properties();
        properties.put("enabled","false");

        doReturn(properties).when(Configuration.class,"readProperties");
        doCallRealMethod().when(Configuration.class,"loadProperties");
        doCallRealMethod().when(Configuration.class,"isEnabled");

        assertThat(new ClassTest().add(1,5)).isEqualTo(0);
    }
}
