package com.itrust.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * mybatis工具类，生成SqlSessionFactory
 * @author yanghang
 *
 */
public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory = null;  
    
    static {  
        try {  
            InputStream is = Resources.getResourceAsStream("mybatis.xml");  
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
          
    }  
      
    public static SqlSessionFactory getSqlSessionFactory() {  
        return sqlSessionFactory;  
    }  
}
