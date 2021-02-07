package com.tamako.sentinel;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 描述：
 * </p>
 *
 * @author zhangtuo
 * @email zhangtuo@accesscorporate.com.cn
 * @date 2021/1/5 14:06
 */
public class DemoSentinel {

	public static void main(String[] args) {
		// 配置规则.
		initFlowRules();

		while (true) {
			// 1.5.0 版本开始可以直接利用 try-with-resources 特性，自动 exit entry
			try (Entry entry = SphU.entry("HelloWorld")) {
				// 被保护的逻辑
				System.out.println("hello world");
				Thread.sleep(40);
			} catch (BlockException | InterruptedException ex) {
				// 处理被流控的逻辑
				System.out.println("blocked!");
			}
		}
	}

	private static void initFlowRules() {
		List<FlowRule> rules = new ArrayList<>();
		FlowRule rule = new FlowRule();
		rule.setResource("HelloWorld");
		rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
		// Set limit QPS to 20.
		rule.setCount(20);
		rules.add(rule);
		FlowRuleManager.loadRules(rules);
	}

}
