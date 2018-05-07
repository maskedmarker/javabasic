package org.cjh.javabasic.syntax.foreach;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有实现了Iterable的类,都可以使用foreach的语句
 *
 */
public class ForeachTest {

	public static void main(String[] args) {
		List<Page> pages = new ArrayList<Page>();
		for (int i = 0; i < 10; i++) {
			Page t = new Page();
			t.setPageNo(i);
			t.setContent("第" + i + "页");
			pages.add(t);
		}
		Book book = new Book(pages);
		// 注意
		for (Page page : book) {
			System.out.println(page);
		}
		
	}
}
