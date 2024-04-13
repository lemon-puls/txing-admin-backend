package com.txing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动程序
 * 
 * @author lizhiwei
 */
@SpringBootApplication(scanBasePackages = "com.txing")
@MapperScan({"com.txing.**.mapper"})
//@ComponentScan(basePackages = "com.txing")
public class TxingApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(TxingApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  Txing编程启动成功");
    }
}
