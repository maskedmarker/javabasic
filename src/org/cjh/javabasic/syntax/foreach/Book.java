package org.cjh.javabasic.syntax.foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Book implements Iterable<Page>{

	private List<Page> pages = new ArrayList<Page>();

	public Book() {
	}
	
	public Book(List<Page> pages) {
		this.pages.addAll(pages);
	}
	
	
	@Override
	public Iterator<Page> iterator() {
		
		return new PageIterator<Page>();
	}
	
	
	private class PageIterator<P extends Page> implements Iterator<P> {

		final private Iterator<P> it;
		
		@SuppressWarnings("unchecked")
		public PageIterator() {
			it = (Iterator<P>) pages.iterator();
		}
		
		@Override
		public boolean hasNext() {
			return it.hasNext() ;
		}

		@Override
		public P next() {
			return it.next();
		}

		@Override
		public void remove() {
			it.remove();
		}
	}
}
