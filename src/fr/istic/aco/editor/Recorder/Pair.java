package fr.istic.aco.editor.Recorder;

public class Pair<R,M>{

	private M m ;
	
	private R r;
	
	Pair(R r, M m){
		this.m = m;
		this.r = r;
	}

	public M getM() {
		return m;
	}

	public void setM(M m) {
		this.m = m;
	}

	public R getR() {
		return r;
	}

	public void setR(R r) {
		this.r = r;
	}

	
	
}
