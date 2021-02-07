package com.tamako.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.tamako.service.BaseService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 17:12
 */
public class ExcelUtil {

	public static <T> DataListener<T> getDataListener(BaseService<T> service) {
		return new DataListener<T>(service);
	}

	public static <T> DataListener<T> getDataListener(BaseService<T> service, int batchCount) {
		return new DataListener<T>(service, batchCount);
	}

	private static class DataListener<T> extends AnalysisEventListener<T> {

		private int batchCount = 100;
		private BaseService<T> service;
		List<T> list = new ArrayList<>();

		public DataListener(BaseService<T> service) {
			this.service = service;
		}

		public DataListener(BaseService<T> service, int batchCount) {
			this.service = service;
			this.batchCount = batchCount;
		}

		@Override
		public void invoke(T data, AnalysisContext context) {
			list.add(data);
			if (list.size() >= batchCount) {
				saveData();
				list.clear();
			}
		}

		@Override
		public void doAfterAllAnalysed(AnalysisContext context) {
			saveData();
		}

		private void saveData() {
			service.save(list);
		}
	}

}
