package main114_pull_vs_push;

interface CallBack {
	
	void pushData(String data);
	
	void pushComplete();
	
	void pushError(Exception ex);

}
