package fr.istic.aco.editor.Receiver;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        engine = new EngineImpl();
    }

    /*commenté car tous les tests on été ecrits
     * 
     * private void todo() {
        fail("Unimplemented test");
    	 
    }*/
    
    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
        Selection selection = engine.getSelection();
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
        
    }

    @Test
    void getBufferContents() {
    	engine.insert("laaa");
    	System.out.println(engine.getBufferContents());
   	 	assertEquals("laaa", engine.getBufferContents());
   	    Selection sel = engine.getSelection();  
   	    
   	 	engine.insert("toto");
   	  
   		sel.setBeginIndex(0);
   	 
   	 	sel.setEndIndex(3);
   	 	
   	 	engine.delete();
   	 	assertEquals("atoto", engine.getBufferContents());
   	 	
	 	engine.insert("toto");
	 	
	 	sel.setBeginIndex(0);
	 	
	 	sel.setEndIndex(4);
	 	
	 	engine.delete();
	 	engine.insert("lala");
	 	
	 	assertEquals("lalaatoto", engine.getBufferContents());
	 	
	 	sel.setBeginIndex(0);
	 	sel.setEndIndex(0);
    	engine.insert("toto");
    	sel.setBeginIndex(1);
    	sel.setEndIndex(3);
    	
	 	engine.cutSelectedText();
	 	System.out.println(engine.getBufferContents());
	 	assertEquals("tolalaatoto", engine.getBufferContents());
	 	
	 	
    }

    @Test
    void getClipboardContents() {
    	System.out.println(engine.getBufferContents());
    	assertEquals("",engine.getClipboardContents());
    	
    	
    	//vue apres copie
    	engine.insert("toto");
    	Selection sel = engine.getSelection();
    	sel.setBeginIndex(1);
    	sel.setEndIndex(3);
    	
	 	engine.copySelectedText();
	 	System.out.println(engine.getClipboardContents());
    	assertEquals("ot", engine.getClipboardContents());
    	
    	//vue apres cut-paste
	 	engine.cutSelectedText();
	 	engine.pasteClipboard();
	 	System.out.println(engine.getClipboardContents());
    	assertEquals("ot", engine.getClipboardContents());
 
    	//vue apres double copie
    	sel.setBeginIndex(1);
    	sel.setEndIndex(3);
    	
	 	engine.copySelectedText();
	 	sel.setBeginIndex(2);
	 	sel.setEndIndex(4);
    	
	 	engine.copySelectedText();
	 	assertEquals("to", engine.getClipboardContents());
    }

    @Test
    void cutSelectedText() {
    	engine.insert("toto");
    	Selection sel = engine.getSelection();
    	sel.setBeginIndex(1);
    	sel.setEndIndex(1);
    	
	 	assertThrows(IndexOutOfBoundsException.class, () -> engine.cutSelectedText());
	 	
    }

    @Test
    void copySelectedText() {
    	engine.insert("toto");
    	Selection sel = engine.getSelection();
    	sel.setBeginIndex(2);
    	sel.setEndIndex(4);
    	
	 	engine.copySelectedText();
	 	assertEquals("to", engine.getClipboardContents());
	 	assertEquals("toto", engine.getBufferContents());
    }

    @Test
    void pasteClipboard() {
    	engine.insert("totolala");
    	Selection sel = engine.getSelection();
    	sel.setBeginIndex(0);
    	sel.setEndIndex(4);
    	
    	
    	
    	engine.cutSelectedText();
    	sel.setEndIndex(4);
    	sel.setBeginIndex(4);
    	
    	
    	engine.pasteClipboard();
    	assertEquals("toto", engine.getClipboardContents());
	 	assertEquals("lalatoto", engine.getBufferContents());
    }
}
