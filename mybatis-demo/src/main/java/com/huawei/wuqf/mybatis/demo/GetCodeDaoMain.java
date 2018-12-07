package com.huawei.wuqf.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuqf
 * @date 2018/12/6
 */
public class GetCodeDaoMain {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        GetCodeDao getCodeDao = sqlSession.getMapper(GetCodeDao.class);


        int type = 1;
        String preStr = "xxxxx";
        Long storeId = 123L;

        String result = generateCode(getCodeDao, type, preStr, storeId);
        System.out.println(result);
    }

    public static String generateCode(GetCodeDao getCodeDao, Integer type, String preStr, Long storeId) {
        Integer status = getCodeDao.isRecordToday(type);
        if (status == 1) {
            getCodeDao.updateTodaySequenceCode(type);
        } else {
            getCodeDao.updateOldSequenceCode(type);
        }
        Integer sequence = getCodeDao.selectSequence(type);
        String result = contactString(preStr, type, storeId, sequence);
        return result;
    }

    private static String treateStoreId(Long storeId) {
        String str = String.format("%04d", storeId);
        return str;
    }

    private static String treateSeq(Integer seq) {
        String str = String.format("%05d", seq);
        return str;
    }

    private static String contactString(String preStr, Integer type, Long storeId, Integer sequence) {
        StringBuilder sb = new StringBuilder();
        sb.append(preStr);
        sb.append(getDateTime(type));
        sb.append(treateStoreId(storeId));
        sb.append(treateSeq(sequence));
        return sb.toString();
    }

    private static String getDateTime(Integer type) {
        SimpleDateFormat formatter = null;
        if (type == 1) {
            formatter = new SimpleDateFormat("yyMMddHHmm");
        } else {
            formatter = new SimpleDateFormat("yyMMdd");
        }
        return formatter.format(new Date());
    }
}
