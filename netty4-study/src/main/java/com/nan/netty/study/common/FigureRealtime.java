package com.nan.netty.study.common;

import java.util.Date;
import java.math.BigDecimal;
import java.math.RoundingMode;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 描述：</b>大盘指数实时数据表<br>
 * @author：系统生成
 * @version:1.0
 */
public class FigureRealtime {
	private static final long serialVersionUID = 1L;
	
	/**
	 *大盘指数的实时数据
	 */
	@JSONField(serialize = false)
	private Integer id;
	/**
	 *大盘指数代码
	 */
	private String code;
	/**
	 *指数名称
	 */
	private String name;
	/**
	 *股指的英文名称
	 */
	@JSONField(serialize = false)
	private String engName;
	/**
	 *指数所属的市场，0，沪深，1港股，2美股
	 */
	@JSONField(serialize = false)
	private Integer market;
	/**
	 *昨日收盘指数
	 */
	private BigDecimal yesClose;
	/**
	 *今日开盘
	 */
	private BigDecimal todOpen;
	/**
	 *前当指数
	 */
	private BigDecimal current;
	/**
	 *今日昨收盘指数
	 */
	private BigDecimal close;
	/**
	 *最高指数
	 */
	private BigDecimal high;
	/**
	 *最低指数
	 */
	private BigDecimal low;
	/**
	 *涨跌额（根据figure_realtime）中数据来计算
	 */
	private BigDecimal change;
	/**
	 *涨跌幅（根据figure_realtime）中数据来计算
	 */
	private BigDecimal changeRange;
	/**
	 *成交量（当日累计）
	 */
	private BigDecimal volume;
	/**
	 *成交额（当日累计成交额）
	 */
	private BigDecimal amount;
	/**
	 *换手率（当日累计换手率）
	 */
//	@JSONField(serialize = false)
	private BigDecimal handRate;
	/**
	 *均价
	 */
	@JSONField(serialize = false)
	private BigDecimal average;
	/**
	 *52周最高（实时计算）
	 */
	@JSONField(serialize = false)
	private BigDecimal week52Max;
	/**
	 *52周最低（实时计算）
	 */
	@JSONField(serialize = false)
	private BigDecimal week52Min;
	/**
	 *总市值（实时计算）
	 */
	@JSONField(serialize = false)
	private BigDecimal stockValue;
	/**
	 *流通股本
	 */
	@JSONField(serialize = false)
	private BigDecimal currencyNum;
	/**
	 *境内流通股本
	 */
	@JSONField(serialize = false)
	private BigDecimal insideCirculate;
	/**
	 *境外流通股本
	 */
	@JSONField(serialize = false)
	private BigDecimal outsideCirculate;
	/**
	 *前当买入价
	 */
	@JSONField(serialize = false)
	private BigDecimal currentBuy;
	/**
	 *前当卖出价
	 */
	@JSONField(serialize = false)
	private BigDecimal currentSold;
	/**
	 *申买量一
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyVol1;
	/**
	 *申买价2
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyPri2;
	/**
	 *申买量2
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyVol2;
	/**
	 *申买价3
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyPri3;
	/**
	 *申买量3
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyVol3;
	/**
	 *申卖量1
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldVol1;
	/**
	 *申卖价2
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldPri2;
	/**
	 *申卖量2
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldVol2;
	/**
	 *申卖价3
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldPri3;
	/**
	 *申卖量3
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldVol3;
	/**
	 *申买价4
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyPri4;
	/**
	 *申买量4
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyVol4;
	/**
	 *申买价5
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyPri5;
	/**
	 *申买量5
	 */
	@JSONField(serialize = false)
	private BigDecimal applyBuyVol5;
	/**
	 *申买价4
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldPri4;
	/**
	 *申买量4
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldVol4;
	/**
	 *申买价5
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldPri5;
	/**
	 *申卖量5
	 */
	@JSONField(serialize = false)
	private BigDecimal applySoldVol5;
	/**
	 *交易时间
	 */
	private Date tradeTime;
	
	/**
	 *指股简介,只做暂存，不入库
	 */
	@JSONField(serialize = false)
	private String brief;
	/**
	 *股指简介CRC校验码,只做暂存，不入库
	 */
	@JSONField(serialize = false)
	private Integer briefCrc;
	
	/**
	 * 类型字段，0代表2或者5分钟的分时数据，1代表是用来展示5天分时数据的10分钟的分时数据。
	 */
	@JSONField(serialize = false)
	private Integer minType;
	
	/**
	 * 涨速
	 */
	private BigDecimal riseSpeed;
	
