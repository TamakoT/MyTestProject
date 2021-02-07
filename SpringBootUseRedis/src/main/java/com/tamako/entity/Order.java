package com.tamako.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Tamako
 */
@Data
//@TableName("w_order_copy1")
@TableName("w_order")
public class Order {
	/**
	 * id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	/**
	 * 订单编号, 格式 年{2}月{2}日{2}时{2}分{2}秒{2}随机数字{6}
	 */
	@TableField("sn")
	private String sn;

	/**
	 * 运费, 包含在amount总价中
	 */
	private BigDecimal shippingFee;

	/**
	 * 税费
	 */
	private BigDecimal tariffFee;

	/**
	 * 订单实际支付的金额, 各类优惠折扣后需要支付rmb的金额
	 */
	private BigDecimal amount;

	/**
	 * 订单中物品总件数
	 */
	private Integer goodsCount;

	/**
	 * 订单状态, -1.订单取消,0.待付款,1.已完成,2.已付款/待发货,3.已发货/待收货,4.已确认收货,5.已超时关闭
	 */
	private Integer status;

	/**
	 * 订单来源:0-APP客户端;1-微信小程序;2-后台导单;3-微信商城;4-系统订单;5-售后补发
	 */
	private Byte env;

	/**
	 * 订单支付号 kr_order_pay.id
	 */
	private Integer payId;

	/**
	 * 收件人省, 索引字段
	 */
	private Integer shippingProvince;

	/**
	 * 收件人市, 索引字段
	 */
	private Integer shippingCity;

	/**
	 * 收件人区, 索引字段
	 */
	private Integer shippingDistrict;

	/**
	 * 收件人详细地址, 不包含省市区
	 */
	private String shippingAddress;

	/**
	 * 收件人姓名
	 */
	private String shippingName;

	/**
	 * 收件人手机号码
	 */
	private String shippingMobile;

	/**
	 * 订单活动/折扣前的原始总价, 数值上应该等于全部商品价格+运费
	 */
	private BigDecimal originAmount;

	/**
	 * 收货人身份证号码
	 */
	private String shippingIdcardNo;

	/**
	 * 身份证图片,json数组{up:{},down:{}}[废弃]
	 */
	private String shippingIdcardImage;

	/**
	 * 订单物流单号[废弃]
	 */
	private String shippingNo;

	/**
	 * 发货备注
	 */
	private String shippingNote;

	/**
	 * 订单物流公司id, kr_express.id[废弃]
	 */
	private Integer expressId;

	/**
	 * 订单生成时间戳
	 */
	private Date createdAt;

	/**
	 * 订单支付时间戳(status设置为2的时间)
	 */
	private Date paidAt;

	/**
	 * 订单发货时间戳(status设置为3的时间)
	 */
	private Date shippedAt;

	/**
	 * 订单确认收货时间戳(status设置为4的时间)
	 */
	private Date acceptedAt;

	/**
	 * 订单超时关闭时间戳(status设置为5的时间)
	 */
	private Date closedAt;

	/**
	 * 订单完成时间戳(status设置为1的时间)
	 */
	private Date completedAt;

	/**
	 * 订单结算时间戳
	 */
	private Date countedAt;

	/**
	 * 订单修改时间戳
	 */
	private Date updatedAt;

	/**
	 * 软删除标记
	 */
	private Date deletedAt;

	/**
	 * 订单备注
	 */
	private String remark;

	/**
	 * 品牌代理商id
	 */
	private Integer userId;

	/**
	 * 是否推送到仓库，0未推送,1-推送成功,2-推送失败,3-推送中,4-申报失败,5-不可推送
	 */
	private Boolean isPushWarehouse;

	/**
	 *
	 */
	private String pushResult;

	/**
	 * 仓库
	 */
	private Integer depotId;

	/**
	 * 来自哪个用户分享，如果没有分享者，该字段就是下单本人[废弃]
	 */
	private Integer fromUserId;

	/**
	 * 平台:0-VTN
	 */
	private Boolean source;

	/**
	 * 订单结算状态，一为已经结算
	 */
	private Boolean balanceStatus;

	/**
	 * 用户优惠券 user_coupon.id
	 */
	private Integer userCouponId;

	/**
	 * 身份证姓名
	 */
	private String shippingIdcardName;

	/**
	 * 订单类型:0-普通订单;3-拼团订单
	 */
	private Byte isStore;

	/**
	 * 订单类型：0-非奶粉订单,1-奶粉订单[需要特殊推送]
	 */
	private Byte isMilk;

	/**
	 * 同一批下单-订单编号
	 */
	private String orderNo;

	/**
	 * 澳币支付汇率[废弃]
	 */
	private BigDecimal audRate;

	/**
	 * 版本控制，乐观锁
	 */
	private Integer controlVersion;

	/**
	 * 澳币实付金额[废弃]
	 */
	private BigDecimal audAmount;

	/**
	 * 澳币实付运费[废弃]
	 */
	private BigDecimal audShippingFee;

	/**
	 * 澳币实付税费[废弃]
	 */
	private BigDecimal audTariffFee;

	/**
	 * 0-人民币支付,1-澳币支付[废弃]
	 */
	private Byte isAudPay;

	/**
	 * 是否开票:0-未开票，1-开票中，2-已开票[历史数据使用]
	 */
	private Byte isBilling;

	/**
	 * 开票时间
	 */
	private Date billingTime;

	/**
	 * 活动备注
	 */
	private String activityRemark;

	/**
	 * 是否售后 0-未提交;1-售后中;2-售后结束[废弃]
	 */
	private Byte saleAfter;

	/**
	 * 清关状态 0：正常 2:复制了新的订单 4: 年度超额
	 */
	private Byte customsStatus;

	/**
	 * 订单异常写入时间
	 */
	private Date abnormalAt;

	/**
	 * 国家 w_region.id
	 */
	private Integer shippingCountry;

	/**
	 * 邮编
	 */
	private String shippingZipCode;

	/**
	 * 升级等级:2-VIP;3-VVIP;4-SVIP;5-黑卡;其它-非升级订单
	 */
	private Byte upgradeLevel;
}

