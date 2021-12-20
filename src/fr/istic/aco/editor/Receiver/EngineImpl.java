package fr.istic.aco.editor.Receiver;

public class EngineImpl implements Engine {
	
	private StringBuffer stringBuffer;
	private SelectionImpl selection;
	private String clipBoard;

	
	public EngineImpl() {
		 stringBuffer= new StringBuffer("");
		 clipBoard = "";
		 selection = new SelectionImpl(stringBuffer);
	}
    /**
     * Provides access to the selection control object
     *
     * @return the selection object
     */
    @Override
    public Selection getSelection() {
                return selection;
    }

    /**
     * Provides the whole contents of the buffer, as a string
     *
     * @return a copy of the buffer's contents
     */
    @Override
    public String getBufferContents() {
       
        return stringBuffer.toString();
    }

    /**
     * Provides the clipboard contents
     *
     * @return a copy of the clipboard's contents
     */
    @Override
    public String getClipboardContents() {
       
        return clipBoard;
    }

    /**
     * Removes the text within the interval
     * specified by the selection control object,
     * from the buffer.
     */
    @Override
    public void cutSelectedText() {
	    // recuperation du text dans le buffer
    	if(selection.getBeginIndex()!= selection.getEndIndex()) {
    		String contentCut = stringBuffer.substring(getSelection().getBeginIndex(), getSelection().getEndIndex());
    		 
   		 //mettre à jour le presse papier
   		 setClipBoardContent(contentCut);
   	
   		 //On peut supprimer maintenant l'interval qu'on vient de selectionner
   		 delete();
   	}
    	
		
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {
    	if(selection.getBeginIndex()!= selection.getEndIndex()) {
    		// recuperation du text dans le buffer
   		 String contentCut = stringBuffer.substring(getSelection().getBeginIndex(), getSelection().getEndIndex());
   		 
   		 //mettre à jour le presse papier
   		 setClipBoardContent(contentCut);
       	}
    	 
		 
    }

    /**
     * Replaces the text within the interval specified by the selection object with
     * the contents of the clipboard.
     */
    @Override
    public void pasteClipboard() {
        
    	insert(getClipboardContents());
    }

    /**
     * Inserts a string in the buffer, which replaces the contents of the selection
     *
     * @param s the text to insert
     */
    @Override
    public void insert(String s) {
    	if(s==null) {
    		throw new IllegalArgumentException("le mot ne peut etre null");
    	}
    	stringBuffer.replace(getSelection().getBeginIndex(), getSelection().getEndIndex(),s);
    	//deplacer le endIndex pour le mettre au bon endroit
    	int index=selection.getBeginIndex() + s.length();
    	selection.setEndIndex(index);
    	selection.setBeginIndex(index);
    	
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
    	if(selection.getBeginIndex()!= selection.getEndIndex()) {
    		this.stringBuffer.delete(getSelection().getBeginIndex() ,getSelection().getEndIndex());
        	//on doit mettre les index fin et debut de selection au meme endroit
    		 selection.setEndIndex(selection.getBeginIndex());
    	}
    	
    }
    
    public void setClipBoardContent(String clipBord) {
    	this.clipBoard=clipBord;
    }
    
    public void setBuffer(String text) {
    	stringBuffer = new StringBuffer(text);
    }
    @Override
	public void reset() {
		
		setBuffer("");
		selection.setBeginIndex(0);
		selection.setEndIndex(0);
	}
	
    
	
}
