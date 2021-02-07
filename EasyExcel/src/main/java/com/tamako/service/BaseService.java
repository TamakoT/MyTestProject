package com.tamako.service;

import java.util.List;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/26 17:13
 */
public interface BaseService<T> {

	void save(List<T> list);

}
