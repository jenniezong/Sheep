package com.nan.netty.study.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import org.msgpack.annotation.Message;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 描述：</b>股票交易实时行情表<br>
 * @author：系统生成
 * @version:1.0
 */
@Message
public class StockRealtime {
	private static final long serialVersionUID = 1L;
	
	/**
	 *股票实时数据的id
	 */
	@JSONField(serialize = false)
	private Integer id;
	/**
	 *股票代码
	 */
	private String code;
	/**
	 *股票名称
	 */
	private String name;
	/**
	 *昨日收盘价
	 */
	private BigDecimal yesClose;
	/**
	 *今日开盘价
	 */
	private BigDecimal todOpen;
	/**
	 *今日最高价
	 */
	private BigDecimal todHigh;
	/**
	 *今日最低价
	 */
	private BigDecimal todLow;
	/**
	 *当前价
	 */
	private BigDecimal current;
	/**
	 *市盈率1
	 */
	@JSONField(serialize = false)
	private BigDecimal profitRate1;
	/**
	 *市盈率2
	 */
	@JSONField(serialize = false)
	private BigDecimal profitRate2;
	/**
	 *成交额
	 */
	private BigDecimal tempAmount;
	/**
	 *成交笔数
	 */
	@JSONField(serialize = false)
	private BigDecimal tempBi;
	/**
	 *成交量
	 */
	private BigDecimal tempVolume;
	/**
	 *涨跌额1
	 */
	private BigDecimal change1;
	/**
	 *跌额涨2
	 */
	//@JSONField(serialize = false)
	private BigDecimal change2;
	/**
	 *约合持仓量
	 */
	//@JSONField(serialize = false)
	private BigDecimal contractHold;
	/**
	 *当前买入价
	 */
	private BigDecimal currentBuy;
	/**
	 *当前卖出价
	 */
	private BigDecimal currentSold;
	/**
	 *申买量一
	 */
	private BigDecimal applyBuyVol1;
	/**
	 *申买价二
	 */
	private BigDecimal applyBuyPri2;
	/**
	 *申买量二
	 */
	private BigDecimal applyBuyVol2;
	/**
	 *申买价三
	 */
	private BigDecimal applyBuyPri3;
	/**
	 *申买量三
	 */
	private BigDecimal applyBuyVol3;
	/**
	 *申卖量1
	 */
	private BigDecimal applySoldVol1;
	/**
	 *申卖价2
	 */
	private BigDecimal applySoldPri2;
	/**
	 *申卖量2
	 */
	private BigDecimal applySoldVol2;
	/**
	 *申卖价3
	 */
	private BigDecimal applySoldPri3;
	/**
	 *申卖量3
	 */
	private BigDecimal applySoldVol3;
	/**
	 *申买价4
	 */
	private BigDecimal applyBuyPri4;
	/**
	 *申买量4
	 */
	private BigDecimal applyBuyVol4;
	/**
	 *申买价5
	 */
	private BigDecimal applyBuyPri5;
	/**
	 *申买量5
	 */
	private BigDecimal applyBuyVol5;
	/**
	 *申卖价四
	 */
	private BigDecimal applySoldPri4;
	/**
	 *申卖量4
	 */
	private BigDecimal applySoldVol4;
	/**
	 *申卖价5
	 */
	private BigDecimal applySoldPri5;
	/**
	 *申卖量5
	 */
	private BigDecimal applySoldVol5;
	/**
	 *实时交易时间
	 */
	private Date time;
	/**
	 *股票所属的市场，0，沪深，1港股，2美股
	 */
	//@JSONField(serialize = false)
	private Integer market;
	/**
	 *股票所属的行业的id
	 */
	@JSONField(serialize = false)
	private Integer industryId;
	/**
	 *股票所属的行业名
	 */
	@JSONField(serialize = false)
	private String industryName;
	/**
	 *涨跌幅1
	 */
	private BigDecimal change1Range;
	/**
	 *涨跌幅2
	 */
	@JSONField(serialize = false)
	private BigDecimal change2Range;
	/**
	 *今日累计成交量
	 */
	//@JSONField(serialize = false)
	private BigDecimal todTotalVolume;
	/**
	 *当日累计成交额
	 */
	//@JSONField(serialize = false)
	private BigDecimal todTotalAmount;
	/**
	 *换手率
	 */
	//@JSONField(serialize = false)
	private BigDecimal handRate;
	/**
	 *持有人数
	 */
	@JSONField(serialize = false)
	private Integer userHold;
	/**
	 *均价
	 */
	@JSONField(serialize = false)
	private BigDecimal average;
	/**
	 *52周最高
	 */
	@JSONField(serialize = false)
	private BigDecimal week52Max;
	/**
	 *52周最低
	 */
	@JSONField(serialize = false)
	private BigDecimal week52Min;
	/**
	 *30日均成交量
	 */
	@JSONField(serialize = false)
	private BigDecimal average30Volume;
	/**
	 *发行总量（总股本）
	 */
	//@JSONField(serialize = false)
	private BigDecimal totalVolume;
	/**
	 *流通股数
	 */
	//@JSONField(serialize = false)
	private BigDecimal currencyNum;
	/**
	 *境内流通股本
	 */
	private BigDecimal insideCirculate;
	/**
	 *境外流通股本
	 */
	@JSONField(serialize = false)
	private BigDecimal outsideCirculate;
	/**
	 *市盈率（实时计算）
	 */
	private BigDecimal profitRate;
	/**
	 *总市值(实时计算)
	 */
	//@JSONField(serialize = false)
	private BigDecimal stockValue;
	/**
	 *每股净资产
	 */
	@JSONField(serialize = false)
	private BigDecimal value;
	/**
	 *净资产收益率
	 */
	@JSONField(serialize = false)
	private BigDecimal earnYield;
	/**
	 *委比
	 */
	//@JSONField(serialize = false)
	private BigDecimal weibi;
	/**
	 *量比
	 */
	//@JSONField(serialize = false)
	private BigDecimal volumeRatio;
	/**
	 *现手
	 */
	@JSONField(serialize = false)
	private BigDecimal currentHand;
	/**
	 *总手
	 */
	@JSONField(serialize = false)
	private BigDecimal totalHand;
	/**
	 *内盘
	 */
	@JSONField(serialize = false)
	private BigDecimal innerPan;
	/**
	 *外盘
	 */
	@JSONField(serialize = false)
	private BigDecimal outerPan;
	
