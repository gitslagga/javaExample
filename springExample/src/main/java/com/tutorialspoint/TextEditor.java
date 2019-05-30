package com.tutorialspoint;

public class TextEditor {
	private SpellChecker spellChecker;
	private String name;
	public TextEditor(SpellChecker spellChecker, String name) {
		this.spellChecker = spellChecker;
		this.name = name;
	}
	
	public SpellChecker getSpellChecker() {
		return this.spellChecker;
	}
	
	public String getNameString() {
		return this.name;
	}
	
	public void spellCheck() {
		spellChecker.checkSpelling();
	}
}
