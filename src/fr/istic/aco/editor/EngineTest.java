package fr.istic.aco.editor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        engine = new EngineImpl();
    }

    private void todo() {
        fail("Unimplemented test");
    	 
    }
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
   	    
   	    System.out.println(sel.getEndIndex());
   	    System.out.println(sel.getBeginIndex());
   	 	engine.insert("toto");
   	    System.out.println(engine.getBufferContents());
   		sel.setEndIndex(3);
   	 	System.out.println(sel.getEndIndex());
   	 	sel.setBeginIndex(0);
   	 	System.out.println(sel.getBeginIndex());
   	 	engine.delete();
   	 	System.out.println(engine.getBufferContents());
   	 	assertEquals("o", engine.getBufferContents());
   	 	
	 	engine.insert("toto");
	 	System.out.println(engine.getBufferContents());
	 	//Selection sel1 = engine.getSelection();
	 	sel.setEndIndex(4);
	 	System.out.println(sel.getEndIndex());
	 	sel.setBeginIndex(0);
	 	System.out.println(sel.getBeginIndex());
	 	engine.delete();
	 	System.out.println(sel.getEndIndex());
	 	System.out.println(sel.getBeginIndex());
	 	System.out.println(engine.getBufferContents());
	 	engine.insert("lala");
	 	System.out.println(engine.getBufferContents());
	 	assertEquals("lalao", engine.getBufferContents());
	 	
	 	sel.setBeginIndex(0);
	 	sel.setEndIndex(0);
    	engine.insert("toto");
    	sel.setEndIndex(3);
    	sel.setBeginIndex(1);
	 	engine.cutSelectedText();
	 	System.out.println(engine.getBufferContents());
	 	assertEquals("tolalao", engine.getBufferContents());
	 	
	 	
    }

    @Test
    void getClipboardContents() {
    	System.out.println(engine.getBufferContents());
    	assertEquals("",engine.getClipboardContents());
    	
    	
    	//vue apres copie
    	engine.insert("toto");
    	Selection sel = engine.getSelection();
    	sel.setEndIndex(3);
    	sel.setBeginIndex(1);
	 	engine.copySelectedText();
	 	System.out.println(engine.getClipboardContents());
    	assertEquals("ot", engine.getClipboardContents());
    	
    	//vue apres cut-paste
	 	engine.cutSelectedText();
	 	engine.pasteClipboard();
	 	System.out.println(engine.getClipboardContents());
    	assertEquals("ot", engine.getClipboardContents());
 
    	//vue apres double copie
    	sel.setEndIndex(3);
    	sel.setBeginIndex(1);
	 	engine.copySelectedText();
	 	sel.setEndIndex(4);
    	sel.setBeginIndex(2);
	 	engine.copySelectedText();
	 	assertEquals("to", engine.getClipboardContents());
    }

    @Test
    void cutSelectedText() {
    	engine.insert("toto");
    	Selection sel = engine.getSelection();
    	sel.setEndIndex(1);
    	sel.setBeginIndex(1);
	 	assertThrows(IndexOutOfBoundsException.class, () -> engine.cutSelectedText());
	 	
    }

    @Test
    void copySelectedText() {
    	engine.insert("toto");
    	Selection sel = engine.getSelection();
    	sel.setEndIndex(4);
    	sel.setBeginIndex(2);
	 	engine.copySelectedText();
	 	assertEquals("to", engine.getClipboardContents());
	 	assertEquals("toto", engine.getBufferContents());
    }

    @Test
    void pasteClipboard() {
    	engine.insert("totolala");
    	Selection sel = engine.getSelection();
    	sel.setEndIndex(4);
    	sel.setBeginIndex(0);
    	engine.cutSelectedText();
    	sel.setEndIndex(4);
    	sel.setBeginIndex(4);
    	engine.pasteClipboard();
    	assertEquals("toto", engine.getClipboardContents());
	 	assertEquals("lalatoto", engine.getBufferContents());
    }
}
