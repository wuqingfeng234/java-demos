package com.huawei.wuqf.mybatis.demo;

import org.apache.ibatis.annotations.Param;

public interface GetCodeDao {
    Integer isRecordToday(@Param("type") Integer type);

    void updateTodaySequenceCode(@Param("type") Integer type);

    void updateOldSequenceCode(@Param("type") Integer type);

    Integer selectSequence(@Param("type") Integer type);
}
