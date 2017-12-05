package com.wangwang.mybatisfirst;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLogger {
 
	@Test
	public void testLog(){
		 Logger logger=Logger.getLogger(TestLogger.class);
		 logger.info("单元测试调用info");
		 logger.debug("这是调试级别输出的信息");
		 logger.error("这是错误输出的信息");
		 logger.trace("信息堆栈");
		 logger.fatal("致命错误输出");
		 logger.info("log level:"+logger.getLevel());
	}
	
	
}
