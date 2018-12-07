package com.huawei.wuqf.mybatis.demo;

import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MaterialInfoDao {

    Integer selectMtSeqStatus(@Param("mtId") Long mtId);

    Integer updateMtSeq(@Param("mtId") Long mtId);

    void insertMtSeq(@Param("mtId") Long mtId);

    int selectMtSeq(@Param("mtId") Long mtId);
}
