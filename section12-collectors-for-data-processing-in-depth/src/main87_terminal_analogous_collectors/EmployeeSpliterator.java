package main87_terminal_analogous_collectors;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EmployeeSpliterator implements Spliterator<Employee> {
	
	private int id;
	private String name;
	private char gender;
	private Date dob;
	private String city;
	private String designation;
	private Date joiningDate;
	private double salary;
	SimpleDateFormat format;
	Spliterator<String> baseSpliterator;

	public EmployeeSpliterator(Spliterator<String> spliterator) {
		this.baseSpliterator = spliterator;
		format = new SimpleDateFormat("yyyy-MM-dd");
	}

	@Override
	public boolean tryAdvance(Consumer<? super Employee> action) {
		boolean isTriedAdvance = baseSpliterator.tryAdvance(id -> this.id = Integer.valueOf(id))
				&& baseSpliterator.tryAdvance(name -> this.name = name)
				&& baseSpliterator.tryAdvance(gender -> this.gender = gender.charAt(0))
				&& baseSpliterator.tryAdvance(dob -> this.dob = toDate(dob))
				&& baseSpliterator.tryAdvance(city -> this.city = city)
				&& baseSpliterator.tryAdvance(designation -> this.designation = designation)
				&& baseSpliterator.tryAdvance(joiningDate -> this.joiningDate = toDate(joiningDate))
				&& baseSpliterator.tryAdvance(salary -> this.salary = Double.valueOf(salary));
		if(isTriedAdvance) {
			action.accept(new Employee(id, name, gender, dob, city, designation, joiningDate, salary));
			return true;
		}
		return false ;
	}
	
	Date toDate(String dateCandidate) {
		try {
			return format.parse(dateCandidate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Spliterator<Employee> trySplit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long estimateSize() {
		return baseSpliterator.estimateSize()/8;
	}

	@Override
	public int characteristics() {
		return baseSpliterator.characteristics();
	}

}
