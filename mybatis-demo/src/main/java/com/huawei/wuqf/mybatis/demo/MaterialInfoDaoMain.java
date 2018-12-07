package com.huawei.wuqf.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wuqf
 * @date 2018/12/6
 */
public class MaterialInfoDaoMain {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MaterialInfoDao materialInfoDao = sqlSession.getMapper(MaterialInfoDao.class);

        String result = selectNumCode(materialInfoDao, 12L, "code");
        System.out.println(result);
        sqlSession.close();
    }

    private static String selectNumCode(MaterialInfoDao materialInfoDao, Long mtId, String mtCode) {
        Integer exsits = materialInfoDao.selectMtSeqStatus(mtId);
        if (exsits != null || exsits == 1) {
            materialInfoDao.updateMtSeq(mtId);
        } else {
            materialInfoDao.insertMtSeq(mtId);
        }
        int seq = materialInfoDao.selectMtSeq(mtId);
        return contactSeq(mtCode, seq);
    }

    private static String contactSeq(String mtCode, int seq) {
        StringBuilder sb = new StringBuilder();
        sb.append(mtCode);
        sb.append(treateSeq(seq));
        return sb.toString();
    }

    private static String treateSeq(Integer seq) {
        String str = String.format("%04d", seq);
        return str;
    }
}
