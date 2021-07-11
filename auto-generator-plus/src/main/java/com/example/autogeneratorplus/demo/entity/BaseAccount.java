package com.example.autogeneratorplus.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 基础账户
 * </p>
 *
 * @author luolita
 * @since 2021-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tb_base_account")
public class BaseAccount extends Model<BaseAccount> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 货币ID
     */
    private Integer currencyId;

    /**
     * 可用金额
     */
    private BigDecimal availableAmount;

    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount;

    private Date createTime;

    private Date updateTime;


    public static final String ID = "id";

    public static final String USER_ID = "user_id";

    public static final String CURRENCY_ID = "currency_id";

    public static final String AVAILABLE_AMOUNT = "available_amount";

    public static final String FROZEN_AMOUNT = "frozen_amount";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
