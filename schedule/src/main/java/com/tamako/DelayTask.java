package com.tamako;

import java.util.Timer;
import java.util.TimerTask;

/**
 * <p>
 * 描述：使用Java自带的Timer实现定时任务
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2020/11/30 10:14
 */
public class DelayTask {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Timer("time - " + i).schedule(new TimerTask() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "run");
				}
			}, 1000, 2000);
		}
		for (int i = 0; i < 10; i++) {
			;
		}
	}

}
