package com.magic.ruoyiapi.domain;

import java.io.Serializable;

/**
 *
 * @author S
 * @date 2017/6/9
 */
public class BaseModel implements Serializable {
    /**
     * 总记录数
     */
    private long recordCount =0;
    /**
     * 当前是第几页，从1开始记数
     */
    private int pageNo = 1;
    /**
     * 每页多少条
     */
    private int pageSize = 10;
    /**
     * 1-前端 2-后台
      */
    private int plateFormType = 2;

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPlateFormType() {
        return plateFormType;
    }

    public void setPlateFormType(int plateFormType) {
        this.plateFormType = plateFormType;
    }
}
