package com.tamako.util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 描述：对Excel做相关操作的工具类
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 15:28
 */
public class ExcelUtil {

	public static <T> DataListener<T> getDataListener(IService<T> service) {
		return new DataListener<T>(service);
	}

	public static <T> DataListener<T> getDataListener(IService<T> service, int batchCount) {
		return new DataListener<T>(service, batchCount);
	}

	private static class DataListener<T> extends AnalysisEventListener<T> {

		private int batchCount = 100;
		private IService<T> service;
		List<T> list = new ArrayList<>();

		public DataListener(IService<T> service) {
			this.service = service;
		}

		public DataListener(IService<T> service, int batchCount) {
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
			service.saveBatch(list);
		}
	}

}
