
package fr.istic.aco.editor.Receiver;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        engine = new EngineImpl();
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
    	EngineImpl en = new EngineImpl();
    	en.insert("laaa");
   	 	assertEquals("laaa", en.getBufferContents());
   	 	
   	 	EngineImpl en1 = new EngineImpl();
   	 	en1.insert("toto");
   	 	Selection sel = en1.getSelection();
   		sel.setEndIndex(3);
   	 	System.out.println(sel.getEndIndex());
   	 	sel.setBeginIndex(0);
   	 	System.out.println(sel.getBeginIndex());
   	 
   	 	en1.delete();
   	 	System.out.println(en1.getBufferContents());
   	 	assertEquals("o", en1.getBufferContents());
   	 	
   	 	EngineImpl en2 = new EngineImpl();
	 	en2.insert("toto");
	 	Selection sel1 = en2.getSelection();
	 	sel1.setEndIndex(4);
	 	System.out.println(sel1.getEndIndex());
	 	sel1.setBeginIndex(0);
	 	System.out.println(sel1.getBeginIndex());
	 	
	 	en2.delete();
	 	en2.insert("lala");
	 	System.out.println(en2.getBufferContents());
	 	assertEquals("lala", en2.getBufferContents());
	 	
	 	
	 	
	 	
    }

    @Test
    void getClipboardContents() {
    	assertEquals("",engine.getClipboardContents());
    	//vue apres copie
    	EngineImpl en3= new EngineImpl();
    	en3.insert("toto");
    	Selection sel = en3.getSelection();
    	sel.setEndIndex(3);
    	sel.setBeginIndex(1);
	 	en3.copySelectedText();
    	assertEquals("ot", en3.getClipboardContents());
    	//vue apres cut-paste
    	EngineImpl en4= new EngineImpl();
    	en4.insert("toto");
    	Selection sel1 = en4.getSelection();
    	sel1.setEndIndex(3);
    	sel1.setBeginIndex(1);
	 	en4.cutSelectedText();
	 	en4.pasteClipboard();
    	assertEquals("ot", en4.getClipboardContents());
    	//vue apres double copie
    	EngineImpl en5= new EngineImpl();
    	en5.insert("toto");
    	Selection sel2 = en5.getSelection();
    	sel2.setEndIndex(3);
    	sel2.setBeginIndex(1);
	 	en5.copySelectedText();
	 	sel2.setEndIndex(4);
    	sel2.setBeginIndex(2);
	 	en5.copySelectedText();
	 	assertEquals("to", en5.getClipboardContents());
    }

    @Test
    void cutSelectedText() {
    	EngineImpl en4= new EngineImpl();
    	en4.insert("toto");
    	Selection sel2 = en4.getSelection();
    	sel2.setEndIndex(3);
    	sel2.setBeginIndex(1);
	 	en4.cutSelectedText();
	 	assertEquals("to", en4.getBufferContents());
	 	
    }

    @Test
    void copySelectedText() {
    	EngineImpl en3= new EngineImpl();
    	en3.insert("toto");
    	Selection sel = en3.getSelection();
    	sel.setEndIndex(3);
    	sel.setBeginIndex(1);
	 	en3.copySelectedText();
    	assertEquals("ot", en3.getClipboardContents());
    }

    @Test
    void pasteClipboard() {
    	EngineImpl en1 = new EngineImpl();
   	 	en1.insert("toto");
   	 	Selection sel = en1.getSelection();
   	 	sel.setEndIndex(4);
   	 	sel.setBeginIndex(0);
   	 	en1.copySelectedText();
   	 	en1.delete();
   	 	en1.pasteClipboard();
   	 	assertEquals("toto", en1.getBufferContents());
    }
}
