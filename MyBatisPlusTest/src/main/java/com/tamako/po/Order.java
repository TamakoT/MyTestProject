package com.tamako.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
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
	private String sn;

	/**
	 * 运费, 包含在amount总价中
	 */
	private BigDecimal shipping_fee;

	/**
	 * 税费
	 */
	private BigDecimal tariff_fee;

	/**
	 * 订单实际支付的金额, 各类优惠折扣后需要支付rmb的金额
	 */
	private BigDecimal amount;

	/**
	 * 订单中物品总件数
	 */
	private Integer goods_count;

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
	private Integer pay_id;

	/**
	 * 收件人省, 索引字段
	 */
	private Integer shipping_province;

	/**
	 * 收件人市, 索引字段
	 */
	private Integer shipping_city;

	/**
	 * 收件人区, 索引字段
	 */
	private Integer shipping_district;

	/**
	 * 收件人详细地址, 不包含省市区
	 */
	private String shipping_address;

	/**
	 * 收件人姓名
	 */
	private String shipping_name;

	/**
	 * 收件人手机号码
	 */
	private String shipping_mobile;

	/**
	 * 订单活动/折扣前的原始总价, 数值上应该等于全部商品价格+运费
	 */
	private BigDecimal origin_amount;

	/**
	 * 收货人身份证号码
	 */
	private String shipping_idcard_no;

	/**
	 * 身份证图片,json数组{up:{},down:{}}[废弃]
	 */
	private String shipping_idcard_image;

	/**
	 * 订单物流单号[废弃]
	 */
	private String shipping_no;

	/**
	 * 发货备注
	 */
	private String shipping_note;

	/**
	 * 订单物流公司id, kr_express.id[废弃]
	 */
	private Integer express_id;

	/**
	 * 订单生成时间戳
	 */
	private Date created_at;

	/**
	 * 订单支付时间戳(status设置为2的时间)
	 */
	private Date paid_at;

	/**
	 * 订单发货时间戳(status设置为3的时间)
	 */
	private Date shipped_at;

	/**
	 * 订单确认收货时间戳(status设置为4的时间)
	 */
	private Date accepted_at;

	/**
	 * 订单超时关闭时间戳(status设置为5的时间)
	 */
	private Date closed_at;

	/**
	 * 订单完成时间戳(status设置为1的时间)
	 */
	private Date completed_at;

	/**
	 * 订单结算时间戳
	 */
	private Date counted_at;

	/**
	 * 订单修改时间戳
	 */
	private Date updated_at;

	/**
	 * 软删除标记
	 */
	private Date deleted_at;

	/**
	 * 订单备注
	 */
	private String remark;

	/**
	 * 品牌代理商id
	 */
	private Integer user_id;

	/**
	 * 是否推送到仓库，0未推送,1-推送成功,2-推送失败,3-推送中,4-申报失败,5-不可推送
	 */
	private Boolean is_push_warehouse;

	/**
	 *
	 */
	private String push_result;

	/**
	 * 仓库
	 */
	private Integer depot_id;

	/**
	 * 来自哪个用户分享，如果没有分享者，该字段就是下单本人[废弃]
	 */
	private Integer from_user_id;

	/**
	 * 平台:0-VTN
	 */
	private Boolean source;

	/**
	 * 订单结算状态，一为已经结算
	 */
	private Boolean balance_status;

	/**
	 * 用户优惠券 user_coupon.id
	 */
	private Integer user_coupon_id;

	/**
	 * 身份证姓名
	 */
	private String shipping_idcard_name;

	/**
	 * 订单类型:0-普通订单;3-拼团订单
	 */
	private Byte is_store;

	/**
	 * 订单类型：0-非奶粉订单,1-奶粉订单[需要特殊推送]
	 */
	private Byte is_milk;

	/**
	 * 同一批下单-订单编号
	 */
	private String order_no;

	/**
	 * 澳币支付汇率[废弃]
	 */
	private BigDecimal aud_rate;

	/**
	 * 版本控制，乐观锁
	 */
	private Integer control_version;

	/**
	 * 澳币实付金额[废弃]
	 */
	private BigDecimal aud_amount;

	/**
	 * 澳币实付运费[废弃]
	 */
	private BigDecimal aud_shipping_fee;

	/**
	 * 澳币实付税费[废弃]
	 */
	private BigDecimal aud_tariff_fee;

	/**
	 * 0-人民币支付,1-澳币支付[废弃]
	 */
	private Byte is_aud_pay;

	/**
	 * 是否开票:0-未开票，1-开票中，2-已开票[历史数据使用]
	 */
	private Byte is_billing;

	/**
	 * 开票时间
	 */
	private Date billing_time;

	/**
	 * 活动备注
	 */
	private String activity_remark;

	/**
	 * 是否售后 0-未提交;1-售后中;2-售后结束[废弃]
	 */
	private Byte sale_after;

	/**
	 * 清关状态 0：正常 2:复制了新的订单 4: 年度超额
	 */
	private Byte customs_status;

	/**
	 * 订单异常写入时间
	 */
	private Date abnormal_at;

	/**
	 * 国家 w_region.id
	 */
	private Integer shipping_country;

	/**
	 * 邮编
	 */
	private String shipping_zip_code;

	/**
	 * 升级等级:2-VIP;3-VVIP;4-SVIP;5-黑卡;其它-非升级订单
	 */
	private Byte upgrade_level;
}

