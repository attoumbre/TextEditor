package fr.istic.aco.editor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    	EngineImpl en = new EngineImpl();
    	en.insert("laaa");
   	 	assertEquals("laaa", en.getBufferContents());
   	 	
   	 	EngineImpl en1 = new EngineImpl();
   	 	en1.insert("toto");
   	 	Selection sel = en1.getSelection();
   	 	sel.setBeginIndex(0);
   	 	System.out.println(sel.getBeginIndex());
   	 	sel.setEndIndex(3);
   	 	System.out.println(sel.getEndIndex());
   	 	en1.delete();
   	 	System.out.println(en1.getBufferContents());
   	 	assertEquals("o", en1.getBufferContents());
   	 	
   	 	EngineImpl en2 = new EngineImpl();
	 	en2.insert("toto");
	 	Selection sel1 = en2.getSelection();
	 	sel1.setBeginIndex(0);
	 	System.out.println(sel1.getBeginIndex());
	 	sel1.setEndIndex(4);
	 	System.out.println(sel1.getEndIndex());
	 	en2.delete();
	 	en2.insert("lala");
	 	System.out.println(en2.getBufferContents());
	 	assertEquals("lala", en2.getBufferContents());
	 	
    }

    @Test
    void getClipboardContents() {
        todo();
    }

    @Test
    void cutSelectedText() {
        todo();
    }

    @Test
    void copySelectedText() {
        todo();
    }

    @Test
    void pasteClipboard() {
        todo();
    }
}
