package fr.istic.aco.editor;

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
		 String contentCut = stringBuffer.substring(selection.getBeginIndex(), selection.getEndIndex());
		 
		 //mettre à jour le presse papier
		 setClipBoardContent(contentCut);
	
		 //On peut supprimer maintenant l'interval qu'on vient de selectionner
		 delete();
		
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {
        
    	 // recuperation du text dans le buffer
		 String contentCut = stringBuffer.substring(selection.getBeginIndex(), selection.getEndIndex());
		 
		 //mettre à jour le presse papier
		 setClipBoardContent(contentCut);
		 
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
    	
    	stringBuffer.replace(selection.getBeginIndex(), selection.getEndIndex(),s);
    	//deplacer le endIndex pour le mettre au bon endroit
    	//selection.setEndIndex(selection.getBeginIndex()+ s.length());
    	
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
    	
    	this.stringBuffer.delete(selection.getBeginIndex() ,selection.getEndIndex());
    	//on doit mettre les index fin et debut de selection au meme endroit
		 //selection.setEndIndex(selection.getBeginIndex());
    }
    
    public void setClipBoardContent(String clipBord) {
    	this.clipBoard=clipBord;
    }
}
