package main83_custom_spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class BookSpliterator implements Spliterator<Book> {

	public BookSpliterator(Spliterator<String> baseSpliterator) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean tryAdvance(Consumer<? super Book> action) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spliterator<Book> trySplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int characteristics() {
		// TODO Auto-generated method stub
		return 0;
	}

}
