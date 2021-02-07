package com.tamako.entity.convert;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDateTime;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/27 9:45
 */
public class LocalDateTimeConverter implements Converter<LocalDateTime> {
	@Override
	public Class<LocalDateTime> supportJavaTypeKey() {
		return LocalDateTime.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		return CellDataTypeEnum.STRING;
	}

	@Override
	public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
		return LocalDateTime.parse(cellData.getStringValue());
	}

	@Override
	public CellData<String> convertToExcelData(LocalDateTime value, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
		return new CellData<>(value.toString());
	}
}
