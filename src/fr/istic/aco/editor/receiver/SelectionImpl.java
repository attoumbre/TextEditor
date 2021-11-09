package fr.istic.aco.editor.receiver;



public class SelectionImpl implements Selection {
	
	private int beginIndex;
	private int endIndex;
	private StringBuffer StringBuffer;
	private int bufferBeginIndex;
	
	
	public SelectionImpl(StringBuffer stringBuffer) {
		this.beginIndex=0;
		this.endIndex=0;
		this.bufferBeginIndex=0;
		this.StringBuffer= stringBuffer;
	}

	 /**
     * Provides the index of the first character designated
     * by the selection.
     *
     * @return
     */
	@Override
	public int getBeginIndex() {
		// TODO Auto-generated method stub
		return beginIndex;
	}

	/**
     * Provides the index of the first character
     * after the last character designated
     * by the selection.
     *
     * @return the end index
     */
	@Override
	public int getEndIndex() {
		
		return endIndex;
	}

	/**
     * Provides the index of the first character in the buffer
     *
     * @return the buffer's begin index
     */
	@Override
	public int getBufferBeginIndex() {
		
		return bufferBeginIndex;
	}

	/**
     * Provides the index of the first "virtual" character
     * after the end of the buffer
     *
     * @return the post end buffer index
     */
	@Override
	public int getBufferEndIndex() {
		// TODO Auto-generated method stub
		return StringBuffer.length();
	}

	/**
     * Changes the value of the begin index of the selection
     *
     * @param beginIndex, must be within the buffer index range
     * @throws IndexOutOfBoundsException if the beginIndex is out of bounds
     */
	@Override
	public void setBeginIndex(int beginIndex) {
		if( (beginIndex < getBufferBeginIndex()) || (beginIndex > getEndIndex()) || (beginIndex> getBufferEndIndex())  ){
			throw new IndexOutOfBoundsException("mauvais index de début");
		}else {
			this.beginIndex=beginIndex;
		}
	}

	/**
     * Changes the value of the end index of the selection
     *
     * @param endIndex, must be within the buffer index range
     * @throws IndexOutOfBoundsException if the beginIndex is out of bounds
     */
	@Override
	public void setEndIndex(int endIndex) {
		if((getBeginIndex() > endIndex) || (getBufferBeginIndex()>endIndex) || (endIndex > getBufferEndIndex()) ) {
			throw new IndexOutOfBoundsException("Mauvais index de fin");
		}else {
			this.endIndex= endIndex;
		}
		
	}

}