	/**
	 * 雪球行业的id
	 */
	@JSONField(serialize = false)
	private Integer xueqiuIndustryId;
	/**
	 * 雪球行业名称
	 */
	@JSONField(serialize = false)
	private String xueqiuIndustryName;
	
	/**
	 *公司简介
	 */
	@JSONField(serialize = false)
	private String brief;
	/**
	 *公司简介CRC校验码
	 */
	@JSONField(serialize = false)
	private Integer briefCrc;
	/**
	 *公司业务
	 */
	@JSONField(serialize = false)
	private String business;
	/**
	 *公司业务的CRC校验码
	 */
	@JSONField(serialize = false)
	private Integer businessCrc;
	
	/**
	 * 仅作展示用，不做db存储：涨速
	 */
	private BigDecimal riseSpeed;
	
	/**
	 * 仅作展示用，不做db存储:股票的拼音，沪深的同stock.enNameShort
	 */
	private String pinYin;
	
	/**
	 * 仅作展示用，不做db存储：关联的板块id
	 */
	private String[] block;

	public String[] getBlock() {
		return block;
	}

	public void setBlock(String[] block) {
		this.block = block;
	}

	public StockRealtime clone() {
		try {
			return (StockRealtime)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 *交易状态
	 */
	private Integer tradeType;
	public Integer getTradeType() {
		return tradeType;
	}

	public void setTradeType(Integer tradeType) {
		this.tradeType = tradeType;
	}

	/**
	 *获取股票实时数据的id
	 */
	public Integer getId(){
		return this.id;
	}
	
	/**
	 *设置股票实时数据的id
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 *获取股票代码
	 */
	public String getCode(){
		return this.code;
	}
	
	/**
	 *设置股票代码
	 */
	public void setCode(String code){
		this.code = code;
	}
	
	/**
	 *获取股票名称
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 *设置股票名称
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 *获取昨日收盘价
	 */
	public BigDecimal getYesClose(){
		return this.yesClose;
	}
	
	/**
	 *设置昨日收盘价
	 */
	public void setYesClose(BigDecimal yesClose){
		this.yesClose = yesClose;
	}
	
	/**
	 *获取今日开盘价
	 */
	public BigDecimal getTodOpen(){
		return this.todOpen;
	}
	
	/**
	 *设置今日开盘价
	 */
	public void setTodOpen(BigDecimal todOpen){
		this.todOpen = todOpen;
	}
	
	/**
	 *获取今日最高价
	 */
	public BigDecimal getTodHigh(){
		return this.todHigh;
	}
	
	/**
	 *设置今日最高价
	 */
	public void setTodHigh(BigDecimal todHigh){
		this.todHigh = todHigh;
	}
	
	/**
	 *获取今日最低价
	 */
	public BigDecimal getTodLow(){
		return this.todLow;
	}
	
	/**
	 *设置今日最低价
	 */
	public void setTodLow(BigDecimal todLow){
		this.todLow = todLow;
	}
	
	/**
	 *获取当前价
	 */
	public BigDecimal getCurrent(){
		return this.current;
	}
	
	/**
	 *设置当前价
	 * @throws ValueLegalException 
	 */
	public void setCurrent(BigDecimal current) {
		if(current != null && current.compareTo(new BigDecimal(0)) < 1){
			System.out.println("value error!!!");
		}
		this.current = current;
	}
	
	/**
	 *获取市盈率1
	 */
	public BigDecimal getProfitRate1(){
		return this.profitRate1;
	}
	
	/**
	 *设置市盈率1
	 */
	public void setProfitRate1(BigDecimal profitRate1){
		this.profitRate1 = profitRate1;
	}
	
	/**
	 *获取市盈率2
	 */
	public BigDecimal getProfitRate2(){
		return this.profitRate2;
	}
	
	/**
	 *设置市盈率2
	 */
	public void setProfitRate2(BigDecimal profitRate2){
		this.profitRate2 = profitRate2;
	}
	
	/**
	 *获取成交额
	 */
	public BigDecimal getTempAmount(){
		return this.tempAmount;
	}
	
	/**
	 *设置成交额
	 */
	public void setTempAmount(BigDecimal tempAmount){
		this.tempAmount = tempAmount;
	}
	
	/**
	 *获取成交笔数
	 */
	public BigDecimal getTempBi(){
		return this.tempBi;
	}
	
	/**
	 *设置成交笔数
	 */
	public void setTempBi(BigDecimal tempBi){
		this.tempBi = tempBi;
	}
	
	/**
	 *获取成交量
	 */
	public BigDecimal getTempVolume(){
		return this.tempVolume;
	}
	
	/**
	 *设置成交量
	 */
	public void setTempVolume(BigDecimal tempVolume){
		this.tempVolume = tempVolume;
	}
	
	/**
	 *获取涨跌额1
	 */
	public BigDecimal getChange1(){
		if(change1 == null){
			if (this.current != null
					&& this.current.compareTo(new BigDecimal(0)) > 0
					&& this.yesClose != null
					&& this.yesClose.compareTo(new BigDecimal(0)) > 0)
			this.change1 = this.current.subtract(this.yesClose).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
		return this.change1;
	}
	
	/**
	 *设置涨跌额1
	 */
	public void setChange1(BigDecimal change1){
		this.change1 = change1;
	}
	
	/**
	 *获取跌额涨2
	 */
	public BigDecimal getChange2(){
		return this.change2;
	}
	
	/**
	 *设置跌额涨2
	 */
	public void setChange2(BigDecimal change2){
		this.change2 = change2;
	}
	
	/**
	 *获取约合持仓量
	 */
	public BigDecimal getContractHold(){
		return this.contractHold;
	}
	
	/**
	 *设置约合持仓量
	 */
	public void setContractHold(BigDecimal contractHold){
		this.contractHold = contractHold;
	}
	
	/**
	 *获取当前买入价
	 */
	public BigDecimal getCurrentBuy(){
		return this.currentBuy;
	}
	
	/**
	 *设置当前买入价
	 */
	public void setCurrentBuy(BigDecimal currentBuy){
		this.currentBuy = currentBuy;
	}
	
	/**
	 *获取当前卖出价
	 */
	public BigDecimal getCurrentSold(){
		return this.currentSold;
	}
	
	/**
	 *设置当前卖出价
	 */
	public void setCurrentSold(BigDecimal currentSold){
		this.currentSold = currentSold;
	}
	
	/**
	 *获取申买量一
	 */
	public BigDecimal getApplyBuyVol1(){
		return this.applyBuyVol1;
	}
	
	/**
	 *设置申买量一
	 */
	public void setApplyBuyVol1(BigDecimal applyBuyVol1){
		this.applyBuyVol1 = applyBuyVol1;
	}
	
	/**
	 *获取申买价二
	 */
	public BigDecimal getApplyBuyPri2(){
		return this.applyBuyPri2;
	}
	
	/**
	 *设置申买价二
	 */
	public void setApplyBuyPri2(BigDecimal applyBuyPri2){
		this.applyBuyPri2 = applyBuyPri2;
	}
	
	/**
	 *获取申买量二
	 */
	public BigDecimal getApplyBuyVol2(){
		return this.applyBuyVol2;
	}
	
	/**
	 *设置申买量二
	 */
	public void setApplyBuyVol2(BigDecimal applyBuyVol2){
		this.applyBuyVol2 = applyBuyVol2;
	}
	
	/**
	 *获取申买价三
	 */
	public BigDecimal getApplyBuyPri3(){
		return this.applyBuyPri3;
	}
	
	/**
	 *设置申买价三
	 */
	public void setApplyBuyPri3(BigDecimal applyBuyPri3){
		this.applyBuyPri3 = applyBuyPri3;
	}
	
	/**
	 *获取申买量三
	 */
	public BigDecimal getApplyBuyVol3(){
		return this.applyBuyVol3;
	}
	
	/**
	 *设置申买量三
	 */
	public void setApplyBuyVol3(BigDecimal applyBuyVol3){
		this.applyBuyVol3 = applyBuyVol3;
	}
	
	/**
	 *获取申卖量1
	 */
	public BigDecimal getApplySoldVol1(){
		return this.applySoldVol1;
	}
	
	/**
	 *设置申卖量1
	 */
	public void setApplySoldVol1(BigDecimal applySoldVol1){
		this.applySoldVol1 = applySoldVol1;
	}
	
	/**
	 *获取申卖价2
	 */
	public BigDecimal getApplySoldPri2(){
		return this.applySoldPri2;
	}
	
	/**
	 *设置申卖价2
	 */
	public void setApplySoldPri2(BigDecimal applySoldPri2){
		this.applySoldPri2 = applySoldPri2;
	}
	
	/**
	 *获取申卖量2
	 */
	public BigDecimal getApplySoldVol2(){
		return this.applySoldVol2;
	}
	
	/**
	 *设置申卖量2
	 */
	public void setApplySoldVol2(BigDecimal applySoldVol2){
		this.applySoldVol2 = applySoldVol2;
	}
	
	/**
	 *获取申卖价3
	 */
	public BigDecimal getApplySoldPri3(){
		return this.applySoldPri3;
	}
	
	/**
	 *设置申卖价3
	 */
	public void setApplySoldPri3(BigDecimal applySoldPri3){
		this.applySoldPri3 = applySoldPri3;
	}
	
	/**
	 *获取申卖量3
	 */
	public BigDecimal getApplySoldVol3(){
		return this.applySoldVol3;
	}
	
	/**
	 *设置申卖量3
	 */
	public void setApplySoldVol3(BigDecimal applySoldVol3){
		this.applySoldVol3 = applySoldVol3;
	}
	
	/**
	 *获取申买价4
	 */
	public BigDecimal getApplyBuyPri4(){
		return this.applyBuyPri4;
	}
	
	/**
	 *设置申买价4
	 */
	public void setApplyBuyPri4(BigDecimal applyBuyPri4){
		this.applyBuyPri4 = applyBuyPri4;
	}
	
	/**
	 *获取申买量4
	 */
	public BigDecimal getApplyBuyVol4(){
		return this.applyBuyVol4;
	}
	
	/**
	 *设置申买量4
	 */
	public void setApplyBuyVol4(BigDecimal applyBuyVol4){
		this.applyBuyVol4 = applyBuyVol4;
	}
	
	/**
	 *获取申买价5
	 */
	public BigDecimal getApplyBuyPri5(){
		return this.applyBuyPri5;
	}
	
	/**
	 *设置申买价5
	 */
	public void setApplyBuyPri5(BigDecimal applyBuyPri5){
		this.applyBuyPri5 = applyBuyPri5;
	}
	
	/**
	 *获取申买量5
	 */
	public BigDecimal getApplyBuyVol5(){
		return this.applyBuyVol5;
	}
	
	/**
	 *设置申买量5
	 */
	public void setApplyBuyVol5(BigDecimal applyBuyVol5){
		this.applyBuyVol5 = applyBuyVol5;
	}
	
	/**
	 *获取申卖价四
	 */
	public BigDecimal getApplySoldPri4(){
		return this.applySoldPri4;
	}
	
	/**
	 *设置申卖价四
	 */
	public void setApplySoldPri4(BigDecimal applySoldPri4){
		this.applySoldPri4 = applySoldPri4;
	}
	
	/**
	 *获取申卖量4
	 */
	public BigDecimal getApplySoldVol4(){
		return this.applySoldVol4;
	}
	
	/**
	 *设置申卖量4
	 */
	public void setApplySoldVol4(BigDecimal applySoldVol4){
		this.applySoldVol4 = applySoldVol4;
	}
	
	/**
	 *获取申卖价5
	 */
	public BigDecimal getApplySoldPri5(){
		return this.applySoldPri5;
	}
	
	/**
	 *设置申卖价5
	 */
	public void setApplySoldPri5(BigDecimal applySoldPri5){
		this.applySoldPri5 = applySoldPri5;
	}
	
	/**
	 *获取申卖量5
	 */
	public BigDecimal getApplySoldVol5(){
		return this.applySoldVol5;
	}
	
	/**
	 *设置申卖量5
	 */
	public void setApplySoldVol5(BigDecimal applySoldVol5){
		this.applySoldVol5 = applySoldVol5;
	}
	
	/**
	 *获取实时交易时间
	 */
	public Date getTime(){
		return this.time;
	}
	
	/**
	 *设置实时交易时间
	 */
	public void setTime(Date time){
		this.time = time;
	}
	
	/**
	 *获取股票所属的市场，0，沪深，1港股，2美股
	 */
	public Integer getMarket(){
		return this.market;
	}
	
	/**
	 *设置股票所属的市场，0，沪深，1港股，2美股
	 */
	public void setMarket(Integer market){
		this.market = market;
	}
	
	/**
	 *获取股票所属的行业的id
	 */
	public Integer getIndustryId(){
		return this.industryId;
	}
	
	/**
	 *设置股票所属的行业的id
	 */
	public void setIndustryId(Integer industryId){
		this.industryId = industryId;
	}
	
	/**
	 *获取股票所属的行业名
	 */
	public String getIndustryName(){
		return this.industryName;
	}
	
	/**
	 *设置股票所属的行业名
	 */
	public void setIndustryName(String industryName){
		this.industryName = industryName;
	}
	
	/**
	 *获取涨跌幅1
	 */
	public BigDecimal getChange1Range(){
		//计算公式：(当前最新成交价（或收盘价）-开盘参考价)÷开盘参考价×100%              一般情况： 开盘参考价=前一交易日收盘价
		if (this.change1Range == null) {
			if (this.current != null
					&& this.current.compareTo(new BigDecimal(0)) > 0
					&& this.yesClose != null
					&& this.yesClose.compareTo(new BigDecimal(0)) > 0)
			this.change1Range = this.current.subtract(this.yesClose)
					.divide(this.yesClose, 5, RoundingMode.HALF_UP)
					.multiply(new BigDecimal(100))
					.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return this.change1Range;
	}
	
	/**
	 *设置涨跌幅1
	 */
	public void setChange1Range(BigDecimal change1Range){
		this.change1Range = change1Range;
	}
	
	/**
	 *获取涨跌幅2
	 */
	public BigDecimal getChange2Range(){
		return this.change2Range;
	}
	
	/**
	 *设置涨跌幅2
	 */
	public void setChange2Range(BigDecimal change2Range){
		this.change2Range = change2Range;
	}
	
	/**
	 *获取今日累计成交量
	 */
	public BigDecimal getTodTotalVolume(){
		return this.todTotalVolume;
	}
	
	/**
	 *设置今日累计成交量
	 */
	public void setTodTotalVolume(BigDecimal todTotalVolume){
		this.todTotalVolume = todTotalVolume;
	}
	
	/**
	 *获取当日累计成交额
	 */
	public BigDecimal getTodTotalAmount(){
		return this.todTotalAmount;
	}
	
	/**
	 *设置当日累计成交额
	 */
	public void setTodTotalAmount(BigDecimal todTotalAmount){
		this.todTotalAmount = todTotalAmount;
	}
	
	/**
	 *获取换手率
	 */
	public BigDecimal getHandRate(){
		return this.handRate;
	}
	
	/**
	 *设置换手率
	 */
	public void setHandRate(BigDecimal handRate){
		this.handRate = handRate;
	}
	
	/**
	 *获取持有人数
	 */
	public Integer getUserHold(){
		return this.userHold;
	}
	
	/**
	 *设置持有人数
	 */
	public void setUserHold(Integer userHold){
		this.userHold = userHold;
	}
	
	/**
	 *获取均价
	 */
	public BigDecimal getAverage(){
		return this.average;
	}
	
	/**
	 *设置均价
	 */
	public void setAverage(BigDecimal average){
		this.average = average;
	}
	
	/**
	 *获取52周最高
	 */
	public BigDecimal getWeek52Max(){
		return this.week52Max;
	}
	
	/**
	 *设置52周最高
	 */
	public void setWeek52Max(BigDecimal week52Max){
		this.week52Max = week52Max;
	}
	
	/**
	 *获取52周最低
	 */
	public BigDecimal getWeek52Min(){
		return this.week52Min;
	}
	
	/**
	 *设置52周最低
	 */
	public void setWeek52Min(BigDecimal week52Min){
		this.week52Min = week52Min;
	}
	
	/**
	 *获取30日均成交量
	 */
	public BigDecimal getAverage30Volume(){
		return this.average30Volume;
	}
	
	/**
	 *设置30日均成交量
	 */
	public void setAverage30Volume(BigDecimal average30Volume){
		this.average30Volume = average30Volume;
	}
	
	/**
	 *获取发行总量（总股本）
	 */
	public BigDecimal getTotalVolume(){
		return this.totalVolume;
	}
	
	/**
	 *设置发行总量（总股本）
	 */
	public void setTotalVolume(BigDecimal totalVolume){
		this.totalVolume = totalVolume;
	}
	
	/**
	 *获取流通股数
	 */
	public BigDecimal getCurrencyNum(){
		return this.currencyNum;
	}
	
	/**
	 *设置流通股数
	 */
	public void setCurrencyNum(BigDecimal currencyNum){
		this.currencyNum = currencyNum;
	}
	
	/**
	 *获取境内流通股本
	 */
	public BigDecimal getInsideCirculate(){
		return this.insideCirculate;
	}
	
	/**
	 *设置境内流通股本
	 */
	public void setInsideCirculate(BigDecimal insideCirculate){
		this.insideCirculate = insideCirculate;
	}
	
	/**
	 *获取境外流通股本
	 */
	public BigDecimal getOutsideCirculate(){
		return this.outsideCirculate;
	}
	
	/**
	 *设置境外流通股本
	 */
	public void setOutsideCirculate(BigDecimal outsideCirculate){
		this.outsideCirculate = outsideCirculate;
	}
	
	/**
	 *获取市盈率（实时计算）
	 */
	public BigDecimal getProfitRate(){
		return this.profitRate;
	}
	
	/**
	 *设置市盈率（实时计算）
	 */
	public void setProfitRate(BigDecimal profitRate){
		this.profitRate = profitRate;
	}
	
	/**
	 *获取总市值(实时计算)
	 */
	public BigDecimal getStockValue(){
		return this.stockValue;
	}
	
	/**
	 *设置总市值(实时计算)
	 */
	public void setStockValue(BigDecimal stockValue){
		this.stockValue = stockValue;
	}
	
	/**
	 *获取每股净资产
	 */
	public BigDecimal getValue(){
		return this.value;
	}
	
	/**
	 *设置每股净资产
	 */
	public void setValue(BigDecimal value){
		this.value = value;
	}
	
	/**
	 *获取净资产收益率
	 */
	public BigDecimal getEarnYield(){
		return this.earnYield;
	}
	
	/**
	 *设置净资产收益率
	 */
	public void setEarnYield(BigDecimal earnYield){
		this.earnYield = earnYield;
	}
	
	/**
	 *获取委比
	 */
	public BigDecimal getWeibi(){
		return this.weibi;
	}
	
	/**
	 *设置委比
	 */
	public void setWeibi(BigDecimal weibi){
		this.weibi = weibi;
	}
	
	/**
	 *获取量比
	 */
	public BigDecimal getVolumeRatio(){
		return this.volumeRatio;
	}
	
	/**
	 *设置量比
	 */
	public void setVolumeRatio(BigDecimal volumeRatio){
		this.volumeRatio = volumeRatio;
	}
	
	/**
	 *获取现手
	 */
	public BigDecimal getCurrentHand(){
		return this.currentHand;
	}
	
	/**
	 *设置现手
	 */
	public void setCurrentHand(BigDecimal currentHand){
		this.currentHand = currentHand;
	}
	
	/**
	 *获取总手
	 */
	public BigDecimal getTotalHand(){
		return this.totalHand;
	}
	
	/**
	 *设置总手
	 */
	public void setTotalHand(BigDecimal totalHand){
		this.totalHand = totalHand;
	}
	
	/**
	 *获取内盘
	 */
	public BigDecimal getInnerPan(){
		return this.innerPan;
	}
	
	/**
	 *设置内盘
	 */
	public void setInnerPan(BigDecimal innerPan){
		this.innerPan = innerPan;
	}
	
	/**
	 *获取外盘
	 */
	public BigDecimal getOuterPan(){
		return this.outerPan;
	}
	
	/**
	 *设置外盘
	 */
	public void setOuterPan(BigDecimal outerPan){
		this.outerPan = outerPan;
	}
	

	/**
	 * 获取雪球的行业id
	 * @return
	 */
	public Integer getXueqiuIndustryId() {
		return xueqiuIndustryId;
	}

	/**
	 * 设置雪球的行业id
	 * @param xueqiuIndustryId
	 */
	public void setXueqiuIndustryId(Integer xueqiuIndustryId) {
		this.xueqiuIndustryId = xueqiuIndustryId;
	}

	/**
	 * 获取雪球的行业名称
	 * @return
	 */
	public String getXueqiuIndustryName() {
		return xueqiuIndustryName;
	}

	/**
	 * 设置雪球的行业名称
	 * @param xueqiuIndustryName
	 */
	public void setXueqiuIndustryName(String xueqiuIndustryName) {
		this.xueqiuIndustryName = xueqiuIndustryName;
	}
	
	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Integer getBriefCrc() {
		return briefCrc;
	}

	public void setBriefCrc(Integer briefCrc) {
		this.briefCrc = briefCrc;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public Integer getBusinessCrc() {
		return businessCrc;
	}

	public void setBusinessCrc(Integer businessCrc) {
		this.businessCrc = businessCrc;
	}
	
	/**
	 * 股票信息列表中，用于搜索的搜索框，联合搜索code和name.
	 * 这个字段不做存储，用于做solr索引。
	 */
	private String searchName;
	

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	public BigDecimal getRiseSpeed() {
		return riseSpeed;
	}

	public void setRiseSpeed(BigDecimal riseSpeed) {
		this.riseSpeed = riseSpeed;
	}

	public String getPinYin() {
		return pinYin;
	}

	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}

	/**user customize code start*/

	
	
	public int priceCompare () {
		if(current == null || yesClose == null)
			return 0;
		return current.compareTo(yesClose);
	}
	
	/**user customize code end*/
}

