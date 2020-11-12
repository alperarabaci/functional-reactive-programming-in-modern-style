package main115_observer_design_pattern;

interface SubjectLibrary {

	public void subscribeObserver(Observer ob);
	
	public void unSubscribeObserver(Observer ob);
	
	public void notifyObserver();
}