	/*
	 * 状态
	 */
	private int state;
	
	private String serial;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public BigDecimal getRiseSpeed() {
		return riseSpeed;
	}

	public void setRiseSpeed(BigDecimal riseSpeed) {
		this.riseSpeed = riseSpeed;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Integer getMinType() {
		return minType;
	}

	public void setMinType(Integer minType) {
		this.minType = minType;
	}

	/**
	 *获取大盘指数的实时数据
	 */
	public Integer getId(){
		return this.id;
	}
	
	/**
	 *设置大盘指数的实时数据
	 */
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	 *获取大盘指数代码
	 */
	public String getCode(){
		return this.code;
	}
	
	/**
	 *设置大盘指数代码
	 */
	public void setCode(String code){
		this.code = code;
	}
	
	/**
	 *获取指数名称
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 *设置指数名称
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 *获取股指的英文名称
	 */
	public String getEngName(){
		return this.engName;
	}
	
	/**
	 *设置股指的英文名称
	 */
	public void setEngName(String engName){
		this.engName = engName;
	}
	
	/**
	 *获取指数所属的市场，0，沪深，1港股，2美股
	 */
	public Integer getMarket(){
		return this.market;
	}
	
	/**
	 *设置指数所属的市场，0，沪深，1港股，2美股
	 */
	public void setMarket(Integer market){
		this.market = market;
	}
	
	/**
	 *获取昨日收盘指数
	 */
	public BigDecimal getYesClose(){
		return this.yesClose;
	}
	
	/**
	 *设置昨日收盘指数
	 */
	public void setYesClose(BigDecimal yesClose){
		this.yesClose = yesClose;
	}
	
	/**
	 *获取今日开盘
	 */
	public BigDecimal getTodOpen(){
		return this.todOpen;
	}
	
	/**
	 *设置今日开盘
	 */
	public void setTodOpen(BigDecimal todOpen){
		this.todOpen = todOpen;
	}
	
	/**
	 *获取前当指数
	 */
	public BigDecimal getCurrent(){
		return this.current;
	}
	
	/**
	 *设置前当指数
	 */
	public void setCurrent(BigDecimal current){
		this.current = current;
	}
	
	/**
	 *获取今日昨收盘指数
	 */
	public BigDecimal getClose(){
		return this.close;
	}
	
	/**
	 *设置今日昨收盘指数
	 */
	public void setClose(BigDecimal close){
		this.close = close;
	}
	
	/**
	 *获取最高指数
	 */
	public BigDecimal getHigh(){
		return this.high;
	}
	
	/**
	 *设置最高指数
	 */
	public void setHigh(BigDecimal high){
		this.high = high;
	}
	
	/**
	 *获取最低指数
	 */
	public BigDecimal getLow(){
		return this.low;
	}
	
	/**
	 *设置最低指数
	 */
	public void setLow(BigDecimal low){
		this.low = low;
	}
	
	/**
	 *涨跌额（根据figure_realtime）中数据来计算
	 */	
	public BigDecimal getChange() {
		if(change == null){
			if (this.current != null
					&& this.current.compareTo(new BigDecimal(0)) > 0
					&& this.yesClose != null
					&& this.yesClose.compareTo(new BigDecimal(0)) > 0)
			this.change = this.current.subtract(this.yesClose).setScale(2,BigDecimal.ROUND_HALF_UP);
		}
		return change;
	}

	public void setChange(BigDecimal change) {
		this.change = change;
	}

	public BigDecimal getChangeRange() {
		
		//计算公式：(当前最新成交价（或收盘价）-开盘参考价)÷开盘参考价×100%              一般情况： 开盘参考价=前一交易日收盘价
		if (this.changeRange == null) {
			if (this.current != null
					&& this.current.compareTo(new BigDecimal(0)) > 0
					&& this.yesClose != null
					&& this.yesClose.compareTo(new BigDecimal(0)) > 0)
			this.changeRange = this.current.subtract(this.yesClose)
					.divide(this.yesClose, 5, RoundingMode.HALF_UP)
					.multiply(new BigDecimal(100))
					.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return this.changeRange;
	}

	public void setChangeRange(BigDecimal changeRange) {
		this.changeRange = changeRange;
	}
	
	/**
	 *获取成交量（当日累计）
	 */
	public BigDecimal getVolume(){
		return this.volume;
	}
	
	/**
	 *设置成交量（当日累计）
	 */
	public void setVolume(BigDecimal volume){
		this.volume = volume;
	}
	
	/**
	 *获取成交额（当日累计成交额）
	 */
	public BigDecimal getAmount(){
		return this.amount;
	}
	
	/**
	 *设置成交额（当日累计成交额）
	 */
	public void setAmount(BigDecimal amount){
		this.amount = amount;
	}
	
	/**
	 *获取换手率（当日累计换手率）
	 */
	public BigDecimal getHandRate(){
		return this.handRate;
	}
	
	/**
	 *设置换手率（当日累计换手率）
	 */
	public void setHandRate(BigDecimal handRate){
		this.handRate = handRate;
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
	 *获取52周最高（实时计算）
	 */
	public BigDecimal getWeek52Max(){
		return this.week52Max;
	}
	
	/**
	 *设置52周最高（实时计算）
	 */
	public void setWeek52Max(BigDecimal week52Max){
		this.week52Max = week52Max;
	}
	
	/**
	 *获取52周最低（实时计算）
	 */
	public BigDecimal getWeek52Min(){
		return this.week52Min;
	}
	
	/**
	 *设置52周最低（实时计算）
	 */
	public void setWeek52Min(BigDecimal week52Min){
		this.week52Min = week52Min;
	}
	
	/**
	 *获取总市值（实时计算）
	 */
	public BigDecimal getStockValue(){
		return this.stockValue;
	}
	
	/**
	 *设置总市值（实时计算）
	 */
	public void setStockValue(BigDecimal stockValue){
		this.stockValue = stockValue;
	}
	
	/**
	 *获取流通股本
	 */
	public BigDecimal getCurrencyNum(){
		return this.currencyNum;
	}
	
	/**
	 *设置流通股本
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
	 *获取前当买入价
	 */
	public BigDecimal getCurrentBuy(){
		return this.currentBuy;
	}
	
	/**
	 *设置前当买入价
	 */
	public void setCurrentBuy(BigDecimal currentBuy){
		this.currentBuy = currentBuy;
	}
	
	/**
	 *获取前当卖出价
	 */
	public BigDecimal getCurrentSold(){
		return this.currentSold;
	}
	
	/**
	 *设置前当卖出价
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
	 *获取申买价2
	 */
	public BigDecimal getApplyBuyPri2(){
		return this.applyBuyPri2;
	}
	
	/**
	 *设置申买价2
	 */
	public void setApplyBuyPri2(BigDecimal applyBuyPri2){
		this.applyBuyPri2 = applyBuyPri2;
	}
	
	/**
	 *获取申买量2
	 */
	public BigDecimal getApplyBuyVol2(){
		return this.applyBuyVol2;
	}
	
	/**
	 *设置申买量2
	 */
	public void setApplyBuyVol2(BigDecimal applyBuyVol2){
		this.applyBuyVol2 = applyBuyVol2;
	}
	
	/**
	 *获取申买价3
	 */
	public BigDecimal getApplyBuyPri3(){
		return this.applyBuyPri3;
	}
	
	/**
	 *设置申买价3
	 */
	public void setApplyBuyPri3(BigDecimal applyBuyPri3){
		this.applyBuyPri3 = applyBuyPri3;
	}
	
	/**
	 *获取申买量3
	 */
	public BigDecimal getApplyBuyVol3(){
		return this.applyBuyVol3;
	}
	
	/**
	 *设置申买量3
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
	 *获取申买价4
	 */
	public BigDecimal getApplySoldPri4(){
		return this.applySoldPri4;
	}
	
	/**
	 *设置申买价4
	 */
	public void setApplySoldPri4(BigDecimal applySoldPri4){
		this.applySoldPri4 = applySoldPri4;
	}
	
	/**
	 *获取申买量4
	 */
	public BigDecimal getApplySoldVol4(){
		return this.applySoldVol4;
	}
	
	/**
	 *设置申买量4
	 */
	public void setApplySoldVol4(BigDecimal applySoldVol4){
		this.applySoldVol4 = applySoldVol4;
	}
	
	/**
	 *获取申买价5
	 */
	public BigDecimal getApplySoldPri5(){
		return this.applySoldPri5;
	}
	
	/**
	 *设置申买价5
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
	 *获取交易时间
	 */
	public Date getTradeTime(){
		return this.tradeTime;
	}
	
	/**
	 *设置交易时间
	 */
	public void setTradeTime(Date tradeTime){
		this.tradeTime = tradeTime;
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
	
	/**user customize code start*/
	/**
	 * 产生CRC校验码，用来校验指数简介
	 * @param code
	 * @param msg
	 * @return
	 */
//	public static Integer generateCrc(String code,String msg){
//		return CRCUtil.crc(code,msg);
//	}
	/**user customize code end*/
}

