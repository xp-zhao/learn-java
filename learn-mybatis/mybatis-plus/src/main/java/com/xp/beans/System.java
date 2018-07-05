package com.xp.beans;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统
 * </p>
 *
 * @author xp-zhao
 * @since 2018-07-05
 */
@TableName("upms_system")
public class System extends Model<System> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "system_id", type = IdType.AUTO)
    private Integer systemId;
    /**
     * 根目录
     */
    private String basepath;
    /**
     * 状态(-1:黑名单,1:正常)
     */
    private Integer status;
    /**
     * 系统名称
     */
    private String name;
    /**
     * 系统标题
     */
    private String title;
    /**
     * 系统描述
     */
    private String description;
    /**
     * 创建时间
     */
    private Long ctime;
    /**
     * 排序
     */
    private Long orders;


    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public String getBasepath() {
        return basepath;
    }

    public void setBasepath(String basepath) {
        this.basepath = basepath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    @Override
    protected Serializable pkVal() {
        return this.systemId;
    }

    @Override
    public String toString() {
        return "System{" +
        ", systemId=" + systemId +
        ", basepath=" + basepath +
        ", status=" + status +
        ", name=" + name +
        ", title=" + title +
        ", description=" + description +
        ", ctime=" + ctime +
        ", orders=" + orders +
        "}";
    }
}
